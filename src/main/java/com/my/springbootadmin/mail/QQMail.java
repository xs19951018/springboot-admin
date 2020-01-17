package com.my.springbootadmin.mail;

import java.util.Properties;

/**
 * qq邮箱
 */
public class QQMail implements Mail {

    @Override
    public Integer sendMail(String reveiver, Object content) {
        //创建一个配置文件
        Properties properties = new Properties();
        properties.setProperty("mail.host","smtp.qq.com");
        properties.setProperty("mail.transport.protocol","smtp");
        properties.setProperty("mail.smtp.auth","true");


        return null;
    }

    @Override
    public void receiveMail() {

    }
}
