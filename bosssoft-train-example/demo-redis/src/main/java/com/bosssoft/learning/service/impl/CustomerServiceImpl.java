package com.bosssoft.learning.service.impl;

import com.bosssoft.learning.dao.CustomerDao;
import com.bosssoft.learning.entity.CustomerVO;
import com.bosssoft.learning.service.CustomerService;
import com.bosssoft.learning.service.RedisService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

/**
 * @Description 业务实现类
 * @Date 2020/6/16 16:09
 * @Author HetFrame
 */
@Service
public class CustomerServiceImpl implements CustomerService {
    private static final Logger log = LoggerFactory.getLogger(CustomerServiceImpl.class);

    private CustomerDao dao;

    @Autowired
    public void setDao(CustomerDao dao) {
        this.dao = dao;
    }

    private RedisService redisService;

    @Autowired
    public void setRedisService(RedisService redisService) {
        this.redisService = redisService;
    }

    private StringRedisTemplate redisTemplate;

    @Autowired
    public void setRedisTemplate(StringRedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Override
    public boolean checkAccount(int id, String password) {
        CustomerVO customer = dao.selectById(id);
        return customer != null && password.equals(customer.getCustomerName());
    }

    @Override
    public CustomerVO getCustomerById(int id) {
        CustomerVO customer;
        if (redisService.hasKey(String.valueOf(id))) {
            customer = (CustomerVO) redisService.get(String.valueOf(id));
            log.info("从缓存中获取Customer");
        } else {
            customer = dao.selectById(id);
            log.info("从数据库中获取customer:{}", customer);
            log.info("将数据存入缓存");
            redisService.set(String.valueOf(id), customer, 300);
        }
        return customer;
    }

    @Override
    public CustomerVO getCustomerById2(int id) {
        String lock = "key_mutex";
        CustomerVO customer;
        if (redisService.hasKey(String.valueOf(id))) {
            log.info("从缓存中获取Customer");
            customer = (CustomerVO) redisService.get(String.valueOf(id));
        } else {
            if (Boolean.TRUE.equals(redisTemplate.opsForValue().setIfAbsent(lock, "1", 30L, TimeUnit.SECONDS))) {
                log.info("获取锁:{}", Thread.currentThread().getId());
                customer = dao.selectById(id);
                redisService.set(String.valueOf(id), customer, 5 * 60L);
                redisService.del(lock);
                log.info("释放锁:{}", Thread.currentThread().getId());
            } else {
                try {
                    log.info("锁已被其他线程取得:{}", Thread.currentThread().getId());
                    sleep(50);
                } catch (InterruptedException e) {
                    log.error(e.getMessage());
                    Thread.currentThread().interrupt();
                }
                customer = getCustomerById(id);
            }
        }
        return customer;
    }

    @Override
    public List<CustomerVO> listCustomerByName(String name) {
        return dao.selectByName(name);
    }

    @Override
    public List<CustomerVO> listCustomerAll() {
        String key = "customers";
        List<CustomerVO> customers;
        if (redisService.hasKey(key)) {
            customers = (List<CustomerVO>) redisService.lGet(key, 0, -1).get(0);
            log.info("从缓存中获取的list");
        } else {
            log.info("从数据库中获取list");
            customers = dao.selectAll();
            int time = new Random().nextInt(30);
            log.info("将list存入缓存,期限为:{}", time);
            redisService.lSet(key, customers, time);
        }
        return customers;
    }

    @Override
    public boolean updateCustomer(CustomerVO customer) {
        return dao.update(customer) == 1;
    }

    @Override
    public boolean saveCustomer(CustomerVO customer) {
        return dao.insert(customer) == 1;
    }

    @Override
    public boolean removeCustomer(int id) {
        return dao.deleteList(id) == 1;
    }

    @Override
    public boolean removeCustomerList(List<Integer> list) {
        return dao.deleteList(list) == list.size();
    }
}
