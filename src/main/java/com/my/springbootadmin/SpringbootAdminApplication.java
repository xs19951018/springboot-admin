package com.my.springbootadmin;

import com.my.springbootadmin.filter.MyFilter;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;

import javax.servlet.Filter;

@EnableCaching  //开启缓存
@MapperScan(value = "com.my.springbootadmin.dao")
@SpringBootApplication
public class SpringbootAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootAdminApplication.class, args);
    }

}
