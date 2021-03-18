package edu.neu.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * ClassName:patient
 * Package:edu.neu.entity
 * Description:
 *
 * @Date:2019/8/23 9:38
 * @Author:HetFrame
 */
@Entity
public class Patient implements Serializable {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private int sex;
    private String ID_number;
    private String date_birth;
    private int age;
    private String address;
    private int isDeleted;

    public int getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(int isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getSex() {
        return sex;
    }

    public String getID_number() {
        return ID_number;
    }

    public String getDate_birth() {
        return date_birth;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public void setID_number(String ID_number) {
        this.ID_number = ID_number;
    }

    public void setDate_birth(String date_birth) {
        this.date_birth = date_birth;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                ", ID_number='" + ID_number + '\'' +
                ", date_birth=" + date_birth +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }
}
