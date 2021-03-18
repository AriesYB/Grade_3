package com.bosssoft.learning.service;

import com.bosssoft.learning.pojo.dto.UserDTO;
import com.bosssoft.learning.pojo.query.UserQuery;
import com.bosssoft.learning.pojo.vo.UserVO;

import java.util.List;

/**
 * @Description user业务类接口
 * @Date 2020/6/21 23:05
 * @Author HetFrame
 */
public interface UserService<T extends UserDTO, V extends UserVO, Q extends UserQuery> {

    /**
     * @param v
     * @Description 验证账号密码,相等就返回vo对象，否则返回null
     * @date 2020/6/22 10:17
     * @return: boolean
     */
    V checkAccount(V v);

    /**
    * @Description 通过id查询
    * @date 2020/6/23 18:41
    * @param q
    * @return: T
    */
    V queryById(Q q);

    /**
     * @param q
     * @Description 通过条件查询,不设置缓存，没法清除
     * @date 2020/6/22 10:19
     * @return: java.util.List<com.bosssoft.learning.pojo.dto.UserDTO>
     */
    List<V> queryByCondition(Q q);

    /**
     * @param t
     * @Description 保存，使用返回值的id作为缓存key
     * @date 2020/6/22 10:20
     * @return: boolean
     */
    T save(T t);

    /**
     * @param t
     * @Description 更新
     * @date 2020/6/23 10:22
     * @return: boolean
     */
    T update(T t);

    /**
     * @param v
     * @Description 删除
     * @date 2020/6/23 10:22
     * @return: boolean
     */
    boolean remove(V v);

}
