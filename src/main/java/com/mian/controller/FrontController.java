package com.mian.controller;

import com.alibaba.fastjson.JSONObject;
import com.mian.entity.Front;
import com.mian.entity.Link;
import com.mian.entity.Menu;
import com.mian.redis.AdminKey;
import com.mian.utils.CacheUtils;
import com.mian.utils.LogUtils;
import org.slf4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: 前台控制器，主要控制展示的信息【公告，友链，菜单】
 * @Author mian
 * @Date 2021/1/16 20:13
 */
@RestController
public class FrontController extends BaseController {

    private Logger logger = LogUtils.getInstance(FrontController.class);

    /**
     * 更新公告
     */
    @PostMapping("/updateFront")
    public String updateFront(Front temp){
        temp.setId(1);
        if (frontService.update(temp)) {
            result.setCode(200);
           // CacheUtils.cleanAdminCache(redisService);
            logger.warn("【成功】更新公告");
        }else {
            result.setCode(500);
            logger.warn("【失败】更新公告");
        }
        //redisService.del(AdminKey.getByFront,String.valueOf(temp.getId()));
        return JSONObject.toJSONString(result);
    }

    /**
     * 添加菜单
     */
    @PostMapping("/addMenu")
    public String addMenu(Menu menu){
        if (menuService.insert(menu)) {
            result.setCode(200);
            CacheUtils.cleanAdminCache(redisService);
            logger.warn("【成功】添加菜单");
        }else {
            result.setCode(500);
            logger.warn("【失败】添加菜单");
        }
//        redisService.del(MenuKey.getLeftMenu,"");
//        redisService.del(MenuKey.getRightMenu,"");
        return JSONObject.toJSONString(result);
    }

    /**
     * 添加友情链接
     */
    @PostMapping("/addLink")
    public String addLink(Link link){
        if (linkService.insert(link)) {
            result.setCode(200);
            CacheUtils.cleanAdminCache(redisService);
            logger.warn("【成功】添加友情链接");
        }else {
            result.setCode(500);
            logger.warn("【失败】添加友情链接");
        }
      //  redisService.del(LinkKey.getIndex,"");
        return JSONObject.toJSONString(result);
    }

    /**
     * 删除菜单
     */
    @GetMapping("/deleteMenu")
    public String deleteMenu(@RequestParam("id")Integer id){
        if (menuService.deleteById(id)) {
            result.setCode(200);
            CacheUtils.cleanAdminCache(redisService);
            logger.warn("【成功】删除菜单，ID："+id);
        }else {
            result.setCode(500);
            logger.warn("【失败】删除菜单，ID："+id);
        }
//        redisService.del(MenuKey.getLeftMenu,"");
//        redisService.del(MenuKey.getRightMenu,"");
        return JSONObject.toJSONString(result);
    }

    /**
     * 删除友情链接
     */
    @GetMapping("/deleteLink")
    public String deleteLink(@RequestParam("id")Integer id){
        if (linkService.deleteById(id)) {
            result.setCode(200);
            CacheUtils.cleanAdminCache(redisService);
            logger.warn("【成功】删除友情链接，ID："+id);
        }else {
            result.setCode(500);
            logger.warn("【失败】删除友情链接，ID："+id);
        }
//        redisService.del(LinkKey.getIndex,"");
        return JSONObject.toJSONString(result);
    }

}
