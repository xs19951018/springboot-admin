package com.my.springbootadmin.service;

import com.my.springbootadmin.model.CoreTimer;

import java.util.List;

/**
 * 定时任务service
 */
public interface CoreTimerService {

    /**
     * 查询所有定时任务列表
     * @return
     */
    List<CoreTimer> listAll();

    /**
     * 通过uuid修改定时任务
     * @param uuid
     */
    void updateByUuid(String uuid, String cron);

    /**
     * 通过uuid删除任务
     * @param uuid
     */
    void deleteByUuid(String uuid);

}
