package com.my.springbootadmin.repository;

import com.my.springbootadmin.model.CoreTimer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 定时任务repository
 */
public interface CoreTimerRepository extends JpaRepository<CoreTimer, String> {

}
