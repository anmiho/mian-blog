package com.mian.mapper;

import com.mian.entity.ArticleTag;
import com.mian.entity.Tag;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Description: ArticleTag数据库访问层
 * @Author mian
 * @Date 2020/12/31 18:51
 */
@Mapper
public interface ArticleTagMapper {

    /**
     * @Description 添加ArticleTag
     * @param articleTag 实例对象
     * @return 影响行数
     */
    int insert(ArticleTag articleTag);

    /**
     * @Description 删除ArticleTag
     * @param articleId 主键
     * @return 影响行数
     */
    int deleteById(Integer articleId);

    /**
     * @Description 实体作为筛选条件查询数据
     * @param articleTag 实例对象
     * @return 对象列表
     */
    List<ArticleTag> queryAll(ArticleTag articleTag);

    /**
     * @Description 根据标签ID获取关联文章的数量
     * @Param [id]
     * @return java.lang.Integer
     **/
    Integer getArticleCount(Integer id);

    /**
     * @Description 根据文章ID查询所有标签
     * @Param [id]
     * @return java.util.List<com.mian.entity.Tag>
     **/
    List<Tag> queryByArticleId(Integer id);
}
