package com.my.springbootadmin.mail.example;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

public class SendTextMail {

    public static void main(String[] args) throws MessagingException, IOException {
        String from = "1010665027@qq.com";
        String to = "1010665027@qq.com";
        String subject = "test";
        String body = "test!";
        String smtpHost = "smtp.qq.com";
        String secretKey = "msshjujdgonibeji";  //授权码

        Properties props = new Properties();
        props.setProperty("mail.transport.protocol", "smtp"); //使用的协议
        props.setProperty("mail.smtp.host", smtpHost);        //smtp服务器地址
        props.setProperty("mail.smtp.auth", "true");          //请求认证

        //创建session实例
        Session session = Session.getDefaultInstance(props);
        //创建MimeMessage实例
        MimeMessage message = new MimeMessage(session);
        message.setFrom(from);
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
        message.setSentDate(new Date());
        message.setSubject(subject);
        message.setText(body);
        message.saveChanges();

        session.setDebug(true);
        //获取Transport对象
        Transport transport = session.getTransport("smtp");
        transport.connect(from, secretKey);
        transport.sendMessage(message, message.getAllRecipients());
        transport.close();

    }
}
