package com.bosssoft.learning.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Description student实体类
 * @Date 2020/6/8 17:41
 * @Author HetFrame
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student implements Serializable {
    private String id;
    private String name;

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
