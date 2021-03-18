package com.bosssoft.hr.train.jsp.example.util;

import com.bosssoft.hr.train.jsp.example.service.UserService;
import com.bosssoft.hr.train.jsp.example.service.UserServiceImpl;

/**
 * @Description 调用service
 * @Date 2020/6/3 15:43
 * @Author HetFrame
 */
public final class ServiceUtil {
    private static final UserService userService = new UserServiceImpl();

    private ServiceUtil() {
    }

    public static UserService getUserServiceInstance() {
        return userService;
    }

}
