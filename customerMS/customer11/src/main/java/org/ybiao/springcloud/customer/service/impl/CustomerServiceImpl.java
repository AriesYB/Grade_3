package org.ybiao.springcloud.customer.service.impl;

import org.springframework.stereotype.Service;
import org.ybiao.springcloud.customer.bean.Customer;
import org.ybiao.springcloud.customer.bean.CustomerExample;
import org.ybiao.springcloud.customer.mapper.CustomerMapper;
import org.ybiao.springcloud.customer.service.CustomerService;

import javax.annotation.Resource;
import java.util.List;

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
    public Customer findById(int id) {
        return customerMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Customer> findByName(String name) {
        CustomerExample customerExample = new CustomerExample();
        customerExample.createCriteria().andNameLike("%"+name+"%").andIsdeletedEqualTo(0);
        return customerMapper.selectByExample(customerExample);
    }

    @Override
    public List<Customer> findAll() {
        CustomerExample customerExample = new CustomerExample();
        customerExample.createCriteria().andIsdeletedEqualTo(0);
        return customerMapper.selectByExample(customerExample);
    }

    @Override
    public List<Customer> findByNameAndSex(String name, String sex) {
        CustomerExample customerExample = new CustomerExample();
        customerExample.createCriteria().andNameLike("%"+name+"%").andSexLike(sex);
        return customerMapper.selectByExample(customerExample);
    }

    @Override
    public List<Customer> findByNameAndSexAndAddress(String name, String sex, String address) {
        CustomerExample customerExample = new CustomerExample();
        customerExample.createCriteria().andIsdeletedEqualTo(0).andNameLike("%"+name+"%").andSexLike(sex).andAddressLike("%"+address+"%");
        return customerMapper.selectByExample(customerExample);
    }
}
