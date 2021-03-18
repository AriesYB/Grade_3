package com.bosssoft.hr.train.j2se.basic.example.database;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description: 我是工具类并且我不喜欢被继承 final 保护了我免于继承，private 保护我被创建
 * @author: Administrator
 * @create: 2020-05-28 20:45
 * @since
 **/
public final class DBUtil {
    private static DBUtil dbUtil;
    private static final String URL = "jdbc:mysql://47.93.191.78:3307/test?useSSL=false&serverTimezone=UTC&characterEncoding=utf-8";
    private static final String USER = "root";
    private static final String PD = "476900";
    private Connection conn;
    private Statement stat;
    private ResultSet rs;

    private DBUtil() {

    }

    public static DBUtil newInstance() {
        if (dbUtil == null) {
            dbUtil = new DBUtil();
        }
        return dbUtil;
    }

    /**
     * @Description 建立连接
     * @Param []
     * @Return void
     */
    public void getConn() throws SQLException {
        conn = DriverManager.getConnection(URL, USER, PD);
    }

    /**
     * @Description 释放资源
     * @Param []
     * @Return void
     */
    public void close() throws SQLException {
        if (rs != null) {
            rs.close();
        }
        if (stat != null) {
            stat.close();
        }
        if (conn != null) {
            conn.close();
        }
    }

    /**
     * @Description 执行查询方法
     * @Param [sql]
     * @Return java.util.ArrayList<?>
     */
    public List<Map<String, String>> executeQuery(String sql) throws SQLException {
        getConn();
        List<Map<String, String>> list = new ArrayList<>();
        Map<String, String> map;
        stat = conn.createStatement();
        rs = stat.executeQuery(sql);
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
        close();
        return list;
    }

    /**
     * @Description 执行更新语句
     * @Param [sql]
     * @Return int
     */
    public int executeUpdate(String sql) throws SQLException {
        getConn();
        stat = conn.createStatement();
        int count = stat.executeUpdate(sql);
        close();
        return count;
    }
}
