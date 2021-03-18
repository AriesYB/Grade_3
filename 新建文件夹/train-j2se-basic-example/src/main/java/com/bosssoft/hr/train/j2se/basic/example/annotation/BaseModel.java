package com.bosssoft.hr.train.j2se.basic.example.annotation;

import com.bosssoft.hr.train.j2se.basic.example.database.DBUtil;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
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

    enum sqlHead {
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
        QUERY("select * from");

        private String code;

        private sqlHead(String s) {
            code = s;
        }

        public String getCode() {
            return code;
        }
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
                .append(tableName)
                .append(" (");
        return sb;
    }


    public int save() {
        StringBuilder sb = getString(sqlHead.INSERT.getCode());
        if (sb == null || sb.length() == 0) {
            return 0;
        }
        Class<?> beanClass = this.getClass();
        //获取类里面的所有字段
        Field[] fields = beanClass.getDeclaredFields();
        int i = 0;
        int length = fields.length;
        for (Field field : fields) {
            //判断字段上是否有Colomn 注解
            boolean fieldPresent = field.isAnnotationPresent(Column.class);
            //如果不存在，跳过这个字段继续下一个循环
            if (!fieldPresent) {
                continue;
            }
            //获取到 Column
            Column column = field.getAnnotation(Column.class);
            //获取 Column 的名称，如（user_name）
            String columnName = column.value();
            //如果有值则添加 and 语句
            sb.append(columnName);
            if (i != length - 1) {
                sb.append(",");
            } else {
                sb.append(") ");
            }
            i++;
        }
        i = 0;
        sb.append("values(");
        //遍历所有字段
        for (Field field : fields) {
            //判断字段上是否有Colomn 注解
            boolean fieldPresent = field.isAnnotationPresent(Column.class);
            //如果不存在，跳过这个字段继续下一个循环
            if (!fieldPresent) {
                continue;
            }
            //获取字段的名称,如 useName
            String fieldName = field.getName();
            //通过该字段的get方法名
            String fieldGetName = "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
            Object value = null;
            try {
                //获取到get方法
                Method method = beanClass.getMethod(fieldGetName);
                //反射调用该字段的get方法，获取到该字段的值
                value = method.invoke(this);

            } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                log.error(e.getLocalizedMessage());
            }
            //如果不为空，则开始添加 and 语句
            if (value == null || ((value instanceof Integer) && (Integer) value == 0)) {
                continue;
            }
            //如果这个字段是int类型
            if (value instanceof Integer || value instanceof Long) {
                sb.append(value);
            } else if (value instanceof String) {
                sb.append("'").append(value).append("'");
            }
            if (i != length - 1) {
                sb.append(",");
            } else {
                sb.append(") ");
            }
            i++;
        }
        int result = 0;
        try {
            result = DBUtil.newInstance().executeUpdate(sb.toString());
        } catch (SQLException e) {
            log.error(e.getMessage());
        }
        return result;
    }

    public int update() {
        StringBuilder sb = getString(sqlHead.INSERT.getCode());
        if (sb == null || sb.length() == 0) {
            return 0;
        }
        Class<?> beanClass = this.getClass();
        //获取类里面的所有字段
        Field[] fields = beanClass.getDeclaredFields();
        int i = 0;
        int length = fields.length;
        //遍历所有字段
        for (Field field : fields) {
            //判断字段上是否有Colomn 注解
            boolean fieldPresent = field.isAnnotationPresent(Column.class);
            //如果不存在，跳过这个字段继续下一个循环
            if (!fieldPresent) {
                continue;
            }
            //获取到 Column
            Column column = field.getAnnotation(Column.class);
            //获取 Column 的名称，如（user_name）
            String columnName = column.value();
            //获取字段的名称,如 useName
            String fieldName = field.getName();
            //通过该字段的get方法名
            String fieldGetName = "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
            Object value = null;
            try {
                //获取到get方法
                Method method = beanClass.getMethod(fieldGetName);
                //反射调用该字段的get方法，获取到该字段的值
                value = method.invoke(this);
            } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                log.error(e.getLocalizedMessage());
            }
            //如果不为空，则开始添加 and 语句
            if (value == null || ((value instanceof Integer) && (Integer) value == 0)) {
                continue;
            }
            //如果有值则添加 and 语句
            sb.append(" ")
                    .append(columnName);
            //如果这个字段是int类型
            if (value instanceof Integer || value instanceof Long) {
                sb.append("=").append(value);
            } else if (value instanceof String) {
                sb.append("='").append(value).append("'");
            }
            if (i != length - 1) {
                sb.append(",");
            }
            i++;
        }
        boolean idPresent;
        for (Field field : fields) {
            //判断字段上是否有id 注解
            idPresent = field.isAnnotationPresent(Id.class);
            //如果不存在，跳过这个字段继续下一个循环
            if (!idPresent) {
                continue;
            }
            //获取到 Id
            Id id = field.getAnnotation(Id.class);
            //获取 Id 的名称，如（user_id）
            String idName = id.value();
            String fieldName = field.getName();
            //通过该字段的get方法名
            String fieldGetName = "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
            Object value = null;
            try {
                //获取到get方法
                Method method = beanClass.getMethod(fieldGetName);
                //反射调用该字段的get方法，获取到该字段的值
                value = method.invoke(this);

            } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                log.error(e.getLocalizedMessage());
            }
            //如果不为空，则开始添加 and 语句
            if (value == null || ((value instanceof Integer) && (Integer) value == 0)) {
                continue;
            }
            //如果有值则添加 and 语句
            sb.append(" where ")
                    .append(idName);
            //如果这个字段是int类型
            if (value instanceof Integer || value instanceof Long) {
                sb.append("=").append(value);
            } else if (value instanceof String) {
                sb.append("='").append(value);
            }
        }
        try {
            return DBUtil.newInstance().executeUpdate(sb.toString());
        } catch (SQLException e) {
            log.error(e.getMessage());
        }
        return 0;
    }

    public int remove() {
        StringBuilder sb = getString(sqlHead.INSERT.getCode());
        if (sb == null || sb.length() == 0) {
            return 0;
        }
        Class<?> beanClass = this.getClass();
        //获取该 class上 table 注解
        Table table = beanClass.getAnnotation(Table.class);
        //获取表名
        String tableName = table.value();
        sb.append("delete from ")
                .append(tableName);
        //获取类里面的所有字段
        Field[] fields = beanClass.getDeclaredFields();
        //遍历所有字段
        for (Field field : fields) {
            //判断字段上是否有id 注解
            boolean idPresent = field.isAnnotationPresent(Id.class);
            //如果不存在，跳过这个字段继续下一个循环
            if (!idPresent) {
                continue;
            }
            //获取到 Id
            Id id = field.getAnnotation(Id.class);
            //获取 Id 的名称，如（user_id）
            String idName = id.value();
            String fieldName = field.getName();
            //通过该字段的get方法名
            String fieldGetName = "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
            Object value = null;
            try {
                //获取到get方法
                Method method = beanClass.getMethod(fieldGetName);
                //反射调用该字段的get方法，获取到该字段的值
                value = method.invoke(this);
            } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                log.error(e.getMessage());
            }
            //如果不为空，则开始添加 and 语句
            if (value == null || ((value instanceof Integer) && (Integer) value == 0)) {
                continue;
            }
            //如果有值则添加 and 语句
            sb.append(" where ")
                    .append(idName);
            //如果这个字段是int类型
            if (value instanceof Integer || value instanceof Long) {
                sb.append("=").append(value);
            } else if (value instanceof String) {
                sb.append("='").append(value);
            }
        }
        try {
            return DBUtil.newInstance().executeUpdate(sb.toString());
        } catch (SQLException e) {
            log.error(e.getMessage());
        }
        return 0;
    }

    public List<Map<String, String>> query() {
        StringBuilder sb = getString(sqlHead.INSERT.getCode());
        if (sb == null || sb.length() == 0) {
            return new ArrayList<>();
        }
        Class<?> beanClass = this.getClass();
        //获取类里面的所有字段
        Field[] fields = beanClass.getDeclaredFields();
        boolean idPresent;
        for (Field field : fields) {
            //判断字段上是否有id 注解
            idPresent = field.isAnnotationPresent(Id.class);
            //如果不存在，跳过这个字段继续下一个循环
            if (!idPresent) {
                continue;
            }
            //获取到 Id
            Id id = field.getAnnotation(Id.class);
            //获取 Id 的名称，如（user_id）
            String idName = id.value();
            String fieldName = field.getName();
            //通过该字段的get方法名
            String fieldGetName = "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
            Object value = null;
            try {
                //获取到get方法
                Method method = beanClass.getMethod(fieldGetName);
                //反射调用该字段的get方法，获取到该字段的值
                value = method.invoke(this);
            } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                log.error(e.getLocalizedMessage());
            }
            //如果不为空，则开始添加 and 语句
            if (value == null || ((value instanceof Integer) && (Integer) value == 0)) {
                continue;
            }
            //如果有值则添加 and 语句
            sb.append("where ")
                    .append(idName);
            //如果这个字段是int类型
            if (value instanceof Integer || value instanceof Long) {
                sb.append("=").append(value);
            } else if (value instanceof String) {
                sb.append("='").append(value).append("'");
            }
        }
        //遍历所有字段
        boolean fieldPresent;
        for (Field field : fields) {
            //判断字段上是否有Colomn 注解
            fieldPresent = field.isAnnotationPresent(Column.class);
            //如果不存在，跳过这个字段继续下一个循环
            if (!fieldPresent) {
                continue;
            }
            //获取到 Column
            Column column = field.getAnnotation(Column.class);
            //获取 Column 的名称，如（user_name）
            String columnName = column.value();
            //获取字段的名称,如 useName
            String fieldName = field.getName();
            //通过该字段的get方法名
            String fieldGetName = "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
            Object value = null;
            try {
                //获取到get方法
                Method method = beanClass.getMethod(fieldGetName);
                //反射调用该字段的get方法，获取到该字段的值
                value = method.invoke(this);
            } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                log.error(e.getLocalizedMessage());
            }
            //如果不为空，则开始添加 and 语句
            if (value == null || ((value instanceof Integer) && (Integer) value == 0)) {
                continue;
            }
            //如果有值则添加 and 语句
            sb.append(" ")
                    .append("and").append(" ")
                    .append(columnName);
            //如果这个字段是int类型
            if (value instanceof Integer || value instanceof Long) {
                sb.append("=").append(value);
            } else if (value instanceof String) {
                sb.append("='").append(value).append("'");
            }
        }
        try {
            return DBUtil.newInstance().executeQuery(sb.toString());
        } catch (SQLException e) {
            log.error(e.getMessage());
        }
        return new ArrayList<>();
    }
}
