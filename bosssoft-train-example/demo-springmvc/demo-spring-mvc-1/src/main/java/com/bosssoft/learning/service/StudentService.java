package com.bosssoft.learning.service;

import com.bosssoft.learning.bean.Student;

import java.util.List;

/**
 * @Description student业务接口
 * @Date 2020/6/6 15:45
 * @Author HetFrame
 */
public interface StudentService {

    Student getStudentById(String id);

    List<Student> listStudentAll();

    Student saveStudent(Student student);

    Student removeStudent(Student student);

    Student updateStudent(Student student);

    boolean[] removeStudents(Student... students);
}
