package org.ybiao.springcloud.customer.bean;

import java.io.Serializable;

public class Customer implements Serializable {
    private String from;

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }
    private Integer id;

    private String name;

    private Integer age;

    private String sex;

    private String address;

    private String phone;

    private Integer isdeleted = 0;

    private static final long serialVersionUID = 1L;

    public Customer(String name){
        this.name = name;
        age=0;
        sex="无";
        phone="无";
    }

    public Customer(String name, Integer age, String sex, String address, String phone) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.address = address;
        this.phone = phone;
    }

    public Customer(Integer id, String name, Integer age, String sex, String address, String phone, Integer isdeleted) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.address = address;
        this.phone = phone;
        this.isdeleted = isdeleted;
    }

    public Customer() {
        super();
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
        this.name = name == null ? null : name.trim();
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public Integer getIsdeleted() {
        return isdeleted;
    }

    public void setIsdeleted(Integer isdeleted) {
        this.isdeleted = isdeleted;
    }
}