package com.bosssoft.learning.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Description 用于获取restTemplate 并且使用负载均衡
 * @Date 2020/6/23 20:01
 * @Author HetFrame
 */

@Configuration
public class ConfigBean {
    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public IRule myRule() {
        //轮询规则
        return new RoundRobinRule();
    }
}
