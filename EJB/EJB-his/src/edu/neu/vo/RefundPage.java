package edu.neu.vo;

import java.io.Serializable;

/**
 * ClassName:RefundPage
 * Package:edu.neu.vo
 * Description:
 *
 * @Date:2019/10/26 16:59
 * @Author:HetFrame
 */

public class RefundPage implements Serializable {
    private String name;
    private int register_id;
    private int medical_record_num;
    private String department;
    private String doctor;
    private String project;
    private int quantity;
    private double price;
    private String charge_method;
    private String time;//缴费时间
    private String status;//药品状态

    public RefundPage(String name, int register_id, int medical_record_num, String department, String doctor, String project, int quantity, double price, String charge_method, String time, int status) {
        this.name = name;
        this.register_id = register_id;
        this.medical_record_num = medical_record_num;
        this.department = department;
        this.doctor = doctor;
        this.project = project;
        this.quantity = quantity;
        this.price = price;
        this.charge_method = charge_method;
        this.time = time;
        this.status = String.valueOf(status);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRegister_id() {
        return register_id;
    }

    public void setRegister_id(int register_id) {
        this.register_id = register_id;
    }

    public int getMedical_record_num() {
        return medical_record_num;
    }

    public void setMedical_record_num(int medical_record_num) {
        this.medical_record_num = medical_record_num;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCharge_method() {
        return charge_method;
    }

    public void setCharge_method(String charge_method) {
        this.charge_method = charge_method;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "RefundPage{" +
                "name='" + name + '\'' +
                ", register_id=" + register_id +
                ", medical_record_num=" + medical_record_num +
                ", department='" + department + '\'' +
                ", doctor='" + doctor + '\'' +
                ", project='" + project + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                ", charge_method='" + charge_method + '\'' +
                ", time='" + time + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
