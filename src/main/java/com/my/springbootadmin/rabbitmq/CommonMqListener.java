package com.my.springbootadmin.rabbitmq;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.my.springbootadmin.model.UserLog;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Slf4j
@Component
public class CommonMqListener {

    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    private ObjectMapper objectMapper;

    //用户登录日志记录
    @RabbitListener(queues = "${log.user.login.queue.name}", containerFactory = "singleListenerContainer")
    public void userLoginQueue(@Payload byte[] message){
        System.out.println(message);
    }
}
