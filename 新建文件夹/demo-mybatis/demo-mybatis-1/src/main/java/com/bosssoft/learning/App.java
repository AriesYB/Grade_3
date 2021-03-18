package com.bosssoft.learning;

import com.bosssoft.learning.mapper.StudentMapper;
import com.bosssoft.learning.model.Student;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Description Main方法
 * @Date 2020/6/8 18:05
 * @Author HetFrame
 */
@Slf4j
public class App {
    public static void main(String[] args) {
        try {
            //获取SqlSessionFactory
            String resource = "mybatis-config.xml";
            InputStream inputStream = null;
            inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            SqlSessionFactory factory = builder.build(inputStream);
            //创建session查询三次
            SqlSession session = factory.openSession();
            log.info("开启第一个session------");
            StudentMapper studentMapper = session.getMapper(StudentMapper.class);
            //未开启二级缓存的mapper: StudentMapperAnother
            Student student = studentMapper.queryById("123");
            log.info("第一次查询学生:" + student);
            Student student1 = studentMapper.queryById("123");
            log.info("第二次查询学生:" + student1);
            session.close();
            //创建第二个session再查询三次
            SqlSession session2 = factory.openSession();
            log.info("开启第二个session------");
            StudentMapper studentMapper1 = session2.getMapper(StudentMapper.class);
            Student student3 = studentMapper1.queryById("123");
            log.info("第一次查询学生:" + student3);
            Student student4 = studentMapper1.queryById("123");
            log.info("第二次查询学生:" + student4);
            session2.close();
        } catch (IOException e) {
            log.error(e.getMessage());
        }
    }
}
