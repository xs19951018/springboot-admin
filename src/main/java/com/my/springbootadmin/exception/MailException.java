package com.my.springbootadmin.exception;

import com.my.springbootadmin.enums.MailEnum;
import com.my.springbootadmin.enums.ResultEnum;

/**
 * Created by user on 2019/3/16.
 */
public class MailException extends RuntimeException {

    private Integer code;

    public MailException(MailEnum mailEnum) {
        super(mailEnum.getMessage());

        this.code = mailEnum.getCode();
    }

    public MailException(Integer code, String message) {
        super(message);
        this.code = code;
    }
}
