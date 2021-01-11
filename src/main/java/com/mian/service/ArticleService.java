package com.mian.service;

import com.mian.entity.Article;
import com.mian.entity.ArticleDateArchive;

import java.util.Date;
import java.util.List;

/**
 * @Description: Article服务接口
 * @Author mian
 * @Date 2020/12/31 16:16
 */
public interface ArticleService {
    /**
     * @Description 添加文章
     * @param article 实例对象
     * @return 是否成功
     */
    boolean insert(Article article);

    /**
     * @Description 根据id删除文章
     * @return 是否成功
     */
    boolean deleteById(Integer id);

    /**
     * @Description 根据id查询数据
     * @param id 主键
     * @return 实例对象
     */
    Article queryById(Integer id);

    /**
     * @Description 修改数据，哪个属性不为空就修改哪个属性
     * @param article 实例对象
     * @return 是否成功
     */
    boolean update(Article article);

    /**
     * @Description 根据条件获取文章数量
     * @Param [article]
     * @return Integer
     **/
    Integer totalCount(Integer status);

    /**
     * @Description 发布文章
     * @Param [title, content, tags, kind]
     * @return boolean
     **/
    Integer publish(String title,String content,String tags,String kind,String introduce,Integer status);

    /**
     * @Description 更新文章
     * @Param [id, title, content, tags, kind, introduce, status]
     * @return void
     **/
    boolean update(Integer id,String title,String content,String tags,String kind,String introduce,Integer status);

    /**
     * @Description 获取阅读量最高的文章
     * @Param []
     * @return List<com.mian.entity.Article>
     **/
    List<Article> orderByReadCount();

    /**
     * @Description 获得文章日期归档
     * @Param []
     * @return List<com.mian.entity.ArticleDateArchive>
     **/
    public List<ArticleDateArchive> getArchive();

    /**
     * @Description 根据发表时间降序获取文章
     * @Param []
     * @return java.util.List<com.mian.entity.Article>
     **/
    List<Article> orderByPublishTime(Integer page);

    /**
     * @Description 阅读文章,阅读量加1
     * @Param [id]
     * @return void
     **/
    void addReadCount(Integer id);

    /**
     * @Description 根据id获取阅读量
     * @Param [id]
     * @return Integer
     **/
    Integer getReadCount(Integer id);

    /**
     * @Description 根据id获得文章标题
     * @Param [aId]
     * @return String
     **/
    String getTitle(Integer aId);

    /**
     * @Description 根据标签id获取已发布的文章
     * @Param [id]
     * @return List<com.mian.entity.Article>
     **/
    List<Article> findByTagId(Integer id);

    /**
     * @Description 根据文集id获取已发布的文章
     * @Param [id]
     * @return List<com.mian.entity.Article>
     **/
    List<Article> findByKindId(Integer id);

    /**
     * @Description 根据日期归档获取文章
     * @Param [date]
     * @return List<com.mian.entity.Article>
     **/
    List<Article> findByDate(Date date);

    /**
     * @Description 从ES中搜索
     * @Param [content]
     * @return List<com.mian.entity.Article>
     **/
    List<Article> searchFromEs(String content);

    /**
     * @Description 初始化ES
     * @Param []
     * @return void
     **/
    void initEs();

    /**
     * @Description 获取ES中文档的数量
     * @Param []
     * @return Integer
     **/
    long getEsDocCount();

    /**
     * @Description 删除全部回收站文章
     * @Param []
     * @return Integer
     **/
    Integer deleteTrash();

    /**
     * @Description 根据状态获取文章
     * @Param [status]
     * @return List<com.mian.entity.Article>
     **/
    List<Article> queryByStatus(Integer status);
}
