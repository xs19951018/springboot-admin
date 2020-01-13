package com.my.springbootadmin.rabbitmq;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.my.springbootadmin.model.UserLog;
import com.my.springbootadmin.repository.UserLogRepository;
import com.my.springbootadmin.utils.UuidUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CommonMqListener {

    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    private UserLogRepository userLogRepository;

    //用户登录日志记录
    @RabbitListener(queues = "${log.user.login.queue.name}", containerFactory = "singleListenerContainer")
    public void userLoginQueue(@Payload UserLog userLog){
        userLog.setUlUuid(UuidUtils.getUuid());
        userLogRepository.save(userLog);
    }
}
