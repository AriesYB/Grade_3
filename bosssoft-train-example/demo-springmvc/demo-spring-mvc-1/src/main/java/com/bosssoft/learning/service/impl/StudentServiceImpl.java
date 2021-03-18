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
@Service("studentService1")
public class StudentServiceImpl implements StudentService {

    private StudentDao dao;

    @Autowired
    public void setDao(StudentDao dao) {
        this.dao = dao;
    }

    @Override
    public Student getStudentById(String id) {
        return dao.queryStudent(id);
    }

    @Override
    public List<Student> listStudentAll() {
        return dao.queryStudentAll();
    }

    @Override
    public Student saveStudent(Student student) {
        return dao.insertStudent(student) == 1?student:null;
    }

    @Override
    public Student removeStudent(Student student) {
        return dao.deleteStudent(student.getId()) == 1?student:null;
    }

    @Override
    public Student updateStudent(Student student) {
        return dao.updateStudent(student) == 1?student:null;
    }

    @Override
    public boolean[] removeStudents(Student... students) {
        int[] temp = dao.deleteStudents(students);
        boolean[] results = new boolean[students.length];
        for (int i = 0; i < temp.length; i++) {
            results[i] = temp[i] == 1;
        }
        return results;
    }
}
