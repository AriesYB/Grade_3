package com.bosssoft.learning.service.impl;

import com.bosssoft.learning.dao.CustomerDao;
import com.bosssoft.learning.entity.Customer;
import com.bosssoft.learning.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description 业务实现类
 * @Date 2020/6/16 16:09
 * @Author HetFrame
 */
@Service
public class CustomerServiceImpl implements CustomerService {
    private CustomerDao dao;

    @Autowired
    public void setDao(CustomerDao dao) {
        this.dao = dao;
    }

    @Override
    public boolean checkAccount(int id, String password) {
        Customer customer = dao.selectById(id);
        return customer != null && password.equals(customer.getName());
    }

    @Override
    public Customer getCustomerById(int id) {
        return dao.selectById(id);
    }

    @Override
    public List<Customer> listCustomerByName(String name) {
        return dao.selectByName(name);
    }

    @Override
    public List<Customer> listCustomerAll() {
        return dao.selectAll();
    }

    @Override
    public boolean updateCustomer(Customer customer) {
        return dao.update(customer) == 1;
    }

    @Override
    public boolean saveCustomer(Customer customer) {
        return dao.insert(customer) == 1;
    }

    @Override
    public boolean removeCustomer(int id) {
        return dao.deleteById(id) == 1;
    }

    @Override
    public boolean removeCustomerList(List<Integer> list) {
        return dao.deleteList(list) == list.size();
    }
}
