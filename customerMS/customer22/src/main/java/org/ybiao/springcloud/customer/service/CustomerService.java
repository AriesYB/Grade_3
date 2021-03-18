package org.ybiao.springcloud.customer.service;

import org.ybiao.springcloud.customer.bean.Customer;

/**
 * ClassName:CustomerService
 * Package:org.ybiao.springcloud.customer.service
 * Description:
 *
 * @Date:2020/5/3 17:22
 * @Author:HetFrame
 */
public interface CustomerService {
    boolean insert(Customer customer);
    boolean update(Customer customer);//删除跟update本质上一致
}
