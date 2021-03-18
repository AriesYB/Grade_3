package com.bosssoft.learning.service.impl;

import com.bosssoft.learning.bean.Student;
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
@Service("studentService")
public class StudentServiceImpl implements StudentService {

    private StudentDao dao;

    @Autowired
    public void setDao(StudentDao dao) {
        this.dao = dao;
    }

    @Override
    public Student getStudentById(String id) {
        return dao.queryById(id);
    }

    @Override
    public List<Student> listStudentAll() {
        return dao.queryAll();
    }

    @Override
    public Student saveStudent(Student student) {
        return dao.insert(student) == 1?student:null;
    }

    @Override
    public Student removeStudent(Student student) {
        return dao.deleteById(student.getId()) == 1?student:null;
    }

    @Override
    public Student updateStudent(Student student) {
        return dao.update(student) == 1?student:null;
    }

    @Override
    public boolean[] removeStudent(Student... students) {
        int[] temp = dao.deleteByIds(students);
        boolean[] results = new boolean[students.length];
        for (int i = 0; i < temp.length; i++) {
            results[i] = temp[i] == 1;
        }
        return results;
    }
}
