package com.mian.mapper;

import com.mian.entity.Link;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Description: Link数据访问层
 * @Author mian
 * @Date 2021/1/7 22:50
 */
@Mapper
public interface LinkMapper {
    /**
     * @Description 添加Link
     * @param link 实例对象
     * @return 影响行数
     */
    int insert(Link link);

    /**
     * @Description 删除Link
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    /**
     * @Description 查询单条数据
     * @param id 主键
     * @return 实例对象
     */
    Link queryById(Integer id);

    /**
     * @Description 查询全部数据，分页使用MyBatis的插件实现
     * @return 对象列表
     */
    List<Link> queryAll();

    /**
     * @Description 实体作为筛选条件查询数据
     * @param link 实例对象
     * @return 对象列表
     */
    List<Link> queryAll(Link link);

    /**
     * @Description 修改Link,根据 link 的主键修改数据
     * @param link
     * @return 影响行数
     */
    int update(Link link);
}
