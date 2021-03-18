package org.ybiao.springcloud.consumer.bean;

import java.io.Serializable;

public class Department extends DepartmentKey implements Serializable {
    private String deptname;

    private Integer deptcategoryid;

    private Integer depttype;

    private Integer isdeleted;

    private static final long serialVersionUID = 1L;

    public Department(Integer id, String deptcode, String deptname, Integer deptcategoryid, Integer depttype, Integer isdeleted) {
        super(id, deptcode);
        this.deptname = deptname;
        this.deptcategoryid = deptcategoryid;
        this.depttype = depttype;
        this.isdeleted = isdeleted;
    }

    public Department() {
        super();
    }

    public String getDeptname() {
        return deptname;
    }

    public void setDeptname(String deptname) {
        this.deptname = deptname == null ? null : deptname.trim();
    }

    public Integer getDeptcategoryid() {
        return deptcategoryid;
    }

    public void setDeptcategoryid(Integer deptcategoryid) {
        this.deptcategoryid = deptcategoryid;
    }

    public Integer getDepttype() {
        return depttype;
    }

    public void setDepttype(Integer depttype) {
        this.depttype = depttype;
    }

    public Integer getIsdeleted() {
        return isdeleted;
    }

    public void setIsdeleted(Integer isdeleted) {
        this.isdeleted = isdeleted;
    }
}