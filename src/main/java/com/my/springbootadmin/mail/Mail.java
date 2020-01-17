package com.my.springbootadmin.mail;

/**
 * 邮件接口
 */
public interface Mail {

    /**
     * 发送邮件
     * @param reveiver 接受者（邮箱账号）
     * @param content 内容
     * @return 成功标识,0失败1成功
     */
    Integer sendMail(String reveiver, Object content);

    /**
     * 接收邮件
     */
    void receiveMail();
}
