package com.my.springbootadmin.model;

/**
 * 账户表
 */
public class CoreAccount {

    private String caUuid;
    private String caUserName;
    private String caPassword;
    private Integer telphone;
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

    public Integer getTelphone() {
        return telphone;
    }

    public void setTelphone(Integer telphone) {
        this.telphone = telphone;
    }

    public Integer getCaOrder() {
        return caOrder;
    }

    public void setCaOrder(Integer caOrder) {
        this.caOrder = caOrder;
    }

    @Override
    public String toString() {
        return "CoreAccount{" +
                "caUuid='" + caUuid + '\'' +
                ", caUserName='" + caUserName + '\'' +
                ", caPassword='" + caPassword + '\'' +
                ", telphone=" + telphone +
                ", caOrder=" + caOrder +
                '}';
    }
}
