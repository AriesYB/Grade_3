package edu.neu.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * ClassName:Department
 * Package:edu.neu.entity
 * Description:
 *
 * @Date:2019/8/25 17:20
 * @Author:HetFrame
 */
@Entity
public class Department implements Serializable {
    @Id
    @GeneratedValue
    private Integer id;
    private String DeptCode;
    private String DeptName;
    private int DeptCategoryID;
    private int DeptType;
    private int isDeleted;

    public int getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(int isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Integer getId() {
        return id;
    }

    public String getDeptCode() {
        return DeptCode;
    }

    public String getDeptName() {
        return DeptName;
    }

    public int getDeptCategoryID() {
        return DeptCategoryID;
    }

    public int getDeptType() {
        return DeptType;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setDeptCode(String deptCode) {
        DeptCode = deptCode;
    }

    public void setDeptName(String deptName) {
        DeptName = deptName;
    }

    public void setDeptCategoryID(int deptCategoryID) {
        DeptCategoryID = deptCategoryID;
    }

    public void setDeptType(int deptType) {
        DeptType = deptType;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", DeptCode='" + DeptCode + '\'' +
                ", DeptName='" + DeptName + '\'' +
                ", DeptCategoryID=" + DeptCategoryID +
                ", DeptType=" + DeptType +
                '}';
    }
}
