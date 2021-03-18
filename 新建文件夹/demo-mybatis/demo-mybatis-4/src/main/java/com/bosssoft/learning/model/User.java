package com.bosssoft.learning.model;

import java.io.Serializable;

public class User implements Serializable {
    private String id;

    private String name;

    private String companyId;

    private static final long serialVersionUID = 1L;

    public User(String id, String name, String companyId) {
        this.id = id;
        this.name = name;
        this.companyId = companyId;
    }

    public User() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId == null ? null : companyId.trim();
    }
}