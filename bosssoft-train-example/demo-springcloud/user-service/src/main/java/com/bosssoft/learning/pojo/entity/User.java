package com.bosssoft.learning.pojo.entity;

import lombok.*;

import java.io.Serializable;

/**
 * @Description 数据库对应的实体User
 * @Date 2020/6/21 20:53
 * @Author HetFrame
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class User implements Serializable {
    private Integer id;
    private String password;
    private String name;
    private Integer age;
    private String sex;
    private String phone;
    private String address;
    private Integer companyId;
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", companyId=" + companyId +
                '}';
    }
}
