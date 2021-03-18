package edu.neu.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * ClassName:User
 * Package:edu.neu.entity
 * Description:
 *
 * @Date:2019/10/26 9:03
 * @Author:HetFrame
 */
@Entity
@Table(name = "user")
public class User implements Serializable {
    @Id
    @GeneratedValue
    private int id;
    private String username;
    private String password;
    private String name;
    private int user_category;
    private String professional_ranks_and_titles;
    private int isInScheduled;
    private int department_id;
    private int register_class_id;
    private int isDeleted;

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public int getUser_category() {
        return user_category;
    }

    public String getProfessional_ranks_and_titles() {
        return professional_ranks_and_titles;
    }

    public int getIsInScheduled() {
        return isInScheduled;
    }

    public int getDepartment_id() {
        return department_id;
    }

    public int getRegister_class_id() {
        return register_class_id;
    }

    public int getIsDeleted() {
        return isDeleted;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUser_category(int user_category) {
        this.user_category = user_category;
    }

    public void setProfessional_ranks_and_titles(String professional_ranks_and_titles_id) {
        this.professional_ranks_and_titles = professional_ranks_and_titles_id;
    }

    public void setIsInScheduled(int isInScheduled) {
        this.isInScheduled = isInScheduled;
    }

    public void setDepartment_id(int department_id) {
        this.department_id = department_id;
    }

    public void setRegister_class_id(int register_class_id) {
        this.register_class_id = register_class_id;
    }

    public void setIsDeleted(int isDeleted) {
        this.isDeleted = isDeleted;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", user_category=" + user_category +
                ", professional_ranks_and_titles_id='" + professional_ranks_and_titles + '\'' +
                ", isInScheduled=" + isInScheduled +
                ", department_id=" + department_id +
                ", register_class_id=" + register_class_id +
                ", isDeleted=" + isDeleted +
                '}';
    }
}
