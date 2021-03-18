package com.bosssoft.learning.pojo.query;

import lombok.*;

/**
 * @Description 封装User查询条件
 * @Date 2020/6/21 21:33
 * @Author HetFrame
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class UserQuery {
    private Integer id;
    private String name;
    private String phone;
    private Integer companyId;
    private String companyName;
    private Integer roleId;
    private String roleName;

    @Override
    public String toString() {
        return "UserQuery{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", companyId=" + companyId +
                ", companyName='" + companyName + '\'' +
                ", roleId=" + roleId +
                ", roleName='" + roleName + '\'' +
                '}';
    }
}
