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

    private JdbcTemplate templateUtil;

    @Autowired
    public void setTemplate(JdbcTemplate template) {
        this.templateUtil = template;
    }

    @Override
    public Student selectById(String id) {
        String sql = "select * from student where id = ?";
        return templateUtil.queryForObject(sql,new BeanPropertyRowMapper<>(Student.class),id);
    }

    @Override
    public List<Student> selectAll() {
        String sql = "select * from student";
        return templateUtil.query(sql, new BeanPropertyRowMapper<>(Student.class));
    }

    @Override
    public int insertOne(Student student) {
        String sql = "insert into student (id,name,age) values(?,?,?)";
        return templateUtil.update(sql, student.getId(), student.getName(), student.getAge());
    }

    @Override
    public int updateOne(Student student) {
        String sql = "update student set name=?,age=? where id=?";
        return templateUtil.update(sql, student.getName(), student.getAge(), student.getId());
    }

    @Override
    public int deleteOneById(String id) {
        String sql = "delete from student where id=?";
        return templateUtil.update(sql, id);
    }

    @Override
    public int[] deleteManyByIds(Student... students) {
        String sql = "delete from student where id=?";
        List<Object[]> list = new ArrayList<>();
        for (int i = 0; i < students.length; i++) {
            list.add(new String[]{students[i].getId()});
        }
        return templateUtil.batchUpdate(sql, list);
    }
}
