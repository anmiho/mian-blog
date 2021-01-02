package com.mian.interceptor;

import com.mian.entity.Admin;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Description: 登录拦截器
 * @Author mian
 * @Date 2021/1/2 21:16
 */
public class LoginHandlerInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Admin admin = (Admin) request.getSession().getAttribute("admin");
        //用户未登录，返回登录页面
        if (admin == null){
            response.sendRedirect("/mian-blog/error401Page");
            return false;
        }else{
            //登录放行
            return false;
        }
    }
}
