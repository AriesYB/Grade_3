package com.bosssoft.learning.pojo.query;

import lombok.*;

/**
 * @Description 角色查询条件
 * @Date 2020/6/22 21:44
 * @Author HetFrame
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class RoleQuery {
    private Integer id;
    private String name;

    @Override
    public String toString() {
        return "RoleQuery{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
