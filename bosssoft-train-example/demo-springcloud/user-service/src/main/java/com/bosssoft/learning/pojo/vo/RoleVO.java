package com.bosssoft.learning.pojo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Description 角色页面对象
 * @Date 2020/6/21 21:40
 * @Author HetFrame
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoleVO implements Serializable {
    private Integer id;
    private String name;

    @Override
    public String toString() {
        return "RoleVO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
