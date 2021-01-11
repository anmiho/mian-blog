package com.mian.service;

import com.mian.entity.Link;

import java.util.List;

/**
 * @Description: Link服务接口
 * @Author mian
 * @Date 2021/1/11 21:53
 */
public interface LinkService {

    /**
     * @param link 实例对象
     * @return 是否成功
     * @Description 添加Link
     */
    boolean insert(Link link);

    /**
     * @param id 主键
     * @return 是否成功
     * @Description 删除Link
     */
    boolean deleteById(Integer id);

    /**
     * @param id 主键
     * @return 实例对象
     * @Description 查询单条数据
     */
    Link queryById(Integer id);

    /**
     * @return 对象列表
     * @Description 查询全部数据
     * <p>
     * 分页使用MyBatis的插件实现
     */
    List<Link> queryAll();

    /**
     * @param link 实例对象
     * @return 对象列表
     * @Description 实体作为筛选条件查询数据
     */
    List<Link> queryAll(Link link);

    /**
     * @param link 实例对象
     * @return 是否成功
     * @Description 修改数据，哪个属性不为空就修改哪个属性
     */
    boolean update(Link link);

}