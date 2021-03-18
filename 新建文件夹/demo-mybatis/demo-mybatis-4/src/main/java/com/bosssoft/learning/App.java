package com.bosssoft.learning;

import com.bosssoft.learning.mapper.CompanyMapper;
import com.bosssoft.learning.mapper.RoleMapper;
import com.bosssoft.learning.mapper.UserMapper;
import com.bosssoft.learning.mapper.UserRoleMapper;
import com.bosssoft.learning.model.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

            RoleMapper roleMapper = session.getMapper(RoleMapper.class);
            UserMapper userMapper = session.getMapper(UserMapper.class);
            UserRoleMapper userRoleMapper = session.getMapper(UserRoleMapper.class);
            CompanyMapper companyMapper = session.getMapper(CompanyMapper.class);

            UserExample userExample = new UserExample();
            CompanyExample companyExample = new CompanyExample();
            UserRoleExample userRoleExample = new UserRoleExample();

            List<User> list;
            List<UserRole> list2;
            List<String> ids = new ArrayList<String>();
            List<UserModel> userList = new ArrayList<UserModel>();

            /*查询在名称有一千的公司且角色为02的用户*/
            userRoleExample.createCriteria().andRoleIdEqualTo("02");
            list2 = userRoleMapper.selectByExample(userRoleExample);

            for (UserRole userRole : list2) {
                ids.add(userRole.getUserId());
            }

            userExample.createCriteria().andIdIn(ids);
            list = userMapper.selectByExample(userExample);

            companyExample.createCriteria().andNameLike("%一千%");
            List<Company> companies = companyMapper.selectByExample(companyExample);

            for (User user : list) {
                UserModel userModel = new UserModel(user.getId(), user.getName());
                for (Company company : companies) {
                    if (company.getId().equals(user.getCompanyId())) {
                        userModel.setCompany(company);
                        break;
                    }
                }
                Role role = roleMapper.selectByPrimaryKey("02");
                Set<Role> roles = new HashSet<Role>();
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
