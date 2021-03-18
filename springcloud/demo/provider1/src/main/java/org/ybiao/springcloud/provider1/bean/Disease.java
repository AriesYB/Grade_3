package org.ybiao.springcloud.provider1.bean;

import java.io.Serializable;

public class Disease extends DiseaseKey implements Serializable {
    private String diseasecode;

    private String diseasename;

    private Integer disecategoryid;

    private static final long serialVersionUID = 1L;

    public Disease(Integer id, String diseaseicd, String diseasecode, String diseasename, Integer disecategoryid) {
        super(id, diseaseicd);
        this.diseasecode = diseasecode;
        this.diseasename = diseasename;
        this.disecategoryid = disecategoryid;
    }

    public Disease() {
        super();
    }

    public String getDiseasecode() {
        return diseasecode;
    }

    public void setDiseasecode(String diseasecode) {
        this.diseasecode = diseasecode == null ? null : diseasecode.trim();
    }

    public String getDiseasename() {
        return diseasename;
    }

    public void setDiseasename(String diseasename) {
        this.diseasename = diseasename == null ? null : diseasename.trim();
    }

    public Integer getDisecategoryid() {
        return disecategoryid;
    }

    public void setDisecategoryid(Integer disecategoryid) {
        this.disecategoryid = disecategoryid;
    }
}