package com.bosssoft.learning.service.impl;

import com.bosssoft.learning.bean.Student;
import com.bosssoft.learning.dao.StudentDao;
import com.bosssoft.learning.exception.StudentException;
import com.bosssoft.learning.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Description 学生业务实现类
 * @Date 2020/6/6 15:49
 * @Author HetFrame
 */
@Slf4j
@Service
public class StudentServiceImpl implements StudentService {

    private StudentDao dao;

    @Autowired
    public void setDao(StudentDao dao) {
        this.dao = dao;
    }

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    @Override
    public Student getStudentById(String id) {
        return dao.queryById(id);
    }

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    @Override
    public List<Student> listStudentAll() {
        return dao.queryAll();
    }

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, rollbackFor = StudentException.class)
    @Override
    public boolean saveStudent(Student student) {
        return dao.insert(student) == 1;
    }

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, rollbackFor = StudentException.class)
    @Override
    public boolean removeStudent(Student student) {
        int i = dao.deleteById(student.getId());
        if (i == 1) {
            throw new StudentException("删除时发生异常!");
        }
        return false;
    }

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, rollbackFor = StudentException.class)
    @Override
    public boolean updateStudent(Student student) {
        return dao.update(student) == 1;
    }

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, rollbackFor = StudentException.class)
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
