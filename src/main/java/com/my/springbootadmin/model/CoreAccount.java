package com.my.springbootadmin.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 账户表
 */
@Data
@Entity
@org.hibernate.annotations.Table(appliesTo = "core_account", comment = "账户表")
public class CoreAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String caUuid;
    private String caUserName;
    private String caPassword;
    private String telphone;
    private String email;
    private Integer caOrder;

    public String getCaUuid() {
        return caUuid;
    }

    public void setCaUuid(String caUuid) {
        this.caUuid = caUuid;
    }

    public String getCaUserName() {
        return caUserName;
    }

    public void setCaUserName(String caUserName) {
        this.caUserName = caUserName;
    }

    public String getCaPassword() {
        return caPassword;
    }

    public void setCaPassword(String caPassword) {
        this.caPassword = caPassword;
    }

    public String getTelphone() {
        return telphone;
    }

    public void setTelphone(String telphone) {
        this.telphone = telphone;
    }

    public Integer getCaOrder() {
        return caOrder;
    }

    public void setCaOrder(Integer caOrder) {
        this.caOrder = caOrder;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    @Override
    public String toString() {
        return "CoreAccount{" +
                "caUuid='" + caUuid + '\'' +
                ", caUserName='" + caUserName + '\'' +
                ", caPassword='" + caPassword + '\'' +
                ", telphone='" + telphone + '\'' +
                ", email='" + email + '\'' +
                ", caOrder=" + caOrder +
                '}';
    }
}
