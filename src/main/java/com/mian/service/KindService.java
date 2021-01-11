package com.mian.service;

import com.mian.entity.Kind;

import java.util.List;

/**
 * @Description: Kind服务接口
 * @Author mian
 * @Date 2021/1/11 21:52
 */
public interface KindService {

    /**
     * @param kind 实例对象
     * @return 是否成功
     * @Description 添加Kind
     */
    boolean insert(Kind kind);

    /**
     * @param id 主键
     * @return 是否成功
     * @Description 删除Kind
     */
    boolean deleteById(Integer id);

    /**
     * @param id 主键
     * @return 实例对象
     * @Description 查询单条数据
     */
    Kind queryById(Integer id);

    /**
     * @return 对象列表
     * @Description 查询全部数据
     * <p>
     * 分页使用MyBatis的插件实现
     */
    List<Kind> queryAll();

    /**
     * @param kind 实例对象
     * @return 对象列表
     * @Description 实体作为筛选条件查询数据
     */
    List<Kind> queryAll(Kind kind);

    /**
     * @param kind 实例对象
     * @return 是否成功
     * @Description 修改数据，哪个属性不为空就修改哪个属性
     */
    boolean update(Kind kind);

    /**
     * @return java.util.List<com.moti.entity.Kind>
     * @Description 根据文章ID查询所有分类
     * @Param [id]
     **/
    Kind queryByArticleId(Integer id);

    /**
     * @return java.lang.Integer
     * @Description 根据文集ID获取关联文章的数量
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