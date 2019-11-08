package com.my.springbootadmin.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
public class MyInterceptorConfigure implements WebMvcConfigurer {

    @Autowired
    private MyInterceptor myInterceptor;
    @Autowired
    private LoginInterceptor loginInterceptor;

    private List<String> excludePath = new ArrayList<String>(Arrays.asList("/static/**","/public/**","/favicon.ico"));

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(myInterceptor).addPathPatterns("/hello");
        registry.addInterceptor(loginInterceptor).addPathPatterns("/**").excludePathPatterns(excludePath);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //设置静态资源
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        registry.addResourceHandler("/templates/**").addResourceLocations("classpath:/templates/");
    }
}
