package com.my.springbootadmin.repository;

import com.my.springbootadmin.model.CoreTimer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * 定时任务repository
 */
public interface CoreTimerRepository extends JpaRepository<CoreTimer, String> {

    @Modifying
    @Query("update CoreTimer c set c.ctName = :name where c.ctUuid = :id")
    Integer updateCoreNameByCoreUuid(@Param("id") String id, @Param("name") String name);

    @Modifying
    @Query("update CoreTimer c set c.ctCron = :ctCron where c.ctUuid = :ctUuid")
    Integer updateCronByUuid(@Param("ctUuid") String ctUuid, @Param("ctCron") String ctCron);
}
