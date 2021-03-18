package com.bosssoft.learning.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @Description 角色类
 * @Date 2020/6/8 21:00
 * @Author HetFrame
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Role {
    private String id;
    private String name;

    @Override
    public String toString() {
        return "id:"+id+" name:"+name;
    }
}

