package org.ybiao.springcloud.customer.service;

import org.ybiao.springcloud.customer.bean.Customer;

import java.util.List;

/**
 * ClassName:CustomerService
 * Package:org.ybiao.springcloud.customer.service
 * Description:
 *
 * @Date:2020/5/3 17:22
 * @Author:HetFrame
 */
public interface CustomerService {
    Customer findById(int id);
    List<Customer> findByName(String name);
    List<Customer> findAll();
    List<Customer> findByNameAndSex(String name,String sex);
    List<Customer> findByNameAndSexAndAddress(String name,String sex,String address);

}
