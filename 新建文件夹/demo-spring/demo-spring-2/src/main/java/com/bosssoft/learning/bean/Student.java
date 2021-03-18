package com.bosssoft.learning.bean;

import lombok.EqualsAndHashCode;

/**
 * @Description 学生类
 * @Date 2020/6/5 18:01
 * @Author HetFrame
 */
@EqualsAndHashCode
public class Student {
    private String id;
    private String name;

    public Student() {
    }

    public Student(String id, String name) {
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
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

}
