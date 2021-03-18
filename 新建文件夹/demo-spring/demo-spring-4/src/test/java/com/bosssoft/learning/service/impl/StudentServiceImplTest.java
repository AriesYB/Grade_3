package com.bosssoft.learning.service.impl;

import com.bosssoft.learning.bean.Student;
import com.bosssoft.learning.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @Description 测试
 * @Date 2020/6/6 17:35
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
    public void getStudentById() {
        Student student = service.getStudentById("20175058");
        log.info(student.toString());
        Assert.assertNotNull(student);
    }

    @Test
    public void listStudentAll() {
        List<Student> list = service.listStudentAll();
        log.info(list.toString());
        Assert.assertNotNull(list);
    }

    @Test
    public void saveStudent() {
        Student student = new Student("20175059", "张三", 20);
        log.info("" + service.removeStudent(student));
        log.info("" + service.saveStudent(student));
    }

    @Test
    public void removeStudent() {
        Student student = new Student("100", "张三0", 20);
        log.info("" + service.saveStudent(student));
        Student student1 = new Student("100");
        log.info("" + service.removeStudent(student1));
        Assert.assertNotNull(student);
    }

    @Test
    public void updateStudent() {
        Student student = new Student("20175060", "李四一", 25);
        log.info("" + service.updateStudent(student));
        Assert.assertNotNull(student);
    }

    @Test
    public void testRemoveStudent() {
        Student student1 = new Student("01", "洞幺", 1);
        Student student2 = new Student("02", "洞两", 2);
        Student student3 = new Student("03", "洞三", 3);
        service.saveStudent(student1);
        service.saveStudent(student2);
        service.saveStudent(student3);
        boolean[] results = service.removeStudent(student1, student2, student3);
        for (boolean result : results) {
            log.info("处理结果" + result);
        }
        Assert.assertNotNull(student1);
    }

    @Test
    public void testRemoveTransaction() {
        Student student = new Student("01", "洞幺", 1);
        service.saveStudent(student);
        try {
            log.info("删除是否成功:" + service.removeStudent(student));
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        log.info("查询学生看是否回滚:" + service.getStudentById(student.getId()));
        Assert.assertNotNull(student);
    }
}