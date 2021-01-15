package com.my.springbootadmin.asyncRequest;

import com.my.springbootadmin.model.Account;
import org.springframework.stereotype.Component;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

@Component
public class RequestQueue {

    private BlockingQueue<Account> orderQueue = new LinkedBlockingQueue<>(1000);

    public BlockingQueue<Account> getOrderQueue() {
        return orderQueue;
    }
}
