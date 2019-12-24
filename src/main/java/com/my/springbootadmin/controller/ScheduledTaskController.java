package com.my.springbootadmin.controller;

import com.my.springbootadmin.model.CoreTimer;
import com.my.springbootadmin.service.ScheduledTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/schedule")
@RestController
public class ScheduledTaskController {

    @Autowired
    private ScheduledTaskService scheduledTaskService;

    @RequestMapping("/listAll")
    public List<CoreTimer> listAll(){
        List<CoreTimer> coreTimerList = scheduledTaskService.listAll();
        return coreTimerList;
    }

    @RequestMapping("/start")
    public String start(@Param("uuid") String uuid){
        scheduledTaskService.start(uuid);
        return "start task";
    }

    @RequestMapping("/stop")
    public String stop(@Param("uuid") String uuid){
        scheduledTaskService.stop(uuid);
        return "stop task";
    }

    @RequestMapping("/restart")
    public String restart(@Param("uuid") String uuid){
        scheduledTaskService.restart(uuid);
        return "restart task";
    }
}
