package com.my.springbootadmin.asyncRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class QueueListener {

    private Logger logger = LoggerFactory.getLogger(QueueListener.class);

    @Autowired
    private OrderTask orderTask;

    @PostConstruct
    public void init() {
        logger.info("orderTask初始化");
        orderTask.start();
        logger.info("orderTask初始化完成");
    }

    @PreDestroy
    public void destory() {
        orderTask.setRunning(false);
    }

}
