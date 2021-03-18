package com.bosssoft.learning.model;

import lombok.*;

import java.util.Set;

/**
 * @Description User类
 * @Date 2020/6/8 20:56
 * @Author HetFrame
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class UserTest {
    private String id;
    private String name;
    private CompanyTest company;
    private Set<RoleTest> roles;

    @Override
    public String toString() {
        return "UserTest{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", company=" + company +
                ", roles=" + roles +
                '}';
    }
}
