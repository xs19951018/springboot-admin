package com.my.springbootadmin.service.impl;

import com.my.springbootadmin.model.CoreTimer;
import com.my.springbootadmin.repository.CoreTimerRepository;
import com.my.springbootadmin.service.CoreTimerService;
import com.my.springbootadmin.service.RedisService;
import com.my.springbootadmin.service.ScheduledTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class RedisServiceImp implements RedisService {

    @Autowired
    private CoreTimerRepository coreTimerRepository;

    @Cacheable(value = "common", key = "'timer_all'")
    @Override
    public List<CoreTimer> findAll() {
        return coreTimerRepository.findAll();
    }

    @Cacheable(value = "common", key = "'timer_'+#uuid", unless = "#uuid == null ")
    @Override
    public CoreTimer findById(String uuid) {
        Optional<CoreTimer> optional = coreTimerRepository.findById(uuid);
        if(optional.isPresent()){
            return optional.get();
        }
        return null;
    }

}
