package com.bosssoft.learning.service.impl;

import com.bosssoft.learning.bean.Student;
import com.bosssoft.learning.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Description test
 * @Date 2020/6/6 23:22
 * @Author HetFrame
 */
@Slf4j
public class StudentServiceImplTest {

    private ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    StudentService service = context.getBean(StudentService.class);

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
        log.info("添加的学生:" + service.saveStudent(student));
        log.info(service.getStudentById("111") + "");
        log.info(service.getStudentById("111") + "");
        log.info(service.getStudentById("111") + "");
        student.setName("222");
        log.info("修改的学生"+service.updateStudent(student));
        log.info("修改的学生"+service.updateStudent(student));
        log.info("修改的学生"+service.updateStudent(student));
        log.info("删除的学生:" + service.removeStudent(new Student("111")));
        log.info(service.getStudentById("111") + "");
        log.info(service.getStudentById("111") + "");
        log.info(service.getStudentById("111") + "");
        Assert.assertNotNull(log);
    }

}