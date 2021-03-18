package com.bosssoft.hr.train.j2se.basic.example.pojo;

/**
 * @param
 * @description: 判断对象相等重写 equals 和 hashcode 很重要哦
 *           加上@Data 注解不再需要编写
 * @author: Administrator
 * @create: 2020-05-22 14:52
 * @since
 **/
public class User {
    private Integer id;
    private String name;

    public User() {
    }

    public User(Integer id) {
        this.id = id;
    }

    public User(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
