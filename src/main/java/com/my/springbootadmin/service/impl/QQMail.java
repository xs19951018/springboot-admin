package com.my.springbootadmin.service.impl;

import com.my.springbootadmin.service.Mail;

import java.util.Properties;

/**
 * qq邮箱
 */
public class QQMail implements Mail {

    @Override
    public Integer sendMail(String reveiver, Object content) {
        Properties properties = new Properties();
        properties.put("", "");


        return null;
    }

    @Override
    public void receiveMail() {

    }
}
