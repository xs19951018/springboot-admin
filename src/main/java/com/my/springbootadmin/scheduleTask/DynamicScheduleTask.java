package com.my.springbootadmin.scheduleTask;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.TriggerContext;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;

import java.util.Date;

public class DynamicScheduleTask implements SchedulingConfigurer {

    private Logger logger = LoggerFactory.getLogger(DynamicScheduleTask.class);

    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        taskRegistrar.addTriggerTask(new Runnable() {
            @Override
            public void run() {
                logger.info("[DynamicScheduleTask]定时任务执行:");
            }
        }, new Trigger() {
            @Override
            public Date nextExecutionTime(TriggerContext triggerContext) {
                //改变cron运行时间
                String cron = "";
                CronTrigger cronTrigger = new CronTrigger(cron);
                Date nextExec = cronTrigger.nextExecutionTime(triggerContext);
                return nextExec;
            }
        });
    }
}
