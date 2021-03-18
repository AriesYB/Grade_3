package com.bosssoft.learning.service.impl;

import com.bosssoft.learning.mapper.UserMapper;
import com.bosssoft.learning.model.User;
import com.bosssoft.learning.model.UserDO;
import com.bosssoft.learning.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Description 业务实现
 * @Date 2020/6/10 20:47
 * @Author HetFrame
 */
@Service
public class UserServiceImpl implements UserService {
    private UserMapper userMapper;

    @Autowired
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public User getUser(String id) {
        return userMapper.selectUser(id);
    }

    public List<User> listUserAll() {
        return userMapper.selectUserByCondition(new ArrayList<Map<String, String>>());
    }

    public List<User> listUserByCondition() {
        return new ArrayList<User>();
    }

    public User saveUser(User user) {
        return userMapper.insertUser(new UserDO(user)) == 1 ? user : null;
    }

    public User removeUser(User user) {
        return userMapper.deleteUser(new UserDO(user)) == 1 ? user : null;
    }

    public User updateUser(User user) {
        return userMapper.updateUser(new UserDO(user)) == 1 ? user : null;
    }
}
