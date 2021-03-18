package com.bosssoft.learning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author Administrator
 */
@EnableScheduling
@SpringBootApplication
public class SpringbootDemo4QuartzScheduleApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootDemo4QuartzScheduleApplication.class, args);
    }

}
