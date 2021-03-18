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

    boolean saveStudent(Student student);

    boolean removeStudent(Student student);

    boolean updateStudent(Student student);

    boolean[] removeStudent(Student... students);
}
