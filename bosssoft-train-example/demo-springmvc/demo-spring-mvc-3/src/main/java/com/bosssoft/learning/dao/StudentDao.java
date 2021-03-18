package com.bosssoft.learning.dao;

import com.bosssoft.learning.bean.Student;

import java.util.List;

/**
 * @Description DAO接口
 * @Date 2020/6/6 15:41
 * @Author HetFrame
 */
public interface StudentDao {
    Student selectById(String id);

    List<Student> selectAll();

    int insertOne(Student student);

    int updateOne(Student student);

    int deleteOneById(String id);

    int[] deleteManyByIds(Student... students);

}
