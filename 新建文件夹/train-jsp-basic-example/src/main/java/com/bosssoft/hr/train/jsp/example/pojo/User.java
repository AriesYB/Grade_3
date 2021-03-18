package com.bosssoft.hr.train.jsp.example.pojo;

import lombok.Data;

import java.io.Serializable;


/**
 * @param
 * @description: 判断对象相等重写 equals 和 hashcode 很重要哦
 * 加上@Data 注解不再需要编写
 * @author: Administrator
 * @create: 2020-05-22 14:52
 * @since
 **/
@Data
public class User implements Serializable {
    private Integer id;
    private String name;

    private String code;
    private String password;


    public User() {

    }

    public User(int id, String password) {
        this.id = id;
        this.password = password;
    }

    public User(Integer id) {
        this.id = id;
    }

    public User(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public User(String code, String password) {
        this.code = code;
        this.password = password;
    }

    public User(Integer id, String name, String code, String password) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.password = password;
    }

}
