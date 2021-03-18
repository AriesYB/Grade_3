package com.bosssoft.learning.dao;

import com.bosssoft.learning.bean.Student;

import java.util.List;

/**
 * @Description DAO接口
 * @Date 2020/6/6 15:41
 * @Author HetFrame
 */
public interface StudentDao {
    Student queryStudent(String id);

    List<Student> queryStudentAll();

    int insertStudent(Student student);

    int updateStudent(Student student);

    int deleteStudent(String id);

    int[] deleteStudents(Student... students);

}
