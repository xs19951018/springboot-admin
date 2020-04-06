package com.my.springbootadmin.exception;

import com.my.springbootadmin.enums.ResultEnum;

/**
 * Created by user on 2019/3/16.
 */
public class ResultException extends RuntimeException {

    private Integer code;

    public ResultException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());

        this.code = resultEnum.getCode();
    }

    public ResultException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }
}
