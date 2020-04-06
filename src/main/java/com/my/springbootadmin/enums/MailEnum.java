package com.my.springbootadmin.enums;

import lombok.Getter;

/**
 * http请求 所有返回的结果状态值
 * Created by user on 2019/3/16.
 */
@Getter
public enum MailEnum {

    SEND_SUCCESS(0, "成功"),

    ADDRESS_NOT_EXIST(1, "邮件地址不存在"),
    ADDRESS_ERROR(2, "邮件地址错误"),

    UNDEFINED_ERROR(9, "未明确定义错误"),
    ;

    private Integer code;

    private String message;

    MailEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
