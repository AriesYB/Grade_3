package com.bosssoft.learning;

import com.bosssoft.learning.mapper.UserMapper;
import com.bosssoft.learning.model.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description Main方法
 * @Date 2020/6/8 18:05
 * @Author HetFrame
 */
@Slf4j
public class App {
    public static void main(String[] args) {
        SqlSession session = null;
        try {
            //获取SqlSessionFactory
            String resource = "mybatis-config.xml";
            InputStream inputStream = null;
            inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            SqlSessionFactory factory = builder.build(inputStream);
            //创建session
            session = factory.openSession();
            UserMapper mapper = session.getMapper(UserMapper.class);


            List<Map<String, String>> maps = new ArrayList<Map<String, String>>();
            Map<String, String> userCondition = new HashMap<String, String>();
            Map<String, String> companyCondition = new HashMap<String, String>();
            Map<String, String> roleCondition = new HashMap<String, String>();

            /*roleCondition.put("name", "软件工程师")*/
            companyCondition.put("name", "一千");
            roleCondition.put("id", "02");

            maps.add(userCondition);
            maps.add(companyCondition);
            maps.add(roleCondition);
            log.info(maps.toString());

            List<User> users = mapper.queryUserByCondition(maps);
            for (User user : users) {
                log.info(user.toString());
            }
        } catch (IOException e) {
            log.error(e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
