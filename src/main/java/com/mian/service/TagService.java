package com.mian.service;

import com.mian.entity.Tag;

import java.util.List;

/**
 * @Description: Tag服务接口
 * @Author mian
 * @Date 2021/1/11 21:50
 */
public interface TagService {

    /**
     * @param tag 实例对象
     * @return 是否成功
     * @Description 添加Tag
     */
    boolean insert(Tag tag);

    /**
     * @param id 主键
     * @return 是否成功
     * @Description 删除Tag
     */
    boolean deleteById(Integer id);

    /**
     * @param id 主键
     * @return 实例对象
     * @Description 查询单条数据
     */
    Tag queryById(Integer id);

    /**
     * @return 对象列表
     * @Description 查询全部数据
     * <p>
     * 分页使用MyBatis的插件实现
     */
    List<Tag> queryAll();

    /**
     * @param tag 实例对象
     * @return 对象列表
     * @Description 实体作为筛选条件查询数据
     */
    List<Tag> queryAll(Tag tag);

    /**
     * @param tag 实例对象
     * @return 是否成功
     * @Description 修改数据，哪个属性不为空就修改哪个属性
     */
    boolean update(Tag tag);

    /**
     * @return java.util.List<com.moti.entity.Tag>
     * @Description 根据文章ID查询所有标签
     * @Param [id]
     **/
    List<Tag> queryByArticleId(Integer id);

    /**
     * @return java.lang.Integer
     * @Description 根据标签ID获取关联文章的数量
     * @Param [id]
     **/
    Integer getArticleCount(Integer id);

    /**
     * @return java.lang.Integer
     * @Description 获取评论的数量
     * @Param []
     **/
    Integer getCount();

}