package com.mian.config;

import cn.hutool.core.date.DateUtil;

import java.util.Date;

/**
 * @Description: 码云图床配置
 * @Author mian
 * @Date 2020/12/31 18:39
 */
public interface GiteeImgBedConfig {
    /**
     * 码云分配的私人令牌Token
     */
    String ACCESS_TOKEN = "fbb481149cb983ffd292dc1b936b0f25";

    /**
     * 码云用户名
     */
    String OWNER = "anmiho";

    /**
     * 仓库名称
     */
    String REPO_NAME = "blog-images";

    /**
     * 上传图片的message
     */
    String CREATE_REPOS_MESSAGE = "博客上传图片";

    /**
     * 文件前缀
     */
    String IMG_FILE_DEST_PATH = DateUtil.format(new Date(), "yyyy-MM-dd") + "/";

    /**
     * 新建文件URL
     * 第一个 %s =>仓库所属空间地址(owner)
     * 第二个 %s => 仓库路径(repo)
     * 第三个 %s => 文件的路径(path)
     */
    String CREATE_REPOS_URL = "https://gitee.com/api/v5/repos/%s/%s/contents/%s";

    /**
     * GitPage请求路径
     */
    String GITPAGE_REQUEST_URL = "https://gitee.com/"+OWNER+"/"+REPO_NAME+"/raw/master/";
}
