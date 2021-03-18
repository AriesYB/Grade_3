package org.ybiao.springcloud.customer.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.ybiao.springcloud.customer.bean.Customer;
import org.ybiao.springcloud.customer.service.Customer1Service;
import org.ybiao.springcloud.customer.service.CustomerService;

import javax.annotation.Resource;

/**
 * ClassName:CustomerController
 * Package:org.ybiao.springcloud.customer.controller
 * Description:
 *
 * @Date:2020/5/3 20:41
 * @Author:HetFrame
 */
@RestController
public class CustomerController {
    @Resource
    private CustomerService customerService;
    @Resource
    private Customer1Service customer1Service;

    @RequestMapping("/customer/deleteById/{id}")
    public boolean deleteCustomerById(@PathVariable("id") Integer id) {
        Customer customer = customer1Service.findCustomerById(id);
        customer.setIsdeleted(1);
        return customerService.update(customer);
    }

    @RequestMapping("/customer/insert")
    public boolean insertCustomer(Customer customer){
        return customerService.insert(customer);
    }

    @RequestMapping("/customer/updateById")
    public Customer updateCustomerById(@RequestParam("id") Integer id, @RequestParam(value = "name", defaultValue = "n") String name, @RequestParam(value = "age", defaultValue = "n") String age, @RequestParam(value = "phone", defaultValue = "n") String phone, @RequestParam(value = "sex", defaultValue = "n") String sex,@RequestParam(value = "address",defaultValue = "n") String address) {
        Customer customer = customer1Service.findCustomerById(id);
        if (customer==null){
            return null;
        }
        if (!name.equals("n")){
            customer.setName(name);
        }
        if (!sex.equals("n")){
            customer.setSex(sex);
        }
        if (!age.equals("n")){
            customer.setAge(Integer.parseInt(age));
        }
        if (!phone.equals("n")){
            customer.setPhone(phone);
        }
        if (!address.equals("n")){
            customer.setAddress(address);
        }
        customerService.update(customer);
        return customer1Service.findCustomerById(id);
    }
}
