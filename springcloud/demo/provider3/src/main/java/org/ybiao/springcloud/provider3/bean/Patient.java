package org.ybiao.springcloud.provider3.bean;

import java.io.Serializable;

public class Patient extends PatientKey implements Serializable {
    //记录调用的是哪个provider
    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    private String provider;
    private String name;

    private Integer sex;

    private String dateBirth;

    private Integer age;

    private String address;

    private Integer isdeleted;

    private static final long serialVersionUID = 1L;

    public Patient(Integer id, String idNumber, String name, Integer sex, String dateBirth, Integer age, String address, Integer isdeleted) {
        super(id, idNumber);
        this.name = name;
        this.sex = sex;
        this.dateBirth = dateBirth;
        this.age = age;
        this.address = address;
        this.isdeleted = isdeleted;
    }

    public Patient() {
        super();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(String dateBirth) {
        this.dateBirth = dateBirth == null ? null : dateBirth.trim();
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Integer getIsdeleted() {
        return isdeleted;
    }

    public void setIsdeleted(Integer isdeleted) {
        this.isdeleted = isdeleted;
    }
}