package com.my.springbootadmin.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Data
@Entity
//@org.hibernate.annotations.Table(appliesTo = "user_log", comment = "登录信息表")
public class UserLog {

    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private String ulUuid;
    private String ulCaUuid;
    private String ulName;
    private Date ulLoginTime;
    private Integer ulOrder;

}
