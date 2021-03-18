package com.bosssoft.hr.train.j2se.basic.example.pojo;

import lombok.Data;

import java.util.Objects;

/**
 * @param
 * @description:
 * @author: Administrator
 * @create: 2020-05-28 22:07
 * @since
 **/
public class Student extends User {
    private Integer age;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Student)) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        Student student = (Student) o;
        return Objects.equals(getAge(), student.getAge());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getAge());
    }

    public Student() {
        super();
    }

    public Student(Integer id) {
        super(id);
    }

    public Student(Integer id, String name) {
        super(id, name);
    }

    public Student(Integer id, String name, Integer age) {
        super(id, name);
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +"id=" + getId() +
                ", name='" + getName() +
                "', age=" + age +
                "}";
    }
}
