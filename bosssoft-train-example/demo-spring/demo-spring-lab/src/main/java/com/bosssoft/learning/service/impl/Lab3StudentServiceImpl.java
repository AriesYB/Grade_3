package com.bosssoft.learning.service.impl;

import com.bosssoft.learning.bean.Student;
import com.bosssoft.learning.dao.StudentDao;
import com.bosssoft.learning.exception.StudentException;
import com.bosssoft.learning.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
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
@Service("lab3StudentService")
public class Lab3StudentServiceImpl implements StudentService {

    private StudentDao dao;

    @Autowired
    public void setDao(StudentDao dao) {
        this.dao = dao;
    }

    @Cacheable(value = "student", key = "#id")
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    @Override
    public Student getStudentById(String id) {
        log.info("getStudentById访问了数据库");
        return dao.selectStudentById(id);
    }

    @Cacheable(value = "students", key = "'students'")
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    @Override
    public List<Student> listStudentAll() {
        log.info("listStudentAll访问了数据库");
        return dao.selectAllStudents();
    }

    @CachePut(value = "student", key = "#student.id")
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, rollbackFor = StudentException.class)
    @Override
    public Student saveOneStudent(Student student) {
        log.info("saveStudent访问了数据库");
        return dao.insertStudentOne(student) == 1 ? student : null;
    }

    @CacheEvict(value = "student", key = "#student.id")
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, rollbackFor = StudentException.class)
    @Override
    public Student removeOneStudent(Student student) {
        log.info("removeStudent访问了数据库");
        return dao.deleteStudentOne(student.getId()) == 1 ? student : null;
    }

    @CachePut(value = "student", key = "#student.id")
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, rollbackFor = StudentException.class)
    @Override
    public Student updateOneStudent(Student student) {
        log.info("updateStudent访问了数据库");
        return dao.updateStudentOne(student) == 1 ? student : null;
    }

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, rollbackFor = StudentException.class)
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
