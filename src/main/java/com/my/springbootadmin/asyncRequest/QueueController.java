package com.my.springbootadmin.asyncRequest;

import com.my.springbootadmin.model.Account;
import com.my.springbootadmin.utils.ResultVOUtil;
import com.my.springbootadmin.vo.ResultVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/queue")
public class QueueController {

    private Logger logger = LoggerFactory.getLogger(QueueController.class);

    @Autowired
    private RequestQueue queue;
    private int count = 0;

    @RequestMapping("/order")
    public ResultVO order(@RequestBody Account person) throws InterruptedException {
        count ++;
        person.setUserName(person.getUserName() + count);
        queue.getOrderQueue().put(person);
        logger.info("order队列长度:{}", queue.getOrderQueue().size());

        return ResultVOUtil.success();
    }

}
