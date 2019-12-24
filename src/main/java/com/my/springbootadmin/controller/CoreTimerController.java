package com.my.springbootadmin.controller;

import com.my.springbootadmin.model.CoreTimer;
import com.my.springbootadmin.scheduleTask.DynamicScheduleTask;
import com.my.springbootadmin.service.CoreTimerService;
import com.my.springbootadmin.service.ScheduledTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 定时任务业务controller
 */
@RequestMapping("/timer")
@Controller
public class CoreTimerController {

    @Autowired
    private CoreTimerService coreTimerService;

    @ResponseBody
    @RequestMapping("/listAll")
    public List<CoreTimer> listAll(){
        List<CoreTimer> coreTimerList = coreTimerService.listAll();
        return coreTimerList;
    }

    @RequestMapping("/updateByUuid")
    public String stop(@Param("uuid") String uuid, @Param("cron") String cron){
        coreTimerService.updateByUuid(uuid, cron);
        return "stop task";
    }

    @RequestMapping("/deleteByUuid")
    public String restart(@Param("uuid") String uuid){
        coreTimerService.deleteByUuid(uuid);
        return "restart task";
    }
}
