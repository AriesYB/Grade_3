package com.bosssoft.hr.train.j2se.basic.example.proxy;

import com.bosssoft.hr.train.j2se.basic.example.pojo.User;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Description TODO
 * @Date 2020/6/5 9:50
 * @Author HetFrame
 */
public class JDKProxyTest {

    @Test
    public void proxy() {
        UserService userService = new UserServiceImpl();
        JDKProxy proxy = new JDKProxy();
        UserService userServiceProxy = (UserService) proxy.newInstance(userService);
        User user = new User(1, "张三");
        userServiceProxy.saveUser(user);
        assertNotNull(user);
    }

}