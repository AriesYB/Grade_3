package com.bosssoft.hr.train.jsp.example.dao.impl;

import com.bosssoft.hr.train.jsp.example.dao.UserDao;
import com.bosssoft.hr.train.jsp.example.pojo.User;
import com.bosssoft.hr.train.jsp.example.util.DBUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: Administrator
 * @create: 2020-05-30 10:42
 **/
@Slf4j
public class UserDaoImpl implements UserDao {

    private static final String ID = "id";
    private static final String NAME = "name";
    private static final String CODE = "code";
    private static final String PASSWORD = "password";

    @Override
    public int insert(User user) {
        String sql = "insert into user(id, name, code, password) values(?, ?, ?, ?)";
        int result;
        result = DBUtil.getInstance().executeUpdate(sql, user.getId(), user.getName(), user.getCode(), user.getPassword());
        return result;
    }

    @Override
    public int deleteById(Integer id) {
        String sql = "delete from user where id=?";
        int result;
        result = DBUtil.getInstance().executeUpdate(sql, id);
        return result;
    }

    @Override
    public int update(User user) {
        String sql = "update user set id=?,name=?,code=?,password=? where id=?";
        int result;
        result = DBUtil.getInstance().executeUpdate(sql, user.getId(), user.getName(), user.getCode(), user.getPassword(), user.getId());
        return result;
    }

    @Override
    public List<User> queryAll() {
        String sql = "select * from user";
        List<Map<String, String>> mapList;
        List<User> userList = new ArrayList<>();
        mapList = DBUtil.getInstance().executeQuery(sql);
        if (mapList == null) {
            mapList = new ArrayList<>();
        }
        for (Map<String, String> map : mapList) {
            userList.add(new User(Integer.valueOf(map.get(ID)), map.get(NAME), map.get(CODE), map.get(PASSWORD)));
        }
        return userList;
    }

    @Override
    public List<User> queryByCondition(User user) {
        String sql = "select * from user where id = ?";
        List<Map<String, String>> mapList;
        List<User> userList = new ArrayList<>();
        mapList = DBUtil.getInstance().executeQuery(sql, user.getId());
        if (mapList == null) {
            mapList = new ArrayList<>();
        }
        for (Map<String, String> map : mapList) {
            userList.add(new User(Integer.valueOf(map.get(ID)), map.get(NAME), map.get(CODE), map.get(PASSWORD)));
        }
        return userList;
    }

    @Override
    public User queryByCode(User user) {
        String sql = "select * from user where code = ? and password=?";
        List<Map<String, String>> mapList;
        mapList = DBUtil.getInstance().executeQuery(sql, user.getCode(), user.getPassword());
        if (mapList != null && !mapList.isEmpty()) {
            return new User(Integer.valueOf(mapList.get(0).get(ID)), mapList.get(0).get(NAME), mapList.get(0).get(CODE), mapList.get(0).get(PASSWORD));
        }
        return null;
    }
}
