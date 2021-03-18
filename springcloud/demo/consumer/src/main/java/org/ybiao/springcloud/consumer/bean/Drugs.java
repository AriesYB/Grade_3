package org.ybiao.springcloud.consumer.bean;

import java.io.Serializable;
import java.util.Date;

public class Drugs implements Serializable {
    private Integer id;

    private String drugscode;

    private String drugsname;

    private String drugsformat;

    private String drugsunit;

    private String manufacturer;

    private Integer drugsdosageid;

    private Integer drugstypeid;

    private Double drugsprice;

    private String mnemoniccode;

    private Date creationdate;

    private Integer isdeleted;

    private static final long serialVersionUID = 1L;

    public Drugs(Integer id, String drugscode, String drugsname, String drugsformat, String drugsunit, String manufacturer, Integer drugsdosageid, Integer drugstypeid, Double drugsprice, String mnemoniccode, Date creationdate, Integer isdeleted) {
        this.id = id;
        this.drugscode = drugscode;
        this.drugsname = drugsname;
        this.drugsformat = drugsformat;
        this.drugsunit = drugsunit;
        this.manufacturer = manufacturer;
        this.drugsdosageid = drugsdosageid;
        this.drugstypeid = drugstypeid;
        this.drugsprice = drugsprice;
        this.mnemoniccode = mnemoniccode;
        this.creationdate = creationdate;
        this.isdeleted = isdeleted;
    }

    public Drugs() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDrugscode() {
        return drugscode;
    }

    public void setDrugscode(String drugscode) {
        this.drugscode = drugscode == null ? null : drugscode.trim();
    }

    public String getDrugsname() {
        return drugsname;
    }

    public void setDrugsname(String drugsname) {
        this.drugsname = drugsname == null ? null : drugsname.trim();
    }

    public String getDrugsformat() {
        return drugsformat;
    }

    public void setDrugsformat(String drugsformat) {
        this.drugsformat = drugsformat == null ? null : drugsformat.trim();
    }

    public String getDrugsunit() {
        return drugsunit;
    }

    public void setDrugsunit(String drugsunit) {
        this.drugsunit = drugsunit == null ? null : drugsunit.trim();
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer == null ? null : manufacturer.trim();
    }

    public Integer getDrugsdosageid() {
        return drugsdosageid;
    }

    public void setDrugsdosageid(Integer drugsdosageid) {
        this.drugsdosageid = drugsdosageid;
    }

    public Integer getDrugstypeid() {
        return drugstypeid;
    }

    public void setDrugstypeid(Integer drugstypeid) {
        this.drugstypeid = drugstypeid;
    }

    public Double getDrugsprice() {
        return drugsprice;
    }

    public void setDrugsprice(Double drugsprice) {
        this.drugsprice = drugsprice;
    }

    public String getMnemoniccode() {
        return mnemoniccode;
    }

    public void setMnemoniccode(String mnemoniccode) {
        this.mnemoniccode = mnemoniccode == null ? null : mnemoniccode.trim();
    }

    public Date getCreationdate() {
        return creationdate;
    }

    public void setCreationdate(Date creationdate) {
        this.creationdate = creationdate;
    }

    public Integer getIsdeleted() {
        return isdeleted;
    }

    public void setIsdeleted(Integer isdeleted) {
        this.isdeleted = isdeleted;
    }
}