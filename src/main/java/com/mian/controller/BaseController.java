package com.mian.controller;

import com.mian.dto.ResponseResult;
import com.mian.entity.Admin;
import com.mian.redis.RedisService;
import com.mian.service.AdminService;
import com.mian.service.ArticleService;
import org.elasticsearch.client.RestHighLevelClient;
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
    AdminService adminService;
    @Autowired
    ArticleService articleService;
//    @Autowired
//    KindService kindService;
//    @Autowired
//    TagService tagService;
//    @Autowired
//    FrontService frontService;
//    @Autowired
//    MenuService menuService;
//    @Autowired
//    LinkService linkService;
//    @Autowired
//    CommentService commentService;
//    @Autowired
//    StatisticsService statisticsService;
    @Autowired
    RedisService redisService;
//    @Autowired
//    RabbitTemplate rabbitTemplate;
//    @Autowired
//    RestHighLevelClient client;

    protected HttpServletRequest request;
    protected HttpServletResponse response;
    protected HttpSession session;

    protected ResponseResult result;
    protected Admin loginAdmin;
//    protected Admin user;
//    protected Front front;

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
