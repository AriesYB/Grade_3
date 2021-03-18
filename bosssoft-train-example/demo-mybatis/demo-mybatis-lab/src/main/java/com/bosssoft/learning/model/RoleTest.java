package com.bosssoft.learning.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description 角色类
 * @Date 2020/6/8 21:00
 * @Author HetFrame
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleTest {
    private String id;
    private String name;

    @Override
    public String toString() {
        return "RoleTest{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
