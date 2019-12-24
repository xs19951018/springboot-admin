package com.my.springbootadmin.service;

import com.my.springbootadmin.model.CoreTimer;

import java.util.List;

/**
 * 任务调度接口
 */
public interface ScheduledTaskService {

    //启动任务
    Boolean start(String uuid);

    //停止任务
    Boolean stop(String uuid);

    //重启任务
    Boolean restart(String uuid);

    //初始化所有任务
    void initAllTask();

    //查询任务列表
    List<CoreTimer> listAll();

}
