package com.my.springbootadmin.mail.example;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

public class HtmlMessage {

    public static void main(String[] args) throws MessagingException, IOException {
        String from = "123456@qq.com";
        String to = "123456@sina.com";
        String subject = "test";
        String body = "<h4>欢迎您!boss</h4>";

        //创建session实例
        Session session = Session.getDefaultInstance(new Properties());
        //创建MimeMessage实例
        MimeMessage message = new MimeMessage(session);
        message.setFrom(from);
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
        message.setSentDate(new Date());
        message.setSubject(subject);
        message.setContent(body, "text/html;charset=utf-8");
        message.saveChanges();
        message.writeTo(new FileOutputStream("D:\\test.eml"));

    }
}
