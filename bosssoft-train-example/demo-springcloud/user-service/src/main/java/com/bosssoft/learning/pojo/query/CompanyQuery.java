package com.bosssoft.learning.pojo.query;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @Description 公司查询条件
 * @Date 2020/6/22 21:43
 * @Author HetFrame
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class CompanyQuery {
    private Integer id;
    private String name;

    @Override
    public String toString() {
        return "CompanyQuery{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
