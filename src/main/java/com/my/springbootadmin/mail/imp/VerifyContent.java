package com.my.springbootadmin.mail.imp;

import com.my.springbootadmin.mail.MailContent;

/**
 * 验证码消息
 */
public class VerifyContent implements MailContent {

    @Override
    public String sendContent(String message) {
        StringBuilder sb = new StringBuilder();
        sb.append("<html><head></head><body>");
        sb.append("<h1>【springboot-admin 邮件中心】</h1>");
        sb.append("<h3>您正在使用修改密码功能，验证码为 "+message+" 。如果不是本人操作，请忽略该邮件，如果一直出现问题请联系 ****** [请勿回复]</h3>");
        sb.append("</body></html>");
        return sb.toString();
    }
}
