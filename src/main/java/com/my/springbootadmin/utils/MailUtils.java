package com.my.springbootadmin.utils;

import javax.mail.Session;
import java.util.Properties;

/**
 * 邮件工具类
 */
public class MailUtils {

    /**
     * 发送邮件
     * @return
     */
    public static Integer sendMail(){
        String from = "1010665027@qq.com";
        String to = "1010665027@qq.com";
        String smtpHost = "smtp.qq.com";
        String secretKey = GlobalVar.QQ_SMTP_KEY;  //授权码

        Properties props = new Properties();
        props.setProperty("mail.transport.protocol", "smtp"); //使用的协议
        props.setProperty("mail.smtp.host", smtpHost);        //smtp服务器地址
        props.setProperty("mail.smtp.auth", "true");          //请求认证

        //创建session实例
        Session session = Session.getDefaultInstance(props);

        return null;
    }

    /**
     * 接受邮件
     */
    public static void reveiveMail(){


    }
}
