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
@Service
public class StudentServiceImpl implements StudentService {

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
        return dao.queryById(id);
    }

    @Cacheable(value = "students", key = "'students'")
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    @Override
    public List<Student> listStudentAll() {
        log.info("listStudentAll访问了数据库");
        return dao.queryAll();
    }

    @CachePut(value = "student", key = "#student.id")
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, rollbackFor = StudentException.class)
    @Override
    public Student saveStudent(Student student) {
        log.info("访问了数据库");
        return dao.insert(student) == 1 ? student : null;
    }

    @CacheEvict(value = "student", key = "#student.id")
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, rollbackFor = StudentException.class)
    @Override
    public Student removeStudent(Student student) {
        log.info("访问了数据库");
        return dao.deleteById(student.getId()) == 1 ? student : null;
    }

    @CachePut(value = "student", key = "#student.id")
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, rollbackFor = StudentException.class)
    @Override
    public Student updateStudent(Student student) {
        log.info("访问了数据库");
        return dao.update(student) == 1 ? student : null;
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
