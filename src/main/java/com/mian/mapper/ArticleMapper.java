package com.mian.mapper;

import com.mian.entity.Article;
import com.mian.entity.ArticleDateArchive;
import org.apache.ibatis.annotations.Mapper;

import java.util.Date;
import java.util.List;

/**
 * @Description: Article数据库访问层
 * @Author mian
 * @Date 2020/12/31 16:29
 */
@Mapper
public interface ArticleMapper {

    /**
     * @param article 实例对象
     * @return 影响行数
     * @Description 添加文章
     */
    int insert(Article article);

    /**
     * @param id 主键
     * @return 影响行数
     * @Description 删除文章
     */
    int deleteById(Integer id);

    /**
     * @param id 主键
     * @return 实例对象
     * @Description 查询单条数据
     */
    Article queryById(Integer id);

    /**
     * @return java.util.List<com.mian.entity.Article>
     * @Description 根据状态获取文章
     * @Param [status]
     **/
    List<Article> queryByStatus(Integer status);

    /**
     * @param article
     * @return 影响行数
     * @Description 修改Article, 根据 article 的主键修改数据
     */
    int update(Article article);

    /**
     * @return java.lang.Integer
     * @Description 根据条件获取文章数量
     * @Param [article]
     **/
    Integer totalCount(Integer status);

    /**
     * @return java.util.List<com.mian.entity.Article>
     * @Description 获取阅读量最高的文章
     * @Param []
     **/
    List<Article> orderByReadCount();

    /**
     * @return java.util.List<com.mian.entity.ArticleDateArchive>
     * @Description 获得文章日期归档
     * @Param []
     **/
    List<ArticleDateArchive> getArchive();

    /**
     * @return java.util.List<com.mian.entity.Article>
     * @Description 根据发表时间降序获取文章
     * @Param []
     **/
    List<Article> orderByPublishTime();

    /**
     * @return java.lang.String
     * @Description 根据Id获得文章标题
     * @Param [aId]
     **/
    String getTitle(Integer aId);

    /**
     * @return java.util.List<com.mian.entity.Article>
     * @Description 根据标签ID获取已发布的文章
     * @Param [id]
     **/
    List<Article> findByTagId(Integer id);

    /**
     * @return java.util.List<com.mian.entity.Article>
     * @Description 根据文集ID获取已发布的文章
     * @Param [id]
     **/
    List<Article> findByKindId(Integer id);

    /**
     * @return java.util.List<com.mian.entity.Article>
     * @Description 根据日期归档获取文章
     * @Param [date]
     **/
    List<Article> findByDate(Date date);

    /**
     * @return java.lang.Integer
     * @Description 删除全部回收站文章
     * @Param []
     **/
    Integer deleteTrash();
}
