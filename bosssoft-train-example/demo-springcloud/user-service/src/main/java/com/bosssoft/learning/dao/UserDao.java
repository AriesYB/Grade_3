package com.bosssoft.learning.dao;

import com.bosssoft.learning.pojo.dto.UserDTO;
import com.bosssoft.learning.pojo.entity.User;
import com.bosssoft.learning.pojo.query.UserQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Description user查询接口 方法名字应该跟查询语句吻合 mapper注解使用MapperScan
 * @Date 2020/6/21 21:53
 * @Author HetFrame
 */

@Repository
public interface UserDao<Q extends UserQuery, E extends User> {

    /**
     * @param id
     * @Description 通过id查询
     * @date 2020/6/23 11:05
     * @return: com.bosssoft.learning.pojo.dto.UserDTO
     */
    UserDTO selectById(int id);

    /**
     * @param q
     * @Description 使用多条件查询user
     * @date 2020/6/21 21:55
     * @return: java.util.List<com.bosssoft.learning.pojo.dto.UserDTO>
     */
    List<UserDTO> selectByCondition(Q q);

    /**
     * @param e
     * @Description 更新user
     * @date 2020/6/21 21:57
     * @return: int
     */
    int update(E e);

    /**
     * @param e
     * @Description 插入user
     * @date 2020/6/21 21:57
     * @return: int
     */
    int insert(E e);

    /**
     * @param e
     * @Description 删除user
     * @date 2020/6/21 21:57
     * @return: int
     */
    int delete(E e);

    /**
     * @param id
     * @Description 通过id删除
     * @date 2020/6/24 21:33
     * @return: int
     */
    int deleteById(int id);

    /**
     * @param list
     * @Description 批量删除
     * @date 2020/6/21 22:37
     * @return: int
     */
    int deleteList(List<User> list);
}
