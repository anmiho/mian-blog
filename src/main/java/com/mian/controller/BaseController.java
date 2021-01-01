package com.mian.controller;

import com.mian.dto.ResponseResult;
import com.mian.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @Description: 控制器基类，其他控制器继承此类
 * @Author mian
 * @Date 2020/12/23 18:08
 */
public class BaseController {

    @Autowired
    ArticleService articleService;

    protected HttpServletRequest request;
    protected HttpServletResponse response;
    protected HttpSession session;

    protected ResponseResult result;

    /**
     * 在每个子类方法调用之前先调用，设置request,response,session这三个对象
     */
    @ModelAttribute
    public void setReqAndRes(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
        this.session = request.getSession(true);
        result = new ResponseResult();
//        // 设置admin对象
//        loginAdmin = (Admin)session.getAttribute("admin");
//        // 获取前台主页对象
//        front = frontService.queryById(1);
//        // 获取用户对象
//        user = adminService.queryById(1);
//        user.setPassword(null);
//        user.setRecentLogin(null);
//        user.setOpenId(null);
//        user.setSalt(null);
    }
}
