package com.bosssoft.learning.service;

import com.bosssoft.learning.model.User;

import java.util.List;

/**
 * @Description user查询接口 使用类做为返回值是因为可以使用缓存。
 * @Date 2020/6/10 20:33
 * @Author HetFrame
 */
public interface UserService {

    /**
     * @Description 通过id获取用户
     * @Param [id]
     * @Return com.bosssoft.learning.model.User
     */
    User getUser(String id);

    /**
     * @Description 获取全部用户
     * @Param []
     * @Return java.util.List<com.bosssoft.learning.model.User>
     */
    List<User> listUserAll();

    List<User> listUserByCondition();

    /**
     * @Description 保存用户
     * @Param [user]
     * @Return com.bosssoft.learning.model.User
     */
    User saveUser(User user);

    /**
     * @Description 删除用户
     * @Param [user]
     * @Return com.bosssoft.learning.model.User
     */
    User removeUser(User user);

    /**
     * @Description 更新用户
     * @Param [user]
     * @Return com.bosssoft.learning.model.User
     */
    User updateUser(User user);
}
