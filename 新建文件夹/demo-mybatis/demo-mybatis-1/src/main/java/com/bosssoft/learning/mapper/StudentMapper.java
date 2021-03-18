package com.bosssoft.learning.mapper;

import com.bosssoft.learning.model.Student;

/**
 * @Description studentDao接口
 * @Date 2020/6/8 18:03
 * @Author HetFrame
 */
public interface StudentMapper {
    Student queryById(String id);
}
