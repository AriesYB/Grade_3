package com.bosssoft.learning.dao;

import com.bosssoft.learning.entity.CustomerVO;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * @Description mapper
 * @Date 2020/6/16 12:05
 * @Author HetFrame
 */
@Repository
public interface CustomerDao {
    /**
     * @param id 客户id
     * @Description
     * @date 2020/6/16 14:40
     * @return: CustomerVO
     */
    CustomerVO selectById(int id);

    /**
     * @param name 客户姓名
     * @Description 通过姓名查询
     * @date 2020/6/16 14:41
     * @return: java.lock.List<CustomerVO>
     */
    List<CustomerVO> selectByName(String name);

    /**
     * @Description 查询所有
     * @date 2020/6/16 14:41
     * @return: java.lock.List<CustomerVO>
     */
    List<CustomerVO> selectAll();

    /**
     * @param customer 客户
     * @Description 更新
     * @date 2020/6/16 14:41
     * @return: int
     */
    int update(CustomerVO customer);

    /**
     * @param customer 客户
     * @Description 插入
     * @date 2020/6/16 14:42
     * @return: int
     */
    int insert(CustomerVO customer);

    /**
     * @param id 客户id
     * @Description 删除
     * @date 2020/6/16 14:42
     * @return: int
     */
    int deleteList(int id);

    /**
    * @Description 批量删除
    * @date 2020/6/17 22:16
    * @param list
    * @return: int
    */
    int deleteList(List<Integer> list);
}
