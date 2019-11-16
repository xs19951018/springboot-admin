package com.my.springbootadmin.scheduleTask;

import com.my.springbootadmin.service.ScheduledTaskService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 项目自启动后开启定时任务
 */
@Component
@Order(value = 1)
@Slf4j
public class ScheduleTaskRunner implements ApplicationRunner {

    @Autowired
    private ScheduledTaskService scheduledTaskService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("[ScheduleTaskRunner]初始化定时任务start");
        scheduledTaskService.initAllTask();
        log.info("[ScheduleTaskRunner]初始化定时任务end");
    }
}
