package com.bosssoft.learning.model;

import java.util.Set;

/**
 * @Description
 * @Date 2020/6/9 11:31
 * @Author HetFrame
 */
public class UserModel {
    private String id;
    private String name;
    private Company company;
    private Set<Role> roles;

    public UserModel() {
    }

    public UserModel(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public UserModel(String id, String name, Company company, Set<Role> roles) {
        this.id = id;
        this.name = name;
        this.company = company;
        this.roles = roles;
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

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", company=" + company +
                ", roles=" + roles +
                '}';
    }
}
