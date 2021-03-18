package com.bosssoft.learning.service.impl;

import com.bosssoft.learning.bean.Student;
import com.bosssoft.learning.dao.StudentDao;
import com.bosssoft.learning.exception.BusinessException;
import com.bosssoft.learning.exception.MyException;
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
@MyException
public class StudentServiceImpl implements StudentService {

    private StudentDao studentServiceDao;

    @Autowired
    public void setStudentServiceDao(StudentDao studentServiceDao) {
        this.studentServiceDao = studentServiceDao;
    }

    @Override
    public Student getStudent(String id) {
        return studentServiceDao.selectStudentById(id);
    }

    @Override
    public List<Student> getAllStudent() {
        List<Student> list = studentServiceDao.selectAllStudent();
        if (!list.isEmpty()){
            throw new BusinessException(101,"查询的列表不为空异常!");
        }
        return list;
    }

    @Override
    public Student addStudent(Student student) {
        return studentServiceDao.insertStudentInfo(student) == 1?student:null;
    }

    @Override
    public Student removeStudent(Student student) {
        return studentServiceDao.deleteStudentInfo(student.getId()) == 1?student:null;
    }

    @Override
    public Student updateStudent(Student student) {
        return studentServiceDao.updateStudentInfo(student) == 1?student:null;
    }

}
