package com.my.springbootadmin.service.impl;

import com.my.springbootadmin.model.CoreTimer;
import com.my.springbootadmin.repository.CoreTimerRepository;
import com.my.springbootadmin.service.CoreTimerService;
import com.my.springbootadmin.service.ScheduledTaskService;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.engine.internal.Collections;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.TriggerContext;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.locks.ReentrantLock;

@Slf4j
@Service
public class ScheduledTaskServiceImpl implements ScheduledTaskService {

    @Autowired
    private ThreadPoolTaskScheduler threadPoolTaskScheduler;
    @Autowired
    private CoreTimerRepository coreTimerRepository;

    //可重入锁
    private ReentrantLock lock = new ReentrantLock();
    //存放已经启动的任务
    private Map<String, ScheduledFuture> scheduledFutureMap = new ConcurrentHashMap<>();

    @Override
    public Boolean start(String uuid) {
        log.info("[ScheduledTaskService]启动定时任务start,uuid="+uuid);
        lock.lock();
        try {
            //检验是否已经启动
            if(this.scheduledFutureMap.containsKey(uuid)){
                log.info("[ScheduledTaskService]启动定时任务end,result=该任务已经启动,无需重复启动");
                return false;
            }
            //判断任务是否存在
            Optional<CoreTimer> optional = coreTimerRepository.findById(uuid);
            if(!optional.isPresent()){
                log.info("[ScheduledTaskService]启动定时任务end,result=数据库中没有配置该任务");
                return false;
            }
            //启动任务
            this.doStartTask(optional.get());
        } finally {
            lock.unlock();
            log.info("[ScheduledTaskService]释放任务启动锁");
        }
        log.info("[ScheduledTaskService]启动定时任务end,uuid="+uuid);
        return true;
    }

    @Override
    public Boolean stop(String uuid) {
        log.info("[ScheduledTaskService]停止定时任务start,uuid="+uuid);
        //判断当前任务是否存在启动列表中
        if(!scheduledFutureMap.containsKey(uuid)){
            log.info("[ScheduledTaskService]停止定时任务end,result=启动列表中无该项任务");
            return false;
        }
        //停止该任务
        ScheduledFuture scheduledFuture = scheduledFutureMap.get(uuid);
        scheduledFuture.cancel(true);
        //从已启动集合中移除
        scheduledFutureMap.remove(uuid);
        log.info("[ScheduledTaskService]停止定时任务end,uuid="+uuid);
        return true;
    }

    @Override
    public Boolean restart(String uuid) {
        log.info("[ScheduledTaskService]重启定时任务start,uuid="+uuid);
        //先停止
        this.stop(uuid);
        //后启动
        this.start(uuid);
        log.info("[ScheduledTaskService]重启定时任务end   ,uuid="+uuid);
        return true;
    }

    @Override
    public void initAllTask() {
        List<CoreTimer> coreTimerList = coreTimerRepository.findAll();
        log.info("[ScheduledTaskService]初始化所有定时任务start,count:"+coreTimerList.size());

        if(CollectionUtils.isEmpty(coreTimerList)){
            log.info("[ScheduledTaskService]初始化所有定时任务end,result=无需要启动的任务");
            return;
        }
        for(CoreTimer coreTimer : coreTimerList){
            String uuid = coreTimer.getCtUuid();
            if(scheduledFutureMap.containsKey(uuid)){
                continue;
            }
            this.doStartTask(coreTimer);
        }
        log.info("[ScheduledTaskService]初始化所有定时任务end");
    }

    /**
     * 执行启动任务
     * @param coreTimer
     */
    private void doStartTask(CoreTimer coreTimer){
        //执行时间
        String cron = coreTimer.getCtCron();
        //执行service
        String serviceName = coreTimer.getCtServiceName();
        //执行方法
        String methodName = coreTimer.getCtMethodName();

        //scheduledFuture保存起来,可以控制这个任务的开启，关闭
        ScheduledFuture future = threadPoolTaskScheduler.schedule(
                new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("执行任务........"+new Date());
                    }
                },
                new Trigger() {
                    @Override
                    public Date nextExecutionTime(TriggerContext triggerContext) {
                        return new CronTrigger(cron).nextExecutionTime(triggerContext);
                    }
                }
        );
        //添加到已启动map中
        scheduledFutureMap.put(coreTimer.getCtUuid(), future);
    }

    @Override
    public List<CoreTimer> listAll() {
        return coreTimerRepository.findAll();
    }

}
