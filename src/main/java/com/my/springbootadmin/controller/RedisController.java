package com.my.springbootadmin.controller;

import com.my.springbootadmin.model.CoreAccount;
import com.my.springbootadmin.model.CoreTimer;
import com.my.springbootadmin.service.CoreTimerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * redis测试controller
 */
@Slf4j
@RequestMapping("/redis")
@Controller
public class RedisController {

    @Autowired
    private CoreTimerService coreTimerService;
    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    @ResponseBody
    @RequestMapping("/getUser")
    public CoreTimer getUser(@Param("uuid") String uuid){
        CoreTimer coreTimer = null;
        if(redisTemplate.hasKey("user_"+uuid)){
            coreTimer = (CoreTimer) redisTemplate.opsForValue().get("user_"+uuid);
            log.info("[RedisController]redis取出key:user_"+uuid+",value:"+coreTimer);
        }else{
            coreTimer = coreTimerService.getOne(uuid);
            if(coreTimer != null){
                redisTemplate.opsForValue().set("user_"+uuid, coreTimer);
                log.info("[RedisController]redis设置key:user_"+uuid+",value:"+coreTimer);
            }
        }
        return coreTimer;
    }

}
