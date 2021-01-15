package com.my.springbootadmin.asyncRequest;

import com.my.springbootadmin.model.Account;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderTask extends Thread {

    private Logger logger = LoggerFactory.getLogger(OrderTask.class);

    @Autowired
    private RequestQueue queue;
    private boolean running = true;

    @Override
    public void run() {
        while (running) {
            try {
                Account person = queue.getOrderQueue().take();
                logger.info("开始处理订单：{}", person.getUserName());

                Thread.sleep(5000);
                logger.info("订单处理完成：{}", person.getUserName());

            } catch (InterruptedException e) {
                e.printStackTrace();
                running = false;
            }

        }
    }

    public void setRunning(boolean running) {
        this.running = running;
    }
}
