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

    private StudentDao studentInfoDao;

    @Autowired
    public void setStudentInfoDao(StudentDao studentInfoDao) {
        this.studentInfoDao = studentInfoDao;
    }

    @Override
    public Student getStudentById(String id) {
        return studentInfoDao.selectById(id);
    }

    @Override
    public List<Student> listStudentAll() {
        return studentInfoDao.selectAll();
    }

    @Override
    public Student saveStudentInfo(Student student) {
        return studentInfoDao.insertOne(student) == 1?student:null;
    }

    @Override
    public Student removeStudentInfo(Student student) {
        return studentInfoDao.deleteOneById(student.getId()) == 1?student:null;
    }

    @Override
    public Student updateStudentInfo(Student student) {
        return studentInfoDao.updateOne(student) == 1?student:null;
    }

    @Override
    public boolean[] removeStudentInfo(Student... students) {
        int[] temp = studentInfoDao.deleteManyByIds(students);
        boolean[] results = new boolean[students.length];
        for (int i = 0; i < temp.length; i++) {
            results[i] = temp[i] == 1;
        }
        return results;
    }
}
