package com.bosssoft.learning.dao;

import com.bosssoft.learning.bean.Student;

import java.util.List;

/**
 * @Description DAO接口
 * @Date 2020/6/6 15:41
 * @Author HetFrame
 */
public interface StudentDao {
    Student queryById(String id);

    List<Student> queryAll();

    int insert(Student student);

    int update(Student student);

    int deleteById(String id);

    int[] deleteByIds(Student... students);

}
