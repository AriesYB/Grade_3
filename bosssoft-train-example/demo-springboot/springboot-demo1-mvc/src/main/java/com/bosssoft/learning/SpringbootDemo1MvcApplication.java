package com.bosssoft.learning;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * @Description 业务实现
 * @Date 2020/6/10 20:47
 * @Author HetFrame
 */
@MapperScan("com.bosssoft.learning.mapper")
@SpringBootApplication
public class SpringbootDemo1MvcApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootDemo1MvcApplication.class, args);
    }

}
