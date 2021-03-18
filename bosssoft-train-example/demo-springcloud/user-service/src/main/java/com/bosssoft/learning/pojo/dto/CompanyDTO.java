package com.bosssoft.learning.pojo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Description 公司的DTO
 * @Date 2020/6/21 21:41
 * @Author HetFrame
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompanyDTO implements Serializable {
    private Integer id;
    private String name;

    @Override
    public String toString() {
        return "CompanyDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
