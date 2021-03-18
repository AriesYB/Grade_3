package com.bosssoft.learning.pojo.dto;

import com.bosssoft.learning.pojo.entity.Company;
import com.bosssoft.learning.pojo.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Set;

/**
 * @Description 传输用的User
 * @Date 2020/6/21 20:43
 * @Author HetFrame
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO implements Serializable {
    private Integer id;
    private String password;
    private String name;
    private Integer age;
    private String sex;
    private String phone;
    private String address;
    private Company company;
    private Set<Role> roles;

    @Override
    public String toString() {
        return "UserDTO{" +
                "id=" + id +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", company=" + company +
                ", roles=" + roles +
                '}';
    }
}
