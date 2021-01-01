package com.mian.service.impl;

import com.mian.mapper.ArticleMapper;
import com.mian.mapper.ArticleTagMapper;
import com.mian.mapper.TagMapper;

import javax.annotation.Resource;

/**
 * @Description: 服务实现类基类
 * @Author mian
 * @Date 2020/12/31 16:12
 */
public class BaseService {

    @Resource
    protected ArticleMapper articleMapper;

    @Resource
    protected TagMapper tagMapper;

    @Resource
    protected ArticleTagMapper articleTagMapper;

}
