package com.my.springbootadmin.controller;

import com.my.springbootadmin.scheduleTask.DynamicScheduleTask;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CoreTimerController {

    @RequestMapping("/updateCron")
    @ResponseBody
    public String updateCron(){
        DynamicScheduleTask dynamicScheduleTask = new DynamicScheduleTask();
        dynamicScheduleTask.setCron("0/5 * * * * ?");
        return "success";
    }
}
