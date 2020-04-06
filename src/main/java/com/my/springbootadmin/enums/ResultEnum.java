package com.my.springbootadmin.enums;

import lombok.Getter;

/**
 * http请求 所有返回的结果状态值
 * Created by user on 2019/3/16.
 */
@Getter
public enum ResultEnum {

    RESULT_SUCCESS(0, "成功"),
    PARAM_ERROR(1, "参数不正确"),
    UNDEFINED_ERROR(9, "未明确定义错误"),

    //人员类
    USER_NO_EXIST(11, "不存在此人员"),
    USER_EMAIL_NO_EXIST(12, "邮箱不存在"),
    ;

    private Integer code;

    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
