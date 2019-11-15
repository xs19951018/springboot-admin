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

@Component
@Configuration
@EnableScheduling
public class DynamicScheduleTask implements SchedulingConfigurer {

    private Logger logger = LoggerFactory.getLogger(DynamicScheduleTask.class);

    @Autowired
    private CoreTimerRepository timerRepository;

    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        //taskRegistrar.addTriggerTask(Runnable, Trigger);

        List<CoreTimer> coreTimerList = timerRepository.findAll();
        if(coreTimerList != null && coreTimerList.size()>0){
            for(int i=0;i<coreTimerList.size();i++){
                if(StringUtils.hasText(coreTimerList.get(i).getCtServiceName())){
                    //如果存在任务，则刷新任务
                    String cron = coreTimerList.get(i).getCtCron();

                    taskRegistrar.addTriggerTask(new Runnable() {
                        @Override
                        public void run() {
                            logger.info("[DynamicScheduleTask]定时任务刷新:");
                        }
                    }, new Trigger() {
                        @Override
                        public Date nextExecutionTime(TriggerContext triggerContext) {
                            //改变cron运行时间
                            CronTrigger cronTrigger = new CronTrigger(cron);
                            Date nextExec = cronTrigger.nextExecutionTime(triggerContext);
                            return nextExec;
                        }
                    });
                }
            }
        }
    }
}
