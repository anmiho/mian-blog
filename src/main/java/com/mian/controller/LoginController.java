package com.mian.controller;

import cn.hutool.crypto.digest.MD5;
import com.alibaba.fastjson.JSONObject;
import com.mian.entity.Admin;
import com.mian.utils.LogUtils;
import org.slf4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

/**
 * @Description: 登录控制器
 * @Author mian
 * @Date 2020/12/23 18:07
 */
@Controller
public class LoginController extends BaseController {
    private Logger logger = LogUtils.getInstance(LoginController.class);

//    /**
//     * 测试设置密码
//     */
//    @PostMapping("/password")
//    @ResponseBody
//    public String password(@RequestParam("password") String password) {
//        // 获取管理员对象
//        Admin admin = adminService.queryById(1);
//        // 获取Md5加密对象
//        MD5 md5 = new MD5(admin.getSalt().getBytes());
//        // 进行判断
//        String key = md5.digestHex16(password);
//        System.out.println(key);
//        return key;
//    }

    /**
     * 免密登录，用于开发测试【上线删除】
     */
    @GetMapping("/admin")
    public String admin() {
        // 获取管理员对象
        Admin admin = adminService.queryById(1);
        admin.setRecentLogin(new Date());
        adminService.update(admin);
        session.setAttribute("admin", admin);
        logger.warn("【成功】免密登录ok");
        return "redirect:/dashboard";
    }

    /**
     * 管理员登录
     */
    @PostMapping("/login")
    @ResponseBody
    public String login(String name, String password) {
        // 获取管理员对象
        Admin admin = adminService.queryById(1);
        // 获取Md5加密对象
        MD5 md5 = new MD5(admin.getSalt().getBytes());
        // 进行判断
        if (admin.getName().equals(name) && admin.getPassword().equals(md5.digestHex16(password))) {
            result.setCode(200);
            logger.warn("【成功】密码登录");
            admin.setRecentLogin(new Date());
            adminService.update(admin);
            session.setAttribute("admin", admin);
        } else {
            result.setCode(100);
            logger.warn("【错误】密码登录，用户名或密码错误");
        }
        return JSONObject.toJSONString(result);
    }

    /**
     * 退出登录
     */
    @GetMapping("/logout")
    public String logout(){
        session.invalidate();
        logger.warn("【成功】退出登录");
        return "redirect:/admin-login";
    }


}
