package com.bosssoft.learning.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Description 调用服务的接口，只需要指定微服务的name就能够调用其方法
 * @Date 2020/6/22 21:06
 * @Author HetFrame
 */
@Service
@FeignClient(value = "user-service", fallback = ClientServiceHystrixImpl.class)
public interface ClientService {
    /**
     * @Description 测试方法，返回微服务的端口号
     * @date 2020/6/23 21:08
     * @return: java.lang.String
     */
    @GetMapping("/user/test")
    String test();
}
