package com.my.springbootadmin.repository;

import com.my.springbootadmin.model.CoreTimer;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.beans.Transient;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CoreTimerRepositoryTest {

    @Autowired
    private CoreTimerRepository coreTimerRepository;

    @Test
    public void save(){
        CoreTimer coreTimer = new CoreTimer();
        coreTimer.setCtUuid("1");
        coreTimer.setCtName("测试一");
        coreTimer.setCtCron("0 0/10 0 ? ? *");
        coreTimer.setCtOrder(1);

        coreTimer = coreTimerRepository.save(coreTimer);
        Assert.assertNotNull(coreTimer);
    }

    @Test
    public void findOne(){
        Optional<CoreTimer> optional = coreTimerRepository.findById("1");   //optional java8新特性
        System.out.println(optional.get());
        Assert.assertNotNull(optional.get());
    }

    @Test
    public void findAll(){
        List<CoreTimer> list = coreTimerRepository.findAll();
        System.out.println(list.toString());
        Assert.assertNotNull(list.get(0));
    }

    @Transactional
    @Rollback(false)
    @Test
    public void modified(){
        Integer flag = coreTimerRepository.updateCoreNameByCoreUuid("1", "测试二");
        System.out.println(flag);
        Assert.assertEquals(Integer.valueOf(1), flag);
    }

    @Transactional
    @Rollback(false)
    @Test
    public void delete(){
        coreTimerRepository.deleteById("1");
    }

    @Test
    public void updateByCondition(){
    }
}