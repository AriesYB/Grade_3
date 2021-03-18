package com.bosssoft.hr.train.jsp.example.util;

import lombok.extern.slf4j.Slf4j;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description: 我是工具类并且我不喜欢被继承 final 保护了我免于继承，private 保护我被创建
 * @author: Administrator
 * @create: 2020-05-28 20:45
 **/
@Slf4j
public final class DBUtil {

    private static DBUtil dbUtil;
    private static final String URL = "jdbc:mysql://47.93.191.78:3307/test?useSSL=false&serverTimezone=UTC&characterEncoding=utf-8";
    private static final String USERNAME = "root";
    private static final String PD = "476900";
    private Connection conn;
    private ResultSet rs;
    private PreparedStatement pst;

    private DBUtil() {

    }

    /**
     * @Description 单例模式
     * @Param []
     * @Return com.bosssoft.hr.train.jsp.example.util.DBUtil
     */
    public static DBUtil getInstance() {
        if (dbUtil == null) {
            dbUtil = new DBUtil();
        }
        return dbUtil;
    }

    /**
     * @Description 创建连接
     * @Param []
     * @Return void
     */
    private void createConn() {
        try {
            conn = DriverManager.getConnection(URL, USERNAME, PD);
        } catch (SQLException e) {
            log.error(e.getMessage());
        }
    }

    /**
     * @Description 关闭所有连接，释放资源
     * @Param []
     * @Return void
     */
    private void closeAll() {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                log.error(e.getMessage());
            }
        }
        if (pst != null) {
            try {
                pst.close();
            } catch (SQLException e) {
                log.error(e.getMessage());
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                log.error(e.getMessage());
            }
        }
    }

    /**
     * @Description 执行查询方法
     * @Param [sql]
     * @Return java.util.ArrayList<?>
     */
    public List<Map<String, String>> executeQuery(String sql, Object... args) {
        createConn();
        List<Map<String, String>> list = null;
        Map<String, String> map;
        try {
            list = new ArrayList<>();
            pst = conn.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                pst.setObject(i + 1, args[i]);
            }
            rs = pst.executeQuery();
            while (rs.next()) {
                map = new HashMap<>();
                //遍历该行的每一列
                for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                    //列名为键的Hashmap
                    map.put(rs.getMetaData().getColumnName(i), rs.getString(i));
                }
                //再放入集合
                list.add(map);
            }
        } catch (SQLException e) {
            log.error(e.getMessage());
        }
        closeAll();
        return list;
    }

    /**
     * @Description 执行更新语句
     * @Param [sql]
     * @Return int
     */
    public int executeUpdate(String sql, Object... args) {
        createConn();
        int count = 0;
        try {
            pst = conn.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                pst.setObject(i + 1, args[i]);
            }
            count = pst.executeUpdate();
        } catch (SQLException e) {
            log.error(e.getMessage());
        }
        closeAll();
        return count;
    }

}
