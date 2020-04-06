package com.my.springbootadmin.rabbitmq;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.my.springbootadmin.enums.MailEnum;
import com.my.springbootadmin.exception.MailException;
import com.my.springbootadmin.mail.Mail;
import com.my.springbootadmin.mail.MailContent;
import com.my.springbootadmin.mail.imp.QQMail;
import com.my.springbootadmin.mail.imp.VerifyContent;
import com.my.springbootadmin.model.CoreAccount;
import com.my.springbootadmin.model.UserLog;
import com.my.springbootadmin.repository.UserLogRepository;
import com.my.springbootadmin.utils.UuidUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.mail.MessagingException;

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

    //用户重置密码,发送邮件告知密码
    @RabbitListener(queues = "${mail.queue.name}", containerFactory = "singleListenerContainer")
    public void userResetPwd(@Payload CoreAccount user){
        Mail mail = new QQMail();
        MailContent content = new VerifyContent();
        try {
            mail.sendMail(user.getEmail(),
                    content.sendContent(user.getCaPassword()));
        } catch (Exception e) {
            //throw new MailException(MailEnum.UNDEFINED_ERROR);
        }
    }
}
