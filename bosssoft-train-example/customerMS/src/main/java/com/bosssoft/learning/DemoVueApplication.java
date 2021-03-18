package com.bosssoft.learning;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Description demo后端
 * @Date 2020/6/16 11:44
 * @Author HetFrame
 */
@MapperScan("com.bosssoft.learning.dao")
@SpringBootApplication
public class DemoVueApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoVueApplication.class, args);
    }

}
