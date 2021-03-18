package com.bosssoft.hr.train.j2se.basic.example.proxy;

import com.bosssoft.hr.train.j2se.basic.example.pojo.User;
import lombok.extern.slf4j.Slf4j;

/**
 * @Description 实现类
 * @Date 2020/6/5 9:43
 * @Author HetFrame
 */
@Slf4j
public class UserServiceImpl implements UserService {
    @Override
    public void saveUser(User user) {
        log.info("save:" + user.toString());

    }
}
