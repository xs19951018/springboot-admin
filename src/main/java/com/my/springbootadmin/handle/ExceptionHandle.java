package com.my.springbootadmin.handle;

import com.my.springbootadmin.exception.ResultException;
import com.my.springbootadmin.utils.ResultVOUtil;
import com.my.springbootadmin.vo.ResultVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by user on 2019/3/4.
 */
@ControllerAdvice
public class ExceptionHandle {

    private final static Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResultVO handle(Exception e){
        if(e instanceof ResultException){
            ResultException resultException = (ResultException)e;
            return ResultVOUtil.error(resultException.getCode(), resultException.getMessage());
        }else {
            logger.error("【系统异常】{}", e);
            return ResultVOUtil.error(-1, "未知错误!");
        }
    }
}
