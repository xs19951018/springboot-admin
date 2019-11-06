package com.my.springbootadmin.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class MyFilter implements Filter {

    private static Logger logger = LoggerFactory.getLogger(MyFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        logger.info("[MyFilter]自定义拦截器初始化");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        long start = System.currentTimeMillis();
        logger.info("[MyFilter]方法调用开始start.......................");
        //logger.info("自定义过滤器拦截,url:"+request.getRequestURI());
        filterChain.doFilter(servletRequest, servletResponse);
        logger.info("[MyFilter]方法调用结束end,消耗:"+(System.currentTimeMillis()-start)/1000+"s.......................");
    }

    @Override
    public void destroy() {
        logger.info("[MyFilter]自定义拦截器销毁");
    }
}
