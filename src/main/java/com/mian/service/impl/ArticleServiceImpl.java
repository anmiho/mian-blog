package com.mian.service.impl;

import com.mian.entity.*;
import com.mian.service.ArticleService;
import com.mian.utils.ImageUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Description: Article服务实现类
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

    /**
     * @param id 主键
     * @return boolean 是否成功
     * @Description 删除Article
     */
    @Override
    public boolean deleteById(Integer id) {
        if (articleMapper.deleteById(id) == 1) {
            // 删除标签的关联信息
            articleTagMapper.deleteById(id);
            // 删除文集的关联信息
            articleKindMapper.deleteById(id);
            return true;
        }
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
        Article article = new Article();
        article.setTitle(title);
        article.setContent(content);
        article.setStatus(status);
        article.setComment(0);
        article.setImg(ImageUtils.getRandomFace());
        // 发布
        if (status != 0) {
            article.setPublishTime(new Date());
        }
        article.setRecentEdit(new Date());
        article.setReadCount(0);
        // 摘要为空
        if ("".equals(introduce)) {
            introduce = content.length() > 100 ? content.substring(0, 100) : content;
        }
        article.setIntroduce(introduce);
        articleMapper.insert(article);

        // 处理输入的标签集合
        if (!"".equals(tags)) {
            List<Tag> tagList = dealTag(tags);
            tagList.forEach(tag -> {
                List<Tag> list = tagMapper.queryAll(tag);
                if (list.size() == 0) {
                    // 标签不存在，先添加标签再添加关联
                    tag.setImg(ImageUtils.getRandomFace());
                    tagMapper.insert(tag);
                    articleTagMapper.insert(new ArticleTag(article.getId(), tag.getId()));
                } else {
                    // 标签已存在则添加数据到关联表
                    articleTagMapper.insert(new ArticleTag(article.getId(), list.get(0).getId()));
                }
            });
        }

        // 处理获取到的文集
        if (!"".equals(kind)) {
            List<Kind> kinds = kindMapper.queryAll(new Kind(kind));
            articleKindMapper.insert(new ArticleKind(article.getId(), kinds.get(0).getId()));
        }
        return article.getId();
    }

    /**
     * @return boolean
     * @Description 更新文章
     * @Param [id, title, content, tags, kind, introduce, status]
     **/
    @Override
    public boolean update(Integer id, String title, String content, String tags, String kind, String introduce, Integer status) {
        // 首先获取文章
        Article article = articleMapper.queryById(id);
        article.setTitle(title);
        article.setContent(content);
        if ("".equals(introduce)) {
            // 摘要为空，取content内容
            String s = content.replaceAll(" ", "");
            s = s.replaceAll("#", "");
            s = s.replaceAll("\n", "");
            if (s.length() > 100) {
                introduce = s.substring(0, 100);
            }
        }
        article.setIntroduce(introduce);
        article.setStatus(status);
        // 如果原来的文章发布时间为空
        if (ObjectUtils.isEmpty(article.getPublishTime())) {
            article.setPublishTime(new Date());
        }
        if (articleMapper.update(article) == 1) {
            // 处理输入的标签集合
            articleTagMapper.deleteById(id);
            if (!"".equals(tags)) {
                List<Tag> tagList = dealTag(tags);
                tagList.forEach(tag -> {
                    List<Tag> list = tagMapper.queryAll(tag);
                    if (list.size() == 0) {
                        // 标签不存在，先添加标签在添加关联
                        tag.setImg(ImageUtils.getRandomFace());
                        tagMapper.insert(tag);
                        articleTagMapper.insert(new ArticleTag(article.getId(), tag.getId()));
                    } else {
                        ArticleTag articleTag = new ArticleTag(article.getId(), list.get(0).getId());
                        // 判断是否已经关联此标签
                        List<ArticleTag> result = articleTagMapper.queryAll(articleTag);
                        if (result.size() == 0) {
                            // 添加数据到关联表
                            articleTagMapper.insert(articleTag);
                        }
                    }
                });
            }
            // 处理文集
            articleKindMapper.deleteById(id);
            if (!"".equals(kind)) {
                List<Kind> kinds = kindMapper.queryAll(new Kind(kind));
                articleKindMapper.insert(new ArticleKind(article.getId(), kinds.get(0).getId()));
            }
            return true;
        } else {
            return false;
        }
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

    /**
     * @return java.lang.Integer
     * @Description 删除全部回收站文章
     * @Param []
     **/
    @Override
    public Integer deleteTrash() {
        return articleMapper.deleteTrash();
    }

    @Override
    public List<Article> queryByStatus(Integer status) {
        return null;
    }

    /**
     * @return java.util.List<com.mian.entity.Tag>
     * @Description 处理标签
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
