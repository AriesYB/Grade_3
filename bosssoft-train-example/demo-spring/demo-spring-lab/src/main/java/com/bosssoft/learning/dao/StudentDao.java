package com.bosssoft.learning.dao;

import com.bosssoft.learning.bean.Student;

import java.util.List;

/**
 * @Description DAO接口
 * @Date 2020/6/6 15:41
 * @Author HetFrame
 */
public interface StudentDao {
    Student selectStudentById(String id);

    List<Student> selectAllStudents();

    int insertStudentOne(Student student);

    int updateStudentOne(Student student);

    int deleteStudentOne(String id);

    int[] deleteStudentsMany(Student... students);

}
