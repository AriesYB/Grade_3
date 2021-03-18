package com.bosssoft.learning.entity;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;

/**
 * @Description 客户类
 * @Date 2020/6/16 11:56
 * @Author HetFrame
 */
public class Customer {
    private int id;
    @NotBlank
    private String name;
    @Range(max = 60, min = 18)
    private int age;
    @NotBlank
    private String sex;
    private String address;
    @Length(max = 11)
    private String phone;

    public Customer() {
    }

    public Customer(int code, String name, String sex, String phone) {
        this.id = code;
        this.name = name;
        this.sex = sex;
        this.phone = phone;
    }

    public Customer(int code, String name, int age, String sex, String address, String phone) {
        this.id = code;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.address = address;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }


}
