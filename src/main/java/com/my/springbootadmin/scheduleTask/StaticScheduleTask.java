package com.my.springbootadmin.scheduleTask;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 静态定时任务
 */
@Component
@Configuration
@EnableScheduling //开启定时
public class StaticScheduleTask {

    private Logger logger = LoggerFactory.getLogger(StaticScheduleTask.class);

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Scheduled(cron = "0 0/15 * * * ?")
    private void onTimeAlarm(){
        logger.info("[StaticScheduleTask]整点报时,当前时间:" + sdf.format(new Date()));
    }
}
