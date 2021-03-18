package edu.neu.pojo;

/**
 * ClassName:PatientRegisterPage
 * Package:edu.neu.entity
 * Description:
 *
 * @Date:2019/10/24 11:40
 * @Author:HetFrame
 */
public class PatientRegisterPage {
    private String name;
    private String address;
    private int register_id;
    private String time;
    private String see_doctor_time;
    private String department;
    private String status;

    public PatientRegisterPage(String name, String address, int register_id, String time, String see_doctor_time, String department, String status) {
        this.name = name;
        this.address = address;
        this.register_id = register_id;
        this.time = time;
        this.see_doctor_time = see_doctor_time;
        this.department = department;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public int getRegister_id() {
        return register_id;
    }

    public String getTime() {
        return time;
    }

    public String getSee_doctor_time() {
        return see_doctor_time;
    }

    public String getDepartment() {
        return department;
    }

    public String getStatus() {
        return status;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setRegister_id(int register_id) {
        this.register_id = register_id;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setSee_doctor_time(String see_doctor_time) {
        this.see_doctor_time = see_doctor_time;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
