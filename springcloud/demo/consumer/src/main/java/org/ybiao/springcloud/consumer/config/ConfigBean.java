package org.ybiao.springcloud.consumer.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * ClassName:ConfigBean
 * Package:org.ybiao.springcloud.consumer.config
 * Description:
 *
 * @Date:2020/4/16 18:56
 * @Author:HetFrame
 */
@Configuration
public class ConfigBean {
//    @Bean
//    @LoadBalanced
//    public RestTemplate getRestTemplate()
//    {
//        return new RestTemplate();
//    }
    @Bean
    public IRule myRule(){
        return new RoundRobinRule();//轮询规则
    }
}
