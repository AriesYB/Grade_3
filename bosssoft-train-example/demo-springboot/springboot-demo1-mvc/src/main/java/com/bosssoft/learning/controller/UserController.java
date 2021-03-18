package com.bosssoft.learning.controller;

import com.bosssoft.learning.model.User;
import com.bosssoft.learning.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description User的控制器
 * @Date 2020/6/10 19:36
 * @Author HetFrame
 */

@Validated
@RequestMapping("/user")
@RestController
public class UserController {
    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/find")
    public User getUserById(@Size(message = "id未输入", min = 1, max = 10) @RequestParam("id") String id) {
        return userService.getUser(id);
    }

    @GetMapping("/findAll")
    public List<User> listUserAll() {
        return userService.listUserAll();
    }

    @GetMapping("/findByCondition")
    public List<User> listUserByCondition() {
        return new ArrayList<>();
    }

    @GetMapping("/save")
    public boolean saveUser(User user) {
        return userService.saveUser(user) != null;
    }

    @GetMapping("/update")
    public boolean updateUser(User user) {
        return userService.updateUser(user) != null;
    }

    @GetMapping("/remove")
    public boolean remove(User user) {
        return userService.removeUser(user) != null;
    }

}
