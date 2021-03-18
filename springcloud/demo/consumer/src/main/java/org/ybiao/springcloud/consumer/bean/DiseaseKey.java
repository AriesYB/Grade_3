package org.ybiao.springcloud.consumer.bean;

import java.io.Serializable;

public class DiseaseKey implements Serializable {
    private Integer id;

    private String diseaseicd;

    private static final long serialVersionUID = 1L;

    public DiseaseKey(Integer id, String diseaseicd) {
        this.id = id;
        this.diseaseicd = diseaseicd;
    }

    public DiseaseKey() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDiseaseicd() {
        return diseaseicd;
    }

    public void setDiseaseicd(String diseaseicd) {
        this.diseaseicd = diseaseicd == null ? null : diseaseicd.trim();
    }
}