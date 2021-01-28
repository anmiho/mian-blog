package com.mian.service;

import com.mian.entity.Comment;

import java.util.List;

/**
 * @Description: Comment服务接口
 * @Author mian
 * @Date 2021/1/11 21:50
 */
public interface CommentService {

    /**
     * @param comment 实例对象
     * @return 是否成功
     * @Description 添加Comment
     */
    boolean insert(Comment comment);

    /**
     * @param id 主键
     * @return 是否成功
     * @Description 删除Comment
     */
    boolean deleteById(Integer id);

    /**
     * @param id 回复ID
     * @return 影响行数
     * @Description 删除Comment
     */
    boolean deleteByReplyId(Integer id);


    /**
     * @param id 文章ID
     * @return 影响行数
     * @Description 删除Comment
     */
    boolean deleteByArticleId(Integer id);

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
     * @param comment 实例对象
     * @return 是否成功
     * @Description 修改数据，哪个属性不为空就修改哪个属性
     */
    boolean update(Comment comment);

    /**
     * @return java.util.List<com.mian.entity.Comment>
     * @Description 根据文章ID和类型获取文章
     * @Param [aId, type]
     **/
    List<Comment> queryByArticleIdAndType(Integer aId, Integer type);

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