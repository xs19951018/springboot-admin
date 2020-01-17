package com.my.springbootadmin.mail.example;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

public class TextMessage {

    public static void main(String[] args) throws MessagingException, IOException {
        String from = "123456@qq.com";
        String to = "123456@sina.com";
        String subject = "test";
        String body = "test!";

        //创建session实例
        Session session = Session.getDefaultInstance(new Properties());
        //创建MimeMessage实例
        MimeMessage message = new MimeMessage(session);
        message.setFrom(from);
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
        message.setSentDate(new Date());
        message.setSubject(subject);
        message.setText(body);
        message.saveChanges();
        message.writeTo(new FileOutputStream("D:\\test.eml"));

    }
}
