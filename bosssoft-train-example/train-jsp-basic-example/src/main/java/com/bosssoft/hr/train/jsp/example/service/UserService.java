package com.bosssoft.hr.train.jsp.example.service;

import com.bosssoft.hr.train.jsp.example.pojo.User;

import java.util.List;

/**
 * @description: 用户服务的接口
 * @author: Administrator
 * @create: 2020-05-30 10:17
 **/
public interface UserService {
    boolean save(User user);
    boolean remove(User user);
    boolean update(User user);
    List<User> queryByCondition(User user);
    List<User> listAll();
    User authentication(User user);

}
