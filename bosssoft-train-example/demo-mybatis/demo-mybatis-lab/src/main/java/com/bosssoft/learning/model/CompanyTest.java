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
@AllArgsConstructor
@NoArgsConstructor
public class CompanyTest {
    private String id;
    private String name;

    @Override
    public String toString() {
        return "CompanyTest{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
