package org.ybiao.springcloud.customer.impl;

import org.springframework.stereotype.Service;
import org.ybiao.springcloud.customer.bean.Customer;
import org.ybiao.springcloud.customer.mapper.CustomerMapper;
import org.ybiao.springcloud.customer.service.CustomerService;

import javax.annotation.Resource;

/**
 * ClassName:CustomerServiceImpl
 * Package:org.ybiao.springcloud.customer.service.impl
 * Description:
 *
 * @Date:2020/5/3 18:00
 * @Author:HetFrame
 */
@Service
public class CustomerServiceImpl implements CustomerService {

    @Resource
    private CustomerMapper customerMapper;

    @Override
    public boolean insert(Customer customer) {
        return customerMapper.insert(customer) == 1;
    }

    @Override
    public boolean update(Customer customer) {
        return customerMapper.updateByPrimaryKey(customer)==1;
    }
}
