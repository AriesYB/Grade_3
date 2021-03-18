package com.bosssoft.learning.model;

/**
 * @Description 用户
 * @Date 2020/6/11 11:29
 * @Author HetFrame
 */
public class UserDO {
    private String id;
    private String name;
    private String companyId;

    public UserDO() {
    }

    public UserDO(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public UserDO(String id, String name, String companyId) {
        this.id = id;
        this.name = name;
        this.companyId = companyId;
    }

    public UserDO(User user) {
        setId(user.getId());
        setName(user.getName());
        if (user.getCompany() != null) {
            setCompanyId(user.getCompany().getId());
        }
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "UserDO{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", companyId='" + companyId + '\'' +
                '}';
    }
}
