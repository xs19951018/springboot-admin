package com.my.springbootadmin.listener;

import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyListenerConfigure {

    @Bean
    public ServletListenerRegistrationBean listenerRegist(){
        ServletListenerRegistrationBean listenerRegistBean = new ServletListenerRegistrationBean();
        listenerRegistBean.setListener(new MyHttpSessionListener());
        return listenerRegistBean;
    }
}
