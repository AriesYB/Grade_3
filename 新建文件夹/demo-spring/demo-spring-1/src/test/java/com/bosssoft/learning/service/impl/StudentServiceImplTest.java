package com.bosssoft.learning.service.impl;

import com.bosssoft.learning.bean.Student;
import com.bosssoft.learning.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Description 测试
 * @Date 2020/6/9 15:35
 * @Author HetFrame
 */
@Slf4j
public class StudentServiceImplTest {

    @Test
    public void testContext() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Student student1 = (Student) context.getBean("yang");
        log.info( "application上下文   获取到的student:"+student1.toString());
        StudentService studentService1 = context.getBean(StudentService.class);
        Assert.assertNotNull(studentService1.save(student1));
        context.close();
    }
}