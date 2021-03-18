package com.bosssoft.learning.service;

import com.bosssoft.learning.bean.Student;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Description 测试实验3
 * @Date 2020/6/29 11:48
 * @Author HetFrame
 */
@Slf4j
public class Lab3StudentServiceImplTest {
    private ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    StudentService service = context.getBean("lab3StudentService",StudentService.class);

    @Autowired
    public void setService(StudentService service) {
        this.service = service;
    }

    @Test
    public void testList(){
        log.info(service.getStudentById("123").toString());
        log.info(service.getStudentById("123").toString());
        log.info(service.getStudentById("123").toString());
        Assert.assertNotNull(log);
    }

    @Test
    public void testCache() {
        Student student = new Student("111", "111", 11);
        log.info("添加的学生:" + service.saveOneStudent(student));
        log.info(service.getStudentById("111") + "");
        log.info(service.getStudentById("111") + "");
        log.info(service.getStudentById("111") + "");
        student.setName("222");
        log.info("修改的学生"+service.updateOneStudent(student));
        log.info("修改的学生"+service.updateOneStudent(student));
        log.info("修改的学生"+service.updateOneStudent(student));
        log.info("删除的学生:" + service.removeOneStudent(new Student("111")));
        log.info(service.getStudentById("111") + "");
        log.info(service.getStudentById("111") + "");
        log.info(service.getStudentById("111") + "");
        Assert.assertNotNull(log);
    }
}
