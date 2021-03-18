package com.bosssoft.learning.mapper;

import com.bosssoft.learning.model.User;

import java.util.List;
import java.util.Map;

/**
 * @Description user接口
 * @Date 2020/6/8 21:01
 * @Author HetFrame
 */
public interface UserMapper {

    /*传入的条件按表分类作为键，然后该表的列和具体参数*/
    List<User> queryUserByCondition(List<Map<String, String>> maps);

}
