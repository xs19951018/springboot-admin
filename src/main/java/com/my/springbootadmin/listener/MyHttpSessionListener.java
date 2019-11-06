package com.my.springbootadmin.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * session监听器：统计在线人数
 */
@Component
public class MyHttpSessionListener implements HttpSessionListener {

    private static Logger logger = LoggerFactory.getLogger(MyHttpSessionListener.class);
    private static int online = 0;

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        online ++;
        logger.info("[MyHttpSessionListener]session创建,在线人数:" + online + "人...............");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        online --;
        logger.info("[MyHttpSessionListener]session销毁,在线人数:" + online + "人...............");
    }
}
