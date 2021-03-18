package com.bosssoft.learning.entity;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @Description 客户类
 * @Date 2020/6/16 11:56
 * @Author HetFrame
 */
public class CustomerVO implements Serializable {
    private Integer customerId;
    @NotBlank
    private String customerName;
    private @Range(max = 60, min = 18) Integer customerAge;
    @NotBlank
    private String customerSex;
    private String customerAddress;
    @Length(max = 11)
    private String customerPhone;

    public CustomerVO() {
    }

    public CustomerVO(int customerId, String customerName, String customerSex, String customerPhone) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerSex = customerSex;
        this.customerPhone = customerPhone;
    }

    public CustomerVO(int customerId, String customerName, int customerAge, String customerSex, String customerAddress, String customerPhone) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerAge = customerAge;
        this.customerSex = customerSex;
        this.customerAddress = customerAddress;
        this.customerPhone = customerPhone;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerSex() {
        return customerSex;
    }

    public void setCustomerSex(String customerSex) {
        this.customerSex = customerSex;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public @Range(max = 60, min = 18) Integer getCustomerAge() {
        return customerAge;
    }

    public void setCustomerAge(@Range(max = 60, min = 18) Integer customerAge) {
        this.customerAge = customerAge;
    }


    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    @Override
    public String toString() {
        return "CustomerVO{" +
                "id=" + customerId +
                ", name='" + customerName + '\'' +
                ", age=" + customerAge +
                ", sex='" + customerSex + '\'' +
                ", address='" + customerAddress + '\'' +
                ", phone='" + customerPhone + '\'' +
                '}';
    }


}
