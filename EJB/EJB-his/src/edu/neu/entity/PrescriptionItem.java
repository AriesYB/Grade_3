package edu.neu.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * ClassName:PrescriptionItem
 * Package:edu.neu.entity
 * Description:
 *
 * @Date:2019/10/26 16:29
 * @Author:HetFrame
 */
@Entity
@Table(name = "prescription_item")
public class PrescriptionItem implements Serializable {
    @Id
    @GeneratedValue
    private int id;
    private int prescription_id;
    private int drug;
    private String usage;
    private String consumption;
    private String frequency;
    private int quantity;
    private int charge_status;
    private int status;
    private int isDeleted;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrescription_id() {
        return prescription_id;
    }

    public void setPrescription_id(int prescription_id) {
        this.prescription_id = prescription_id;
    }

    public int getDrug() {
        return drug;
    }

    public void setDrug(int drug) {
        this.drug = drug;
    }

    public String getUsage() {
        return usage;
    }

    public void setUsage(String usage) {
        this.usage = usage;
    }

    public String getConsumption() {
        return consumption;
    }

    public void setConsumption(String consumption) {
        this.consumption = consumption;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getCharge_status() {
        return charge_status;
    }

    public void setCharge_status(int charge_status) {
        this.charge_status = charge_status;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(int isDeleted) {
        this.isDeleted = isDeleted;
    }

    @Override
    public String toString() {
        return "PrescriptionItem{" +
                "id=" + id +
                ", prescription_id=" + prescription_id +
                ", drug=" + drug +
                ", usage='" + usage + '\'' +
                ", consumption='" + consumption + '\'' +
                ", frequency='" + frequency + '\'' +
                ", quantity=" + quantity +
                ", charge_status=" + charge_status +
                ", status=" + status +
                ", isDeleted=" + isDeleted +
                '}';
    }
}
