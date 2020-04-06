package com.my.springbootadmin.repository;

import com.my.springbootadmin.model.CoreAccount;
import com.my.springbootadmin.model.CoreTimer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * 定时任务repository
 */
public interface CoreAccountRepository extends JpaRepository<CoreAccount, String> {

    CoreAccount findByCaUserNameAndCaPassword(String username, String password);

    CoreAccount findByCaUserName(String username);

    @Modifying
    @Query("update CoreAccount c set c.caPassword = :password where c.caUserName = :name")
    Integer updatePasswordByName(@Param("password") String password, @Param("name") String name);

}
