package edu.neu.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * ClassName:Prescription
 * Package:edu.neu.entity
 * Description:
 *
 * @Date:2019/10/26 16:54
 * @Author:HetFrame
 */
@Entity
@Table(name = "prescription")
public class Prescription implements Serializable {
    @Id
    @GeneratedValue
    private Integer id;
    private int medical_record_num;
    private int register_id;
    private int doctor;
    private int type;
    private String name;
    private String time;
    private int status;
    private int isDeleted;

    public Integer getId() {
        return id;
    }

    public int getMedical_record_num() {
        return medical_record_num;
    }

    public int getRegister_id() {
        return register_id;
    }

    public int getDoctor() {
        return doctor;
    }

    public int getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public String getTime() {
        return time;
    }

    public int getStatus() {
        return status;
    }

    public int getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(int isDeleted) {
        this.isDeleted = isDeleted;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setMedical_record_num(int medical_record_num) {
        this.medical_record_num = medical_record_num;
    }

    public void setRegister_id(int register_id) {
        this.register_id = register_id;
    }

    public void setDoctor(int doctor) {
        this.doctor = doctor;
    }

    public void setType(int type) {
        this.type = type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Prescription{" +
                "id=" + id +
                ", medical_record_num=" + medical_record_num +
                ", register_id=" + register_id +
                ", doctor=" + doctor +
                ", type=" + type +
                ", name='" + name + '\'' +
                ", time='" + time + '\'' +
                ", status=" + status +
                ", isDeleted=" + isDeleted +
                '}';
    }
}
