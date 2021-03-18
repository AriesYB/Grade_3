package org.ybiao.springclouud.api.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * ClassName:ConfigBean
 * Package:org.ybiao.springclouud.api.config
 * Description:
 *
 * @Date:2020/5/5 16:52
 * @Author:HetFrame
 */
@Configuration
public class ConfigBean {
    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
