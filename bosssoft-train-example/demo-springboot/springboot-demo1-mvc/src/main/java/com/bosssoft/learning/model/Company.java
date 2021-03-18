package com.bosssoft.learning.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description 公司类
 * @Date 2020/6/8 20:57
 * @Author HetFrame
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Company {
    private String id;
    private String name;

    @Override
    public String toString() {
        return "id:"+id+" name:"+name;
    }
}
