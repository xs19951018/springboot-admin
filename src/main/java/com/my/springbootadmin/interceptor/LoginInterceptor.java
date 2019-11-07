package com.my.springbootadmin.interceptor;

import com.my.springbootadmin.model.CoreAccount;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 登录拦截
 * 1.未登录用户拦截,跳转到登录页面：检查session是否存在用户数据
 */
@Component
public class LoginInterceptor implements HandlerInterceptor {

    private static Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.info("[LoginInterceptor]登录检测start");
        //如果session中存在账户信息，则继续执行，反之，则跳转到登录页面
        /*HttpSession session = request.getSession(false);
        if(session == null){
            session = request.getSession();
            session.setAttribute("loginAccount", new CoreAccount());
        }*/
        HttpSession session = request.getSession();
        CoreAccount account = (CoreAccount) session.getAttribute("loginAccount");
        if(account != null){
            logger.info("[LoginInterceptor]登录检测:用户已登录,执行操作!");
            return true;
        }
        response.sendRedirect("/static/public/html/login/login.html");
        logger.info("[LoginInterceptor]登录检测:用户未登录,请重新登录!");
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
