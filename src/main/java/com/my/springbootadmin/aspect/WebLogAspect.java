package com.my.springbootadmin.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * 方法日志 Aspect
 */
@Aspect
@Order(1)
@Component
public class WebLogAspect {

    private static Logger logger = LoggerFactory.getLogger(WebLogAspect.class);

    ThreadLocal<Long> startTime = new ThreadLocal<Long>();

    //切入点
    @Pointcut("execution(public * com.my.springbootadmin.controller..*.*(..))")
    public void webLog(){}

    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) throws Throwable{
        //接收到请求，获取请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        startTime.set(System.currentTimeMillis());

        //记录请求内容
        logger.info("[WebLogAspect]URL :"+request.getRequestURL().toString());
        logger.info("[WebLogAspect]HTTP_METHOD :"+request.getMethod());
        logger.info("[WebLogAspect]IP :"+request.getRemoteAddr());
        logger.info("[WebLogAspect]CLASS_METHOD :"+joinPoint.getSignature().getDeclaringTypeName()
                + "." + joinPoint.getSignature().getName());
        logger.info("[WebLogAspect]ARGS :"+ Arrays.toString(joinPoint.getArgs()));
    }

    @AfterReturning(returning = "ret", pointcut = "webLog()")
    public void doAfterReturning(Object ret) throws Throwable{
        //处理完请求，返回内容
        logger.info("[WebLogAspect]RESPONSE :" + ret);
        logger.info("[WebLogAspect]SPEND_TIME :" + (System.currentTimeMillis()-startTime.get())/1000 + "s");

    }
}
