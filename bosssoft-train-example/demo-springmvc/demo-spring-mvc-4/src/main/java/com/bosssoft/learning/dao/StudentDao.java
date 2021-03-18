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

    List<Student> selectAllStudent();

    int insertStudentInfo(Student student);

    int updateStudentInfo(Student student);

    int deleteStudentInfo(String id);

    int[] deleteStudentsInfos(Student... students);

}
