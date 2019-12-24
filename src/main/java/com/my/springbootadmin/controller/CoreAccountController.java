package com.my.springbootadmin.controller;

import com.my.springbootadmin.model.CoreAccount;
import com.my.springbootadmin.model.UserLog;
import com.my.springbootadmin.scheduleTask.DynamicScheduleTask;
import com.my.springbootadmin.service.CoreAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/login")
public class CoreAccountController {

    @Autowired
    private CoreAccountService accountService;
    @Autowired
    private Environment env;

    @RequestMapping("/doLogin")
    public String doLogin(@Param("account")CoreAccount account){
        //查询是否存在该人员
        CoreAccount user = accountService.selectByNameAndPwd(account);
        if(user != null){
            //登录成功,异步调用消息写用户日志
            UserLog userLog = new UserLog();
            userLog.setUlCaUuid(user.getCaUuid());
            userLog.setUlName(user.getCaUserName());
            userLog.setUlLoginTime(new Date());
           /* rabbitTemplate.convertAndSend(env.getProperty("log.user.exchange.name"),
                    env.getProperty("log.user.queue.name"), userLog);*/

        }else{
            return "false";
        }
        return "success";
    }
}
