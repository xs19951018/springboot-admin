package com.my.springbootadmin.mail.imp;

import com.my.springbootadmin.enums.MailEnum;
import com.my.springbootadmin.exception.MailException;
import com.my.springbootadmin.mail.Mail;
import com.my.springbootadmin.utils.GlobalVar;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
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

        Transport transport = null;
        try {
            //创建session实例
            Session session = Session.getDefaultInstance(properties);
            //创建MimeMessage实例
            MimeMessage message = new MimeMessage(session);
            message.setFrom(GlobalVar.MAIL_FROM_USER);
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(reveiver));
            message.setSentDate(new Date());
            message.setSubject("验证码");
            message.setContent(content, "text/html;charset=utf-8");
            message.saveChanges();

            session.setDebug(true);
            //获取Transport对象
            transport = session.getTransport("smtp");
            transport.connect(GlobalVar.MAIL_FROM_USER, GlobalVar.QQ_SMTP_KEY);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
        } catch (AddressException e) {
            //throw new MailException(MailEnum.ADDRESS_ERROR);
            e.printStackTrace();
        } catch (NoSuchProviderException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        } finally {
            if(transport != null){
                try {
                    transport.close();
                } catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
        return 1;
    }

    @Override
    public void receiveMail() {

    }
}
