package com.my.springbootadmin.service.impl;

import com.my.springbootadmin.model.CoreTimer;
import com.my.springbootadmin.repository.CoreTimerRepository;
import com.my.springbootadmin.service.CoreTimerService;
import com.my.springbootadmin.service.ScheduledTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class CoreTimerServiceImp implements CoreTimerService {

    @Autowired
    private CoreTimerRepository coreTimerRepository;
    @Autowired
    private ScheduledTaskService scheduledTaskService;

    @Override
    public List<CoreTimer> listAll() {
        return coreTimerRepository.findAll();
    }

    @Transactional
    @Override
    public void updateByUuid(String uuid, String cron) {
        //更新业务数据
        coreTimerRepository.updateCronByUuid(uuid, cron);
        //重启定时任务
        scheduledTaskService.restart(uuid);
    }

    @Transactional
    @Override
    public void deleteByUuid(String uuid) {
        //删除业务数据
        coreTimerRepository.deleteById(uuid);
        //停止定时任务
        scheduledTaskService.stop(uuid);
    }
}
