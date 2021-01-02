package com.mian.service.impl;

import com.mian.entity.Article;
import com.mian.entity.ArticleDateArchive;
import com.mian.entity.ArticleKind;
import com.mian.entity.ArticleTag;
import com.mian.entity.Tag;
import com.mian.service.ArticleService;
import com.mian.utils.ImageUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Description: Admin服务实现类
 * @Author mian
 * @Date 2020/12/31 16:13
 */
@Service("articleService")
public class ArticleServiceImpl extends BaseService implements ArticleService {
    /**
     * @param article 实例对象
     * @return 是否成功
     * @Description 添加文章
     */
    @Override
    public boolean insert(Article article) {
        if (articleMapper.insert(article) == 1) {
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteById(Integer id) {
        return false;
    }

    @Override
    public Article queryById(Integer id) {
        return null;
    }

    @Override
    public boolean update(Article article) {
        return false;
    }

    @Override
    public Integer totalCount(Integer status) {
        return null;
    }

    /**
     * @return Integer
     * @Description 发布文章
     * @Param [title, content, tags, kind]
     **/
    @Override
    public Integer publish(String title, String content, String tags, String kind, String introduce, Integer status) {
//        Article article = new Article();
//        article.setTitle(title);
//        article.setContent(content);
//        article.setStatus(status);
//        article.setComment(0);
//        article.setImg(ImageUtils.getRandomFace());
//        if (status != 0) {
//            article.setPublishTime(new Date());
//        }
//        article.setRecentEdit(new Date());
//        article.setReadCount(0);
//        if ("".equals(introduce)) {
//            // 摘要为空
//            introduce = content.length() > 100 ? content.substring(0, 100) : content;
//        }
//        article.setIntroduce(introduce);
//        articleMapper.insert(article);
//        // 处理输入的标签集合
//        if (!"".equals(tags)) {
//            List<Tag> tagList = dealTag(tags);
//            tagList.forEach(tag -> {
//                List<Tag> list = tagMapper.queryAll(tag);
//                if (list.size() == 0) {
//                    // 标签不存在,先添加标签在添加关联
//                    tag.setImg(ImageUtils.getRandomFace());
//                    tagMapper.insert(tag);
//                    articleTagMapper.insert(new ArticleTag(article.getId(), tag.getId()));
//                } else {
//                    // 标签已存在则添加数据到关联表
//                    articleTagMapper.insert(new ArticleTag(article.getId(), list.get(0).getId()));
//                }
//            });
//        }
//
//        // 处理获取到的文集
//        if (!"".equals(kind)) {
//            List<Kind> kinds = kindMapper.queryAll(new Kind(kind));
//            articleKindMapper.insert(new ArticleKind(article.getId(), kinds.get(0).getId()));
//        }
//        return article.getId();
        return 1;
    }

    @Override
    public boolean update(Integer id, String title, String content, String tags, String kind, String introduce, Integer status) {
        return false;
    }

    @Override
    public List<Article> orderByReadCount() {
        return null;
    }

    @Override
    public List<ArticleDateArchive> getArchive() {
        return null;
    }

    @Override
    public List<Article> orderByPublishTime(Integer page) {
        return null;
    }

    @Override
    public void addReadCount(Integer id) {

    }

    @Override
    public Integer getReadCount(Integer id) {
        return null;
    }

    @Override
    public String getTitle(Integer aId) {
        return null;
    }

    @Override
    public List<Article> findByTagId(Integer id) {
        return null;
    }

    @Override
    public List<Article> findByKindId(Integer id) {
        return null;
    }

    @Override
    public List<Article> findByDate(Date date) {
        return null;
    }

    @Override
    public List<Article> searchFromEs(String content) {
        return null;
    }

    @Override
    public void initEs() {

    }

    @Override
    public long getEsDocCount() {
        return 0;
    }

    @Override
    public Integer deleteTrash() {
        return null;
    }

    @Override
    public List<Article> queryByStatus(Integer status) {
        return null;
    }

    /**
     * @return java.util.List<com.moti.entity.Tag>
     * @Description 处理标签
     * @Author 莫提
     * @Date 9:06 2020/9/9
     * @Param [tags]
     **/
    public List<Tag> dealTag(String tags) {
        String[] strings = tags.split(";");
        List<Tag> list = new ArrayList<>();
        for (String s : strings) {
            if (!"".equals(s)) {
                list.add(new Tag(s));
            }
        }
        return list;
    }
}
