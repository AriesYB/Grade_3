package com.bosssoft.learning.model;

import java.io.Serializable;

public class Company implements Serializable {
    private String id;

    private String name;

    private static final long serialVersionUID = 1L;

    public Company(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public Company() {
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
}