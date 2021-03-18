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

    private StudentDao studentDao;

    @Autowired
    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @Override
    public Student getStudentById(String id) {
        return studentDao.queryById(id);
    }

    @Override
    public List<Student> listStudentAll() {
        return studentDao.queryAll();
    }

    @Override
    public Student saveByStudent(Student student) {
        return studentDao.insert(student) == 1?student:null;
    }

    @Override
    public Student removeById(Student student) {
        return studentDao.deleteById(student.getId()) == 1?student:null;
    }

    @Override
    public Student updateStudent(Student student) {
        return studentDao.update(student) == 1?student:null;
    }

    @Override
    public boolean[] removeByIds(Student... students) {
        int[] temp = studentDao.deleteByIds(students);
        boolean[] results = new boolean[students.length];
        for (int i = 0; i < temp.length; i++) {
            results[i] = temp[i] == 1;
        }
        return results;
    }
}
