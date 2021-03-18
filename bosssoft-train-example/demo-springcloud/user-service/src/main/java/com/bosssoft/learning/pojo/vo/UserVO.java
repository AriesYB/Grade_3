package com.bosssoft.learning.pojo.vo;

import com.bosssoft.learning.pojo.entity.Company;
import com.bosssoft.learning.pojo.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Set;

/**
 * @Description 页面对象用户 这里使用validate注解
 * @Date 2020/6/21 21:26
 * @Author HetFrame
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserVO implements Serializable {

    private Integer id;
    private String password;
    @NotBlank
    private String name;
    @Range(max = 60, min = 18)
    private Integer age;
    @NotBlank
    private String sex;
    @Length(max = 11)
    private String phone;
    private String address;
    private Company company;
    private Set<Role> roles;


    @Override
    public String toString() {
        return "UserVO{" +
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
