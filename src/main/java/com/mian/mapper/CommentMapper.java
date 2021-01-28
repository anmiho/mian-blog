package com.mian.mapper;

import com.mian.entity.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Description: Comment数据访问层
 * @Author mian
 * @Date 2021/1/7 22:45
 */
@Mapper
public interface CommentMapper {
    /**
     * @param comment 实例对象
     * @return 影响行数
     * @Description 添加Comment
     */
    int insert(Comment comment);

    /**
     * @param id 主键
     * @return 影响行数
     * @Description 删除Comment
     */
    int deleteById(Integer id);

    /**
     * @param id 回复ID
     * @return 影响行数
     * @Description 删除Comment
     */
    int deleteByReplyId(Integer id);

    /**
     * @param id 文章ID
     * @return 影响行数
     * @Description 删除Comment
     */
    int deleteByArticleId(Integer id);

    /**
     * @param id 主键
     * @return 实例对象
     * @Description 查询单条数据
     */
    Comment queryById(Integer id);

    /**
     * @param comment 实例对象
     * @return 对象列表
     * @Description 实体作为筛选条件查询数据
     */
    List<Comment> queryAll(Comment comment);

    /**
     * @param comment
     * @return 影响行数
     * @Description 修改Comment, 根据 comment 的主键修改数据
     */
    int update(Comment comment);

    /**
     * @return java.util.List<com.mian.entity.Comment>
     * @Description 根据文章ID和类型获取评论
     * @Param [aId, type]
     **/
    List<Comment> queryByArticleIdAndType(@Param("aId") Integer aId, @Param("type") Integer type);

    /**
     * @return java.util.List<com.mian.entity.Comment>
     * @Description 获取所有回复的评论
     * @Param [id]
     **/
    List<Comment> queryReplyComment(Integer id);

    /**
     * @return java.lang.Integer
     * @Description 获取评论的数量
     * @Param []
     **/
    Integer getCount();

    /**
     * @return java.lang.Integer
     * @Description 获取未读评论的数量
     * @Param []
     **/
    Integer getUnReadCount();
}
