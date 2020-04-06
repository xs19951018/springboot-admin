package com.my.springbootadmin.mail;

/**
 * 邮件内容
 */
public interface MailContent {

    //发送的消息
    String sendContent(String message);
}
