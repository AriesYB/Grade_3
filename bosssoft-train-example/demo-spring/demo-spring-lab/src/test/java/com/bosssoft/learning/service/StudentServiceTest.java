package com.bosssoft.learning.service;

import com.bosssoft.learning.bean.Student;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Description 测试
 * @Date 2020/6/29 11:14
 * @Author HetFrame
 */
@Slf4j
public class StudentServiceTest {

    private ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    StudentService lab5Service = context.getBean("lab5StudentService",StudentService.class);

    @Test
    public void testLab1() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("lab1ApplicationContext.xml");
        Student student1 = (Student) context.getBean("yang");
        log.info( "application上下文   获取到的student:"+student1.toString());
        Lab1StudentService studentService1 = context.getBean(Lab1StudentService.class);
        studentService1.save(student1);
        context.close();
    }

    @Test
    public void testLab2() {
        ApplicationContext context = new ClassPathXmlApplicationContext("lab2ApplicationContext.xml");
        for (int i = 0; i < 3; i++) {
            Lab2StudentService service = (Lab2StudentService) context.getBean("lab2StudentService");
            log.info("单例的service:" + service);
        }
        for (int i = 0; i < 3; i++) {
            Lab2StudentService service2 = (Lab2StudentService) context.getBean("lab2StudentServicePrototype");
            log.info("多例的service:" + service2);
        }
    }

    @Test
    public void testLab5() {
        log.info("查询student:{}",lab5Service.getStudentById("20175058"));
    }
}