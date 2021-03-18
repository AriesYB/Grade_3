package com.bosssoft.learning.service;

import com.bosssoft.learning.bean.Student;

import java.util.List;

/**
 * @Description student业务接口
 * @Date 2020/6/6 15:45
 * @Author HetFrame
 */
public interface StudentService {

    Student getStudent(String id);

    List<Student> getAllStudent();

    Student addStudent(Student student);

    Student removeStudent(Student student);

    Student updateStudent(Student student);

}
