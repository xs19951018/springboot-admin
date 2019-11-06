package com.my.springbootadmin.filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;

@Configuration
public class MyFilterConfigure {

    @Bean
    public FilterRegistrationBean myFilterRegister(){
        FilterRegistrationBean filterRegister = new FilterRegistrationBean();

        filterRegister.setFilter(new MyFilter());
        filterRegister.addUrlPatterns("/*");
        filterRegister.setName("MyFilter");
        filterRegister.addInitParameter("paramName", "paramValue");
        filterRegister.setOrder(1);
        return filterRegister;
    }


}
