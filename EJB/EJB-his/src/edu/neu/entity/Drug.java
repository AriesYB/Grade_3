package edu.neu.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * ClassName:Drug
 * Package:edu.neu.entity
 * Description:
 *
 * @Date:2019/10/26 18:40
 * @Author:HetFrame
 */
@Entity
@Table(name = "drugs")
public class Drug implements Serializable {
    @Id
    @GeneratedValue
    private int id;
    private String DrugsCode;
    private String DrugsName;
    private String DrugsFormat;
    private String DrugsUnit;
    private String Manufacturer;
    private int DrugsDosageID;
    private int DrugsTypeID;
    private double DrugsPrice;
    private String MnemonicCode;
    private Date CreationDate;
    private int isDeleted;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDrugsCode() {
        return DrugsCode;
    }

    public void setDrugsCode(String drugsCode) {
        DrugsCode = drugsCode;
    }

    public String getDrugsName() {
        return DrugsName;
    }

    public void setDrugsName(String drugsName) {
        DrugsName = drugsName;
    }

    public String getDrugsFormat() {
        return DrugsFormat;
    }

    public void setDrugsFormat(String drugsFormat) {
        DrugsFormat = drugsFormat;
    }

    public String getDrugsUnit() {
        return DrugsUnit;
    }

    public void setDrugsUnit(String drugsUnit) {
        DrugsUnit = drugsUnit;
    }

    public String getManufacturer() {
        return Manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        Manufacturer = manufacturer;
    }

    public int getDrugsDosageID() {
        return DrugsDosageID;
    }

    public void setDrugsDosageID(int drugsDosageID) {
        DrugsDosageID = drugsDosageID;
    }

    public int getDrugsTypeID() {
        return DrugsTypeID;
    }

    public void setDrugsTypeID(int drugsTypeID) {
        DrugsTypeID = drugsTypeID;
    }

    public double getDrugsPrice() {
        return DrugsPrice;
    }

    public void setDrugsPrice(double drugsPrice) {
        DrugsPrice = drugsPrice;
    }

    public String getMnemonicCode() {
        return MnemonicCode;
    }

    public void setMnemonicCode(String mnemonicCode) {
        MnemonicCode = mnemonicCode;
    }

    public Date getCreationDate() {
        return CreationDate;
    }

    public void setCreationDate(Date creationDate) {
        CreationDate = creationDate;
    }

    public int getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(int isDeleted) {
        this.isDeleted = isDeleted;
    }

    @Override
    public String toString() {
        return "Drug{" +
                "id=" + id +
                ", DrugsCode='" + DrugsCode + '\'' +
                ", DrugsName='" + DrugsName + '\'' +
                ", DrugsFormat='" + DrugsFormat + '\'' +
                ", DrugsUnit='" + DrugsUnit + '\'' +
                ", Manufacturer='" + Manufacturer + '\'' +
                ", DrugsDosageID=" + DrugsDosageID +
                ", DrugsTypeID=" + DrugsTypeID +
                ", DrugsPrice=" + DrugsPrice +
                ", MnemonicCode='" + MnemonicCode + '\'' +
                ", CreationDate=" + CreationDate +
                ", isDeleted=" + isDeleted +
                '}';
    }
}
