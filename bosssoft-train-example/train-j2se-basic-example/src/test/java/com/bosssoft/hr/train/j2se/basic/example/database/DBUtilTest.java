package com.bosssoft.hr.train.j2se.basic.example.database;

import com.bosssoft.hr.train.j2se.basic.example.pojo.Student;
import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * @Description TODO
 * @Date 2020/6/4 16:02
 * @Author HetFrame
 */
@Slf4j
public class DBUtilTest {

    @Before
    public void setUp() throws Exception {
        DBUtil.newInstance().getConn();
    }

    @After
    public void tearDown() throws Exception {
        DBUtil.newInstance().close();
    }

    @Test
    public void executeQuery() {
        Student student = new Student(20175058, "杨彪", 21);
        String sql = "select * from student where id=20175058";
        List<Map<String, String>> list = null;
        try {
            list = DBUtil.newInstance().executeQuery(sql);
        } catch (SQLException e) {
            log.error(e.getMessage());
        }
        assertEquals(student.getId(), Integer.valueOf(list.get(0).get("id")));
        assertEquals(student.getName(), list.get(0).get("name"));
        assertEquals(student.getAge(), Integer.valueOf(list.get(0).get("age")));
    }
}