package com.bosssoft.learning.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @Description 消费者服务
 * @Date 2020/6/23 19:57
 * @Author HetFrame
 */
@Service
public class ClientService {
    private static final String SERVICE_UNAVAILABLE = "当前服务不可用!";
    private static final String URL = "http://user-service";
    private RestTemplate restTemplate;

    @Autowired
    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @HystrixCommand(fallbackMethod = "error")
    public String test() {
        return restTemplate.getForObject(URL + "/user/test", String.class);
    }

    public String error() {
        return SERVICE_UNAVAILABLE;
    }

}
