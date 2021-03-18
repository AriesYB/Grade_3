package edu.neu.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * ClassName:ChargesDetail
 * Package:edu.neu.entity
 * Description:
 *
 * @Date:2019/10/26 11:57
 * @Author:HetFrame
 */
@Entity
@Table(name = "charges_details")
public class ChargesDetail implements Serializable {
    @Id
    @GeneratedValue
    private int id;
    private int register_id;
    private int project;
    private int project_type;
    private String name;
    private double price;
    private int quantity;
    private String time;
    private int user;
    private String charge_method;
    private int invoice;
    private int type;
    private int isDeleted;

    public int getId() {
        return id;
    }

    public int getRegister_id() {
        return register_id;
    }

    public int getProject() {
        return project;
    }

    public int getProject_type() {
        return project_type;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getTime() {
        return time;
    }

    public int getUser() {
        return user;
    }

    public String getCharge_method() {
        return charge_method;
    }

    public int getInvoice() {
        return invoice;
    }

    public int getType() {
        return type;
    }

    public int getIsDeleted() {
        return isDeleted;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setRegister_id(int register_id) {
        this.register_id = register_id;
    }

    public void setProject(int project) {
        this.project = project;
    }

    public void setProject_type(int project_type) {
        this.project_type = project_type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setUser(int user) {
        this.user = user;
    }

    public void setCharge_method(String charge_method) {
        this.charge_method = charge_method;
    }

    public void setInvoice(int invoice) {
        this.invoice = invoice;
    }

    public void setType(int type) {
        this.type = type;
    }

    public void setIsDeleted(int isDeleted) {
        this.isDeleted = isDeleted;
    }

    @Override
    public String toString() {
        return "ChargesDetail{" +
                "id=" + id +
                ", register_id=" + register_id +
                ", project=" + project +
                ", project_type=" + project_type +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", time='" + time + '\'' +
                ", user=" + user +
                ", charge_method='" + charge_method + '\'' +
                ", invoice=" + invoice +
                ", type=" + type +
                ", isDeleted=" + isDeleted +
                '}';
    }
}
