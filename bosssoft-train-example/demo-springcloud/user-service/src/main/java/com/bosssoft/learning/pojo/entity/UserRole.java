package com.bosssoft.learning.pojo.entity;

import lombok.*;

import java.io.Serializable;

/**
 * @Description 用户角色关系
 * @Date 2020/6/22 10:24
 * @Author HetFrame
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class UserRole implements Serializable {
    private Integer userId;
    private Integer roleId;

    @Override
    public String toString() {
        return "UserRole{" +
                "userId=" + userId +
                ", roleId=" + roleId +
                '}';
    }
}
