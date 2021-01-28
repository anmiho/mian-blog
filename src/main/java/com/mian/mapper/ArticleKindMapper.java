package com.mian.mapper;

import com.mian.entity.ArticleKind;
import com.mian.entity.Kind;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Description: ArticleKind数据访问层
 * @Author mian
 * @Date 2021/1/7 22:44
 */
@Mapper
public interface ArticleKindMapper {
    /**
     * @param articleKind 实例对象
     * @return 影响行数
     * @Description 添加ArticleKind
     */
    int insert(ArticleKind articleKind);

    /**
     * @param articleId 主键
     * @return 影响行数
     * @Description 删除ArticleKind
     */
    int deleteById(Integer articleId);

    /**
     * @return java.lang.Integer
     * @Description 根据文集ID获取关联文章的数量
     * @Param [id]
     **/
    Integer getArticleCount(Integer id);

    /**
     * @return java.util.List<com.mian.entity.Kind>
     * @Description 根据文章ID查询所有分类
     * @Param [id]
     **/
    Kind queryByArticleId(Integer id);
}
