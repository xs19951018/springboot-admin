package com.my.springbootadmin.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Data
@Entity
public class CoreTimer {

    @Id
    private String ctUuid;
    private String ctName;
    private String ctCron;
    private Integer ctOrder;

    public static void main(String[] args) {
        CoreTimer timer = new CoreTimer();
        timer.setCtUuid(UUID.randomUUID().toString());
        timer.setCtName("统计在线人数");
        timer.setCtCron("");
        timer.setCtOrder(1);

    }
}
