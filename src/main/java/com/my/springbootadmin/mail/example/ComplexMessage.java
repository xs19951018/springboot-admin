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

public class ComplexMessage {

    public static void main(String[] args) throws MessagingException, IOException {
        //创建session实例
        Session session = Session.getDefaultInstance(new Properties());
        MimeMessage message = createMessage(session);
        message.writeTo(new FileOutputStream("D:\\test.eml"));
    }

    private static MimeMessage createMessage(Session session) throws MessagingException, IOException {
        String from = "123456@qq.com";
        String to = "123456@sina.com";
        String subject = "HTML邮件";
        String body = "<h4>欢迎您!boss</h4>" +
                "<img src=\"C:\\Users\\admin\\Pictures\\me\\1.png\">";

        //创建MimeMessage实例
        MimeMessage message = new MimeMessage(session);
        message.setFrom(from);
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
        message.setSentDate(new Date());
        message.setSubject(subject);

        //创建邮件正文内容MimeBodyPart对象
        MimeBodyPart contentPart = createContent(body, "C:\\Users\\admin\\Pictures\\me\\1.png");
        //创建邮件附件MimeBodyPart对象
        MimeBodyPart attPart1 = createAttachment("D:\\fmpp.jar");
        MimeBodyPart attPart2 = createAttachment("D:\\360极速浏览器下载\\行政人员信息模板.xls");

        //创建要给MimeMultipart对象
        MimeMultipart multipart = new MimeMultipart("mixed");
        multipart.addBodyPart(contentPart);
        multipart.addBodyPart(attPart1);
        multipart.addBodyPart(attPart2);

        //设置整个邮件的内容
        message.setContent(multipart);
        message.saveChanges();
        return  message;
    }

    //创建邮件正文
    public static MimeBodyPart createContent(String body, String fileName) throws MessagingException {
        MimeBodyPart contentBodyPart = new MimeBodyPart();
        MimeMultipart contentMultiPart = new MimeMultipart("related");

        //创建一个html正文的MimeBodyPart对象
        MimeBodyPart htmlBodyPart = new MimeBodyPart();
        htmlBodyPart.setContent(body, "text/html;charset=utf-8");
        contentMultiPart.addBodyPart(htmlBodyPart);
        //创建一个图片内容的MimeBodyPart对象
        MimeBodyPart imgBodyPart = new MimeBodyPart();
        FileDataSource fds = new FileDataSource(fileName);
        imgBodyPart.setFileName(fds.getName());
        imgBodyPart.setDataHandler(new DataHandler(fds));
        contentMultiPart.addBodyPart(imgBodyPart);

        contentBodyPart.setContent(contentMultiPart);
        return  contentBodyPart;
    }

    //创建邮件附件
    public static MimeBodyPart createAttachment(String fileName) throws MessagingException {
        //创建一个附件的MimeBodyPart对象
        MimeBodyPart attBodyPart = new MimeBodyPart();
        FileDataSource fds = new FileDataSource(fileName);
        attBodyPart.setFileName(fds.getName());
        attBodyPart.setDataHandler(new DataHandler(fds));
        return attBodyPart;
    }
}
