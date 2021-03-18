package com.bosssoft.learning;

import com.bosssoft.learning.mapper.*;
import com.bosssoft.learning.model.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

/**
 * @Description 整合测试实验
 * @Date 2020/6/29 10:25
 * @Author HetFrame
 */
@Slf4j
public class TestLab {

    @Test
    public void testLab1() {
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

    @Test
    public void testLab2() {
        try {
            //获取SqlSessionFactory
            String resource = "mybatis-config.xml";
            InputStream inputStream = null;
            inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            SqlSessionFactory factory = builder.build(inputStream);
            //创建session
            SqlSession session = factory.openSession();
            UserTestMapper mapper = session.getMapper(UserTestMapper.class);
            log.info(mapper.queryUser("001").toString());
            log.info(mapper.queryUser("002").toString());
            log.info(mapper.queryUser("003").toString());
            session.close();
        } catch (IOException e) {
            log.error(e.getMessage());
        }
    }

    @Test
    public void testLab3() {
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
            UserTestMapper mapper = session.getMapper(UserTestMapper.class);

            List<Map<String, String>> maps = new ArrayList<>();
            Map<String, String> userCondition = new HashMap<>();
            Map<String, String> companyCondition = new HashMap<>();
            Map<String, String> roleCondition = new HashMap<>();

            /*roleCondition.put("name", "软件工程师")*/
            companyCondition.put("name", "一千");
            roleCondition.put("id", "02");

            maps.add(userCondition);
            maps.add(companyCondition);
            maps.add(roleCondition);
            log.info(maps.toString());

            List<UserTest> users = mapper.queryUserByCondition(maps);
            for (UserTest user : users) {
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

    @Test
    public void testLab4() {
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

            RoleMapper roleMapper = session.getMapper(RoleMapper.class);
            UserMapper userMapper = session.getMapper(UserMapper.class);
            UserRoleMapper userRoleMapper = session.getMapper(UserRoleMapper.class);
            CompanyMapper companyMapper = session.getMapper(CompanyMapper.class);

            UserExample userExample = new UserExample();
            CompanyExample companyExample = new CompanyExample();
            UserRoleExample userRoleExample = new UserRoleExample();

            List<User> list;
            List<UserRole> list2;
            List<String> ids = new ArrayList<>();
            List<UserModel> userList = new ArrayList<>();

            /*查询在名称有一千的公司且角色为02的用户*/
            userRoleExample.createCriteria().andRoleIdEqualTo("02");
            list2 = userRoleMapper.selectByExample(userRoleExample);

            for (UserRole userRole : list2) {
                ids.add(userRole.getUserId());
            }

            userExample.createCriteria().andIdIn(ids);
            list = userMapper.selectByExample(userExample);

            companyExample.createCriteria().andNameLike("%一千%");
            List<CompanyTest> companies = companyMapper.selectByExample(companyExample);

            for (User user : list) {
                UserModel userModel = new UserModel(user.getId(), user.getName());
                for (CompanyTest company : companies) {
                    if (company.getId().equals(user.getCompanyId())) {
                        userModel.setCompany(company);
                        break;
                    }
                }
                RoleTest role = roleMapper.selectByPrimaryKey("02");
                Set<RoleTest> roles = new HashSet<>();
                roles.add(role);
                userModel.setRoles(roles);
                userList.add(userModel);
            }


            for (UserModel model : userList) {
                log.info(model.toString());
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