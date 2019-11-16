package com.my.springbootadmin.scheduleTask;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

/**
 * 定时任务配置
 */
@Configuration
public class ScheduledTaskConfigure {

    private Logger logger = LoggerFactory.getLogger(ScheduledTaskConfigure.class);

    @Bean
    public ThreadPoolTaskScheduler threadPoolTaskScheduler(){
        ThreadPoolTaskScheduler threadPoolTaskScheduler = new ThreadPoolTaskScheduler();
        threadPoolTaskScheduler.setPoolSize(5);
        threadPoolTaskScheduler.setThreadNamePrefix("taskExcutor-");
        threadPoolTaskScheduler.setWaitForTasksToCompleteOnShutdown(true);
        threadPoolTaskScheduler.setAwaitTerminationSeconds(60);

        logger.info("[ScheduledTaskConfigure]初始化定时任务线程池结束");
        return threadPoolTaskScheduler;
    }
}
