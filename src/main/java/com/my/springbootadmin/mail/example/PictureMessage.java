package com.my.springbootadmin.mail.example;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

public class PictureMessage {

    public static void main(String[] args) throws MessagingException, IOException {
        String from = "123456@qq.com";
        String to = "123456@sina.com";
        String subject = "test";
        String body = "<h4>欢迎您!boss</h4>" +
                "<img src=\"C:\\Users\\admin\\Pictures\\me\\1.png\">";

        //创建session实例
        Session session = Session.getDefaultInstance(new Properties());
        //创建MimeMessage实例
        MimeMessage message = new MimeMessage(session);
        message.setFrom(from);
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
        message.setSentDate(new Date());
        message.setSubject(subject);

        //创建要给MimeMultipart对象
        MimeMultipart multipart = new MimeMultipart("related");

        //创建一个html正文的MimeBodyPart对象
        MimeBodyPart htmlBodyPart = new MimeBodyPart();
        htmlBodyPart.setContent(body, "text/html;charset=utf-8");
        multipart.addBodyPart(htmlBodyPart);
        //创建一个图片内容的MimeBodyPart对象
        MimeBodyPart imgBodyPart = new MimeBodyPart();
        FileDataSource fds = new FileDataSource("C:\\Users\\admin\\Pictures\\me\\1.png");
        imgBodyPart.setFileName(fds.getName());
        imgBodyPart.setDataHandler(new DataHandler(fds));
        multipart.addBodyPart(imgBodyPart);

        message.setContent(multipart);
        message.saveChanges();
        message.writeTo(new FileOutputStream("D:\\test.eml"));

    }
}
