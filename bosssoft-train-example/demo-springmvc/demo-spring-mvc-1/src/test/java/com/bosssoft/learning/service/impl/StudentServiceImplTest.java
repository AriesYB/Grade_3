package com.bosssoft.learning.service.impl;

import com.bosssoft.learning.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Description test
 * @Date 2020/6/7 17:26
 * @Author HetFrame
 */
@Slf4j
public class StudentServiceImplTest {

    private ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    private StudentService service = context.getBean(StudentService.class);

    @Test
    public void getStudentById() {
        log.info(service.getStudentById("123")+"---");
        Assert.assertNotNull(log);
    }
}