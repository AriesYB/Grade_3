package org.ybiao.springcloud.consumer.bean;

import java.io.Serializable;

public class DepartmentKey implements Serializable {
    private Integer id;

    private String deptcode;

    private static final long serialVersionUID = 1L;

    public DepartmentKey(Integer id, String deptcode) {
        this.id = id;
        this.deptcode = deptcode;
    }

    public DepartmentKey() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDeptcode() {
        return deptcode;
    }

    public void setDeptcode(String deptcode) {
        this.deptcode = deptcode == null ? null : deptcode.trim();
    }
}