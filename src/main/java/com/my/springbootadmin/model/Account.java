package com.my.springbootadmin.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class Account {

    @Id
    @GeneratedValue
    private int id;
    private String userCode;
    private String userName;
    private String password;
    private String telphone;

}
