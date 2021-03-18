package com.bosssoft.learning.common;

import com.bosssoft.learning.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Description test
 * @Date 2020/6/7 13:38
 * @Author HetFrame
 */
@Slf4j
public class LogAspectTest {

    private ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    private StudentService service = (StudentService) context.getBean(StudentService.class);

    @Test
    public void test() {
        service.getStudentById("123");
        Assert.assertNotNull(service);
    }
}