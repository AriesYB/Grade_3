package org.ybiao.springcloud.consumer.bean;

import java.io.Serializable;

public class PatientKey implements Serializable {
    private Integer id;

    private String idNumber;

    private static final long serialVersionUID = 1L;

    public PatientKey(Integer id, String idNumber) {
        this.id = id;
        this.idNumber = idNumber;
    }

    public PatientKey() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber == null ? null : idNumber.trim();
    }
}