package com.bosssoft.learning;

import com.bosssoft.learning.mapper.UserMapper;
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
            //创建session
            SqlSession session = factory.openSession();
            UserMapper mapper = session.getMapper(UserMapper.class);
            log.info(mapper.queryUser("001").toString());
            log.info(mapper.queryUser("002").toString());
            log.info(mapper.queryUser("003").toString());
            session.close();
        } catch (IOException e) {
            log.error(e.getMessage());
        }
    }
}
