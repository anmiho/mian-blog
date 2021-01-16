package com.mian.service.impl;

import com.mian.mapper.*;
import com.mian.mapper.TagMapper;
import com.mian.redis.RedisService;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;

/**
 * @Description: 服务实现类基类
 * @Author mian
 * @Date 2020/12/31 16:12
 */
public class BaseService {

    @Resource
    protected AdminMapper adminMapper;

    @Resource
    protected ArticleMapper articleMapper;

    @Resource
    protected TagMapper tagMapper;

    @Resource
    protected CommentMapper commentMapper;

    @Resource
    protected MenuMapper menuMapper;

    @Resource
    protected LinkMapper linkMapper;

    @Resource
    protected KindMapper kindMapper;

    @Resource
    protected ArticleKindMapper articleKindMapper;

    @Resource
    protected ArticleTagMapper articleTagMapper;

    @Resource
    protected FrontMapper frontMapper;

    @Resource
    protected StatisticsMapper statisticsMapper;

    @Autowired
    protected RedisService redisService;

//    @Autowired
//    protected RestHighLevelClient client;

}
