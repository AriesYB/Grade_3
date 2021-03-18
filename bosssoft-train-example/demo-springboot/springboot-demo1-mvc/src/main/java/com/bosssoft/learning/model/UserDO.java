package com.bosssoft.learning.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @Description 用户
 * @Date 2020/6/11 11:29
 * @Author HetFrame
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class UserDO {
    private String id;
    private String name;
    private String companyId;

    public UserDO(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.companyId = user.getCompany().getId();
    }


    @Override
    public String toString() {
        return "UserDO{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", companyId='" + companyId + '\'' +
                '}';
    }
}
