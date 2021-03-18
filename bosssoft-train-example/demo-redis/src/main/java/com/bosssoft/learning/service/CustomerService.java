package com.bosssoft.learning.service;

import com.bosssoft.learning.entity.CustomerVO;

import java.util.List;

/**
 * @Description CustomerVO
 * @Date 2020/6/16 14:43
 * @Author HetFrame
 */
public interface CustomerService {
    /**
     * @param id
     * @param password
     * @Description 验证账号密码
     * @date 2020/6/17 11:56
     * @return: boolean
     */
    boolean checkAccount(int id, String password);

    /**
     * @param id
     * @Description 通过id获取
     * @date 2020/6/16 15:44
     * @return: com.bosssoft.learning.entity.CustomerVO
     */
    CustomerVO getCustomerById(int id);

    /**
     * @param name
     * @Description 通过姓名获取
     * @date 2020/6/16 15:44
     * @return: java.lock.List<com.bosssoft.learning.entity.CustomerVO>
     */
    List<CustomerVO> listCustomerByName(String name);

    /**
     * @Description 获取所有客户
     * @date 2020/6/16 15:45
     * @return: java.lock.List<com.bosssoft.learning.entity.CustomerVO>
     */
    List<CustomerVO> listCustomerAll();

    /**
     * @param customer
     * @Description 更新客户
     * @date 2020/6/16 15:54
     * @return: boolean
     */
    boolean updateCustomer(CustomerVO customer);

    /**
     * @param customer
     * @Description 添加客户
     * @date 2020/6/16 16:07
     * @return: boolean
     */
    boolean saveCustomer(CustomerVO customer);

    /**
     * @param id
     * @Description 删除客户
     * @date 2020/6/16 15:55
     * @return: boolean
     */
    boolean removeCustomer(int id);

    /**
     * @param list
     * @Description 批量删除
     * @date 2020/6/17 22:14
     * @return: boolean
     */
    boolean removeCustomerList(List<Integer> list);

    CustomerVO getCustomerById2(int id);
}
