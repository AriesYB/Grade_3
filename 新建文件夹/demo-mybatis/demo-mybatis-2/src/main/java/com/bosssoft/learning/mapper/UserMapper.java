package com.bosssoft.learning.mapper;

import com.bosssoft.learning.model.User;

import java.util.List;

/**
 * @Description user接口
 * @Date 2020/6/8 21:01
 * @Author HetFrame
 */
public interface UserMapper {
    User queryUser(String id);

    List<User> queryUserAll();
}
