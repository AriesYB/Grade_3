package com.bosssoft.learning.dao.impl;

import com.bosssoft.learning.bean.Student;
import com.bosssoft.learning.dao.StudentDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description DAO实现类
 * @Date 2020/6/6 15:41
 * @Author HetFrame
 */
@Slf4j
@Repository
public class StudentDaoImpl implements StudentDao {

    private JdbcTemplate template;

    @Autowired
    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    @Override
    public Student queryStudent(String id) {
        String sql = "select * from student where id = ?";
        return template.queryForObject(sql,new BeanPropertyRowMapper<>(Student.class),id);
    }

    @Override
    public List<Student> queryStudentAll() {
        String sql = "select * from student";
        return template.query(sql, new BeanPropertyRowMapper<>(Student.class));
    }

    @Override
    public int insertStudent(Student student) {
        String sql = "insert into student (id,name,age) values(?,?,?)";
        return template.update(sql, student.getId(), student.getName(), student.getAge());
    }

    @Override
    public int updateStudent(Student student) {
        String sql = "update student set name=?,age=? where id=?";
        return template.update(sql, student.getName(), student.getAge(), student.getId());
    }

    @Override
    public int deleteStudent(String id) {
        String sql = "delete from student where id=?";
        return template.update(sql, id);
    }

    @Override
    public int[] deleteStudents(Student... students) {
        String sql = "delete from student where id=?";
        List<Object[]> list = new ArrayList<>();
        for (int i = 0; i < students.length; i++) {
            list.add(new String[]{students[i].getId()});
        }
        return template.batchUpdate(sql, list);
    }
}
