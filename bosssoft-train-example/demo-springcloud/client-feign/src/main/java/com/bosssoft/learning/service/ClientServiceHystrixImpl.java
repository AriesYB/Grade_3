package com.bosssoft.learning.service;

import org.springframework.stereotype.Component;

/**
 * @Description 断路器
 * @Date 2020/6/22 21:32
 * @Author HetFrame
 */
@Component
public class ClientServiceHystrixImpl implements ClientService {
    private static final String SERVICE_UNAVAILABLE = "当前服务不可用!";

    @Override
    public String test() {
        return SERVICE_UNAVAILABLE;
    }
}
