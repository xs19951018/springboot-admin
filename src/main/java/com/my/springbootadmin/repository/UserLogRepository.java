package com.my.springbootadmin.repository;

import com.my.springbootadmin.model.CoreAccount;
import com.my.springbootadmin.model.UserLog;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 定时任务repository
 */
public interface UserLogRepository extends JpaRepository<UserLog, String> {

}
