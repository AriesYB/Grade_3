package com.bosssoft.learning.mapper;

import com.bosssoft.learning.model.UserTest;

import java.util.List;
import java.util.Map;

/**
 * @Description user接口
 * @Date 2020/6/8 21:01
 * @Author HetFrame
 */
public interface UserTestMapper {
    /**
     * @param id
     * @Description 查询用户
     * @date 2020/6/29 10:00
     * @return: com.bosssoft.learning.model.UserTest
     */
    UserTest queryUser(String id);

    /**
     * @Description 查询所有
     * @date 2020/6/29 10:00
     * @return: java.util.List<com.bosssoft.learning.model.UserTest>
     */
    List<UserTest> queryUserAll();

    /**
     * @param maps
     * @Description 传入的条件按表分类作为键，然后该表的列和具体参数
     * @date 2020/6/29 10:00
     * @return: java.util.List<com.bosssoft.learning.model.UserTest>
     */
    List<UserTest> queryUserByCondition(List<Map<String, String>> maps);
}
