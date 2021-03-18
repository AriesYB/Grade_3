package com.bosssoft.learning.pojo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Description 公司页面对象
 * @Date 2020/6/21 21:39
 * @Author HetFrame
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompanyVO implements Serializable {
    private Integer id;
    private String name;

    @Override
    public String toString() {
        return "CompanyVO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
