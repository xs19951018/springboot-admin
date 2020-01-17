package com.my.springbootadmin.mail.example;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

public class ReceiveMail {

    public static void main(String[] args) throws MessagingException, IOException {
        String userMail = "1010665027@qq.com";
        String pop3Server = "pop.qq.com";
        String protocol = "pop3";
        String secretKey = "msshjujdgonibeji";  //授权码

        Properties props = new Properties();
        props.setProperty("mail.transport.protocol", protocol); //使用的协议
        props.setProperty("mail.smtp.host", pop3Server);        //smtp服务器地址

        //获取连接
        Session session = Session.getDefaultInstance(props);
        session.setDebug(true);
        //获取Store对象
        Store store = session.getStore(protocol);
        store.connect(pop3Server, userMail, secretKey);  //pop3服务器登录认证

        Folder folder = store.getFolder("INBOX");
        folder.open(Folder.READ_WRITE); //设置权限
        Message[] messages = folder.getMessages();

        for(Message message : messages){
            //获取邮件主题
            String subject = message.getSubject();
            //获取发送地址
            Address from = message.getFrom()[0];
            System.out.println("*******************************");
            System.out.println("发件人："+from+",邮件主题："+subject);
            System.out.println("*******************************");
            //输出到控制台
            //message.writeTo(System.out);
        }
        folder.close(false);
        store.close();

    }
}
