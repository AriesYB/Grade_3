package edu.neu.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * ClassName:Invoice
 * Package:edu.neu.entity
 * Description:
 *
 * @Date:2019/10/26 16:25
 * @Author:HetFrame
 */
@Entity
@Table(name = "invoice")
public class Invoice implements Serializable {
    @Id
    @GeneratedValue
    private int id;
    private int invoice_id;
    private double amount;
    private int status;
    private String time;
    private int user;
    private int red_invoice;
    private int isDeleted;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getInvoice_id() {
        return invoice_id;
    }

    public void setInvoice_id(int invoice_id) {
        this.invoice_id = invoice_id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getUser() {
        return user;
    }

    public void setUser(int user) {
        this.user = user;
    }

    public int getRed_invoice() {
        return red_invoice;
    }

    public void setRed_invoice(int red_invoice) {
        this.red_invoice = red_invoice;
    }

    public int getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(int isDeleted) {
        this.isDeleted = isDeleted;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "id=" + id +
                ", invoice_id=" + invoice_id +
                ", amount=" + amount +
                ", status=" + status +
                ", time='" + time + '\'' +
                ", user=" + user +
                ", red_invoice=" + red_invoice +
                ", isDeleted=" + isDeleted +
                '}';
    }
}
