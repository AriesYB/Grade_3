package com.bosssoft.learning.model;

/**
 * @Description 公司类
 * @Date 2020/6/8 20:57
 * @Author HetFrame
 */
public class Company {
    private String id;
    private String name;

    public Company() {
    }

    public Company(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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
        return name;
    }
}
