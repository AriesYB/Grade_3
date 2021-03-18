package com.bosssoft.learning.service;

import com.bosssoft.learning.bean.Student;

import java.util.List;

/**
 * @Description student业务接口
 * @Date 2020/6/6 15:45
 * @Author HetFrame
 */
public interface StudentService {
    /**
     * @param id
     * @Description 通过id获取
     * @date 2020/6/29 12:28
     * @return: com.bosssoft.learning.bean.Student
     */
    Student getStudentById(String id);

    /**
     * @Description 获取所有学生
     * @date 2020/6/29 12:29
     * @return: java.util.List<com.bosssoft.learning.bean.Student>
     */
    List<Student> listStudentAll();

    /**
     * @param student
     * @Description 保存学生
     * @date 2020/6/29 12:29
     * @return: com.bosssoft.learning.bean.Student
     */
    Student saveByStudent(Student student);

    /**
     * @param student
     * @Description 删除学生
     * @date 2020/6/29 12:29
     * @return: com.bosssoft.learning.bean.Student
     */
    Student removeById(Student student);

    /**
     * @param student
     * @Description 更新学生
     * @date 2020/6/29 12:29
     * @return: com.bosssoft.learning.bean.Student
     */
    Student updateStudent(Student student);

    /**
     * @param students
     * @Description 批量删除
     * @date 2020/6/29 12:29
     * @return: boolean[]
     */
    boolean[] removeByIds(Student... students);
}
