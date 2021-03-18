package com.bosssoft.hr.train.jsp.example.service;

import com.bosssoft.hr.train.jsp.example.dao.UserDao;
import com.bosssoft.hr.train.jsp.example.dao.impl.UserDaoImpl;
import com.bosssoft.hr.train.jsp.example.pojo.User;

import java.util.List;

/**
 * @description:
 * @author: Administrator
 * @create: 2020-05-30 10:24
 **/

public class UserServiceImpl implements UserService {
    private final UserDao userDao = new UserDaoImpl();

    @Override
    public boolean save(User user) {
        int result = userDao.insert(user);
        return result == 1;
    }

    @Override
    public boolean remove(User user) {
        int result = userDao.deleteById(user.getId());
        return result == 1;
    }

    @Override
    public boolean update(User user) {
        int result = userDao.update(user);
        return result == 1;
    }

    @Override
    public List<User> queryByCondition(User user) {
        return userDao.queryByCondition(user);
    }

    @Override
    public List<User> listAll() {
        return userDao.queryAll();
    }

    @Override
    public User authentication(User user) {
        return userDao.queryByCode(user);
    }
}
