package com.bosssoft.learning.service.impl;

import com.bosssoft.learning.bean.Student;
import com.bosssoft.learning.common.MyLogApi;
import com.bosssoft.learning.dao.StudentDao;
import com.bosssoft.learning.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description 学生业务实现类
 * @Date 2020/6/6 15:49
 * @Author HetFrame
 */
@Slf4j
@Service("lab5StudentService")
public class Lab5StudentServiceImpl implements StudentService {

    private StudentDao dao;

    @Autowired
    public Lab5StudentServiceImpl(StudentDao dao) {
        this.dao = dao;
    }

    @MyLogApi(action = "studentService")
    @Override
    public Student getStudentById(String id) {
        return dao.selectStudentById(id);
    }

    @Override
    public List<Student> listStudentAll() {
        return dao.selectAllStudents();
    }

    @Override
    public Student saveOneStudent(Student student) {
        return dao.insertStudentOne(student) == 1 ? student : null;
    }

    @Override
    public Student removeOneStudent(Student student) {
        return dao.deleteStudentOne(student.getId()) == 1 ? student : null;
    }

    @Override
    public Student updateOneStudent(Student student) {
        return dao.updateStudentOne(student) == 1 ? student : null;
    }

    @Override
    public boolean[] removeOneStudent(Student... students) {
        int[] temp = dao.deleteStudentsMany(students);
        boolean[] results = new boolean[students.length];
        for (int i = 0; i < temp.length; i++) {
            results[i] = temp[i] == 1;
        }
        return results;
    }
}
