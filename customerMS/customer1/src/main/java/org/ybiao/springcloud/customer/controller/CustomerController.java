package org.ybiao.springcloud.customer.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.ybiao.springcloud.customer.bean.Customer;
import org.ybiao.springcloud.customer.service.CustomerService;

import javax.annotation.Resource;
import java.util.List;

/**
 * ClassName:CustomerController
 * Package:org.ybiao.springcloud.customer
 * Description:
 *
 * @Date:2020/5/3 18:15
 * @Author:HetFrame
 */
@RestController
public class CustomerController {
    @Resource
    CustomerService customerService;

    @RequestMapping("/customer/findAll")
    public List<Customer> findAllCustomer() {
        return customerService.findAll();
    }

    @HystrixCommand(fallbackMethod = "findNothing")
    @RequestMapping("/customer/findById/{id}")
    public Customer findCustomerById(@PathVariable("id") Integer id) throws Exception {
        Customer customer = customerService.findById(id);
        //未查询到结果时抛出异常进行服务熔断
        if (customer == null) {
            throw new Exception();
        }
        return customer;
    }

    public Customer findNothing(@PathVariable("id") Integer id) {
        Customer customer = new Customer();
        customer.setId(id);
        customer.setName("未查询到该客户信息");
        return customer;
    }

    @RequestMapping("/customer/findByName/{name}")
    public List<Customer> findCustomerByName(@PathVariable("name") String name) {
        return customerService.findByName(name);
    }

    @RequestMapping("/customer/findByCondition")
    public List<Customer> findByCondition(@RequestParam(value = "name", defaultValue = "") String name, @RequestParam(value = "sex", defaultValue = "") String sex, @RequestParam(value = "address", defaultValue = "") String address) {
        if (address.equals("")) {
            return customerService.findByNameAndSex(name, sex);
        }
        return customerService.findByNameAndSexAndAddress(name, sex, address);
    }
}
