package com.my.springbootadmin.service;

import com.my.springbootadmin.model.CoreTimer;

import java.util.List;

/**
 * 定时任务service
 */
public interface RedisService {

    List<CoreTimer> findAll();

    CoreTimer findById(String uuid);

}
