package com.bosssoft.learning.model;

import lombok.*;

import java.util.Set;

/**
 * @Description
 * @Date 2020/6/9 11:31
 * @Author HetFrame
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserModel {
    private String id;
    private String name;
    private CompanyTest company;
    private Set<RoleTest> roles;

    public UserModel(String id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", company=" + company +
                ", roles=" + roles +
                '}';
    }
}
