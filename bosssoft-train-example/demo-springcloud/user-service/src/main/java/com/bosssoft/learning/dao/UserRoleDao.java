package com.bosssoft.learning.dao;

import com.bosssoft.learning.pojo.entity.UserRole;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Description 用户角色关系接口
 * @Date 2020/6/23 10:25
 * @Author HetFrame
 */
@Repository
public interface UserRoleDao<R extends UserRole> {
    /**
     * @param r
     * @Description 该条数据的数量，防止重复插入
     * @date 2020/6/23 10:46
     * @return: int
     */
    int count(R r);

    /**
     * @param id
     * @Description 通过用户id查询role
     * @date 2020/6/23 12:00
     * @return: java.util.List<R>
     */
    List<R> selectByUserId(int id);

    /**
     * @param r
     * @Description 更新用户角色
     * @date 2020/6/23 10:32
     * @return: int
     */
    int update(R r);

    /**
     * @param r
     * @Description 插入用户角色
     * @date 2020/6/23 10:32
     * @return: int
     */
    int insert(R r);

    /**
     * @param r
     * @Description 删除用户角色
     * @date 2020/6/23 10:32
     * @return: int
     */
    int delete(R r);

    /**
     * @param list
     * @Description 批量插入
     * @date 2020/6/23 14:11
     * @return: int
     */
    int insertList(List<UserRole> list);

    /**
     * @param userId
     * @Description 删除该用户所有角色
     * @date 2020/6/23 12:15
     * @return: int
     */
    int deleteAllRole(int userId);
}
