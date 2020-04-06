package com.my.springbootadmin.controller;

import com.my.springbootadmin.enums.ResultEnum;
import com.my.springbootadmin.exception.MailException;
import com.my.springbootadmin.exception.ResultException;
import com.my.springbootadmin.model.CoreAccount;
import com.my.springbootadmin.model.CoreTimer;
import com.my.springbootadmin.service.CoreAccountService;
import com.my.springbootadmin.utils.ResultVOUtil;
import com.my.springbootadmin.vo.ResultVO;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.repository.query.Param;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 开放的接口类
 */
@RestController
@RequestMapping("/public")
public class PublicController {

    @Autowired
    private CoreAccountService accountService;
    @Autowired
    private Environment env;
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @RequestMapping("/resetPwd")
    public ResultVO resetPwd(@Param("account") CoreAccount account){
        //重置账户的密码,并发送至本人的邮箱
        //查询是否存在该人员
        CoreAccount user = accountService.selectByName(account);
        if(user != null){
            //如果存在此人，则重置密码，并发送邮件告知密码
            if(!StringUtils.hasText(user.getEmail())){
                throw new ResultException(ResultEnum.USER_EMAIL_NO_EXIST);
            }
            String resetPwd = "123456";
            user.setCaPassword(resetPwd);
            Integer count = accountService.updatePasswordByName(user);
            if(count == 1){
                rabbitTemplate.setMessageConverter(new Jackson2JsonMessageConverter());
                rabbitTemplate.convertAndSend(env.getProperty("mail.exchange.name"),
                        env.getProperty("mail.routing.key.name"), user);
            }
        }else{
            //未查找到该人员
            throw new ResultException(ResultEnum.USER_NO_EXIST);
        }
        return ResultVOUtil.success();
    }
}
