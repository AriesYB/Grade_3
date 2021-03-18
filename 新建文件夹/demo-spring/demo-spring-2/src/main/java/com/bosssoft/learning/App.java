package com.bosssoft.learning;

import com.bosssoft.learning.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Description 主程序
 * @Date 2020/6/5 19:42
 * @Author HetFrame
 */
@Slf4j
public class App {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        for (int i = 0; i < 3; i++) {
            StudentService service = (StudentService) context.getBean("studentService");
            log.info("单例的service:" + service);
        }
        for (int i = 0; i < 3; i++) {
            StudentService service2 = (StudentService) context.getBean("studentService2");
            log.info("多例的service:" + service2);
        }


    }
}
