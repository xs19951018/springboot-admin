package com.my.springbootadmin.model;

import lombok.Data;
import org.hibernate.annotations.Columns;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Data
@Entity
@org.hibernate.annotations.Table(appliesTo = "core_timer", comment = "定时任务表")
public class CoreTimer implements Serializable {

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
    @Column(nullable = false,columnDefinition = "comment '状态0禁止,1启用'")
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
