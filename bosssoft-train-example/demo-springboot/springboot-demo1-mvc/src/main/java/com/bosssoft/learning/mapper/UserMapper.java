package com.bosssoft.learning.mapper;


import com.bosssoft.learning.model.User;
import com.bosssoft.learning.model.UserDO;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @Description user接口
 * @Date 2020/6/8 21:01
 * @Author HetFrame
 */
@Repository
public interface UserMapper {

    /**
     * @Description 通过id查询用户
     * @Param [id]
     * @Return com.bosssoft.learning.model.User
     */
    User selectUser(String id);

    /**
     * @Description 传入的条件按表分类作为键，然后该表的列和具体参数
     * @Param [maps]
     * @Return java.lock.List<com.bosssoft.learning.model.User>
     */
    List<User> selectUserByCondition(List<Map<String, String>> maps);

    /**
     * @Description 插入用户
     * @Param [user]
     * @Return int
     */
    int insertUser(UserDO user);

    /**
     * @Description 更新用户
     * @Param [user]
     * @Return int
     */
    int updateUser(UserDO user);

    /**
     * @Description 删除用户
     * @Param [user]
     * @Return int
     */
    int deleteUser(UserDO user);
}
