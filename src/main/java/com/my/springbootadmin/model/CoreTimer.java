package com.my.springbootadmin.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;
import java.util.UUID;

@Data
@Entity
public class CoreTimer {

    @Id
    private String ctUuid;
    private String ctName;
    //service接口名称
    private String ctServiceName;
    //method方法名称
    private String ctMethodName;
    private String ctCron;
    private Date ctCreateTime;
    private Date ctUpdateTime;
    private Integer ctStatus;
    private Integer ctOrder;

    public static void main(String[] args) {
        CoreTimer timer = new CoreTimer();
        timer.setCtUuid(UUID.randomUUID().toString());
        timer.setCtName("统计在线人数");
        timer.setCtCron("");
        timer.setCtOrder(1);

    }
}
