package com.mian.controller;

import com.alibaba.fastjson.JSONObject;
import com.mian.dto.ResponseResult;
import com.mian.entity.Article;
import com.mian.utils.LogUtils;
import org.slf4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: 文章控制器
 * @Author mian
 * @Date 2020/12/23 18:09
 */
@Controller
public class ArticleController extends BaseController {
    private Logger logger = LogUtils.getInstance(ArticleController.class);

//    /**
//     * 测试添加文章
//     * @return
//     */
//    @PostMapping("/insert")
//    public String insert(String title, String content, String tags, String kind, String introduce) {
//
//        Article a = new Article();
//        a.setComment(888);
//        a.setIntroduce("测试文章123测试文章");
//        a.setStatus(1);
//        a.setTitle("测试文章");
//        boolean id = articleService.insert(a);
//        if (id) {
//            logger.warn("【成功】测试添加文章成功");
//        } else {
//            logger.warn("【失败】测试添加文章失败");
//        }
//        result.setCode(200);
//        result.setData("结果是" + id);
//        return "index.html";
//    }

    /**
     * 文章发布
     */
    @PostMapping("/publish")
    public String publish(String title, String content, String tags, String kind, String introduce) {
        Integer id = articleService.publish(title, content, tags, kind, introduce, 1);
        logger.warn("【成功】文章发布成功，ID：" + id);
        result.setCode(200);
        result.setData(id);
//        CacheUtils.cleanArticleCache(redisService,null);
//        rabbitTemplate.convertAndSend("es","article.save", id);
//        redisService.incr(ArticleKey.getEsCount,"");
        return JSONObject.toJSONString(result);
    }

    /**
     * 文章发布
     */
    @GetMapping("/login")
    public String login() {

        return "login";
    }
}
