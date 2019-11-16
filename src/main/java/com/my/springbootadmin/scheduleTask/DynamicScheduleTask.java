package com.my.springbootadmin.scheduleTask;

import com.my.springbootadmin.model.CoreTimer;
import com.my.springbootadmin.repository.CoreTimerRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.TriggerContext;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;

/*@Component
@Configuration
@EnableScheduling*/
public class DynamicScheduleTask implements SchedulingConfigurer {

    private Logger logger = LoggerFactory.getLogger(DynamicScheduleTask.class);

    @Autowired
    private CoreTimerRepository timerRepository;

    private String cron = "0/10 * * * * ?";

    public String getCron() {
        return cron;
    }

    public void setCron(String cron) {
        this.cron = cron;
    }

    @Override
    public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {
        try {
            timerRepository.findAll().forEach((e)->{
                scheduledTaskRegistrar.addTriggerTask(
                        //1.添加任务内容(Runnable)，可以为方法
                        () -> System.out.println("定时任务1"+new Date()),
                        //2.设置执行周期(Trigger)
                        triggerContext -> {
                            //2.1 从数据库获取执行周期，在这里调用不同的方法返回不同的定时任务信息
                            System.out.println(cron);
                            //2.3 返回执行周期(Date)
                            return new CronTrigger(cron).nextExecutionTime(triggerContext);
                        }
                );
            });

        }catch (Exception e){
        }
    }
}
