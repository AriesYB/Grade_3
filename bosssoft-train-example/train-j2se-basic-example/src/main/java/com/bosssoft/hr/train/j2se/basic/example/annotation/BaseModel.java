package com.bosssoft.hr.train.j2se.basic.example.annotation;

import com.bosssoft.hr.train.j2se.basic.example.database.DBUtil;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @param
 * @description:
 * @author: HetFrame
 * @create: 2020-05-30 22:41
 * @since
 **/
@Slf4j
public abstract class BaseModel {

    enum sqlPart {
        /**
         * insert头部
         */
        INSERT("insert into"),
        /**
         * update头部
         */
        UPDATE("update "),
        /**
         * delete头部
         */
        DELETE("delete from"),
        /**
         * select头部
         */
        QUERY("select * from"),

        SET(" set "),

        WHERE(" where ");


        private final String code;

        private sqlPart(String s) {
            code = s;
        }

        public String getCode() {
            return code;
        }
    }

    private final Field[] fields = this.getClass().getDeclaredFields();

    private StringBuilder getFieldValue(Field field) {
        StringBuilder sb = new StringBuilder();
        String fieldName = field.getName();
        String getMethodName = "get" + fieldName.substring(0, 1).toUpperCase() +
                fieldName.substring(1);
        Object fieldValue = null;
        try {
            Method m = this.getClass().getMethod(getMethodName);
            fieldValue = m.invoke(this);
        } catch (Exception e) {
            log.info(String.valueOf(e));
        }
        if (fieldValue instanceof String) {
            sb.append("'").append(fieldValue).append("'");
        } else if (fieldValue instanceof Integer) {
            sb.append(fieldValue);
        }
        return sb;
    }


    private StringBuilder getString(String sql) {
        StringBuilder sb = new StringBuilder();
        //首先获取 bean 类的 class
        Class<?> beanClass = this.getClass();
        //判断该 class 上是否有 table 注解
        boolean present = beanClass.isAnnotationPresent(Table.class);
        if (!present) {
            return null;
        }
        //获取该 class上 table 注解
        Table table = beanClass.getAnnotation(Table.class);
        //获取表名
        String tableName = table.value();
        sb.append(sql)
                .append(" ")
                .append(tableName);
        return sb;
    }


    public int save() {
        StringBuilder sb = getString(sqlPart.INSERT.getCode());
        StringBuilder sb1 = new StringBuilder();
        if (sb == null || sb.length() == 0) {
            return 0;
        }
        sb.append("(");
        sb1.append("(");
        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];
            if (field.isAnnotationPresent(Id.class)) {
                Id aId = field.getAnnotation(Id.class);
                String idName = aId.value();
                sb.append(idName).append(",");
                getFieldValue(field);
                sb1.append(getFieldValue(field)).append(",");
            } else if (field.isAnnotationPresent(Column.class)) {
                Column aCol = field.getAnnotation(Column.class);
                String colName = aCol.value();
                sb.append(colName).append(",");
                getFieldValue(field);
                sb1.append(getFieldValue(field)).append(",");
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        sb1.deleteCharAt(sb1.length() - 1);
        sb.append(" ) values ");
        sb1.append(")");
        sb.append(sb1);
        int result = 0;
        log.info("插入的sql:" + sb);
        try {
            result = DBUtil.newInstance().executeUpdate(sb.toString());
        } catch (SQLException e) {
            log.error(e.getMessage());
        }
        return result;
    }

    public int update() {
        StringBuilder sb = getString(sqlPart.UPDATE.getCode());
        StringBuilder sb1 = new StringBuilder();
        if (sb == null || sb.length() == 0) {
            return 0;
        }
        sb.append(sqlPart.SET.getCode());
        for (Field field : fields) {
            if (field.isAnnotationPresent(Id.class)) {
                Id aId = field.getAnnotation(Id.class);
                String idName = aId.value();
                sb1.append(idName).append("=").append(getFieldValue(field));
            } else if (field.isAnnotationPresent(Column.class)) {
                Column aCol = field.getAnnotation(Column.class);
                String colName = aCol.value();
                sb.append(colName).append("=").append(getFieldValue(field)).append(",");
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append(sqlPart.WHERE.getCode()).append(sb1);
        log.info("更新的sql:" + sb);
        try {
            return DBUtil.newInstance().executeUpdate(sb.toString());
        } catch (SQLException e) {
            log.error(e.getMessage());
        }
        return 0;
    }

    public int remove() {
        StringBuilder stringBuilder = getString(sqlPart.DELETE.getCode());
        if (stringBuilder == null || stringBuilder.length() == 0) {
            return 0;
        }
        stringBuilder.append(sqlPart.WHERE.getCode());
        for (Field field:fields){
            if (field.isAnnotationPresent(Id.class)){
                Id aId = field.getAnnotation(Id.class);
                String idName = aId.value();
                stringBuilder.append(idName).append("=").append(getFieldValue(field));
            }
        }
        log.info("删除的sql:"+stringBuilder);
        try {
            return DBUtil.newInstance().executeUpdate(stringBuilder.toString());
        } catch (SQLException e) {
            log.error(e.getMessage());
        }
        return 0;
    }

    public List<Map<String, String>> query() {
        StringBuilder string = getString(sqlPart.QUERY.getCode());
        if (string == null || string.length() == 0) {
            return new ArrayList<>();
        }
        string.append(sqlPart.WHERE.getCode());
        for (Field field:fields){
            if (field.isAnnotationPresent(Id.class)){
                Id aId = field.getAnnotation(Id.class);
                String idName = aId.value();
                string.append(idName).append("=").append(getFieldValue(field));
            }
        }
        log.info("查询的sql:"+string);
        try {
            return DBUtil.newInstance().executeQuery(string.toString());
        } catch (SQLException e) {
            log.error(e.getMessage());
        }
        return new ArrayList<>();
    }
}
