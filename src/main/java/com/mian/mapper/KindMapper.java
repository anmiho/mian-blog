package com.mian.mapper;

import com.mian.entity.Kind;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Description: Kind数据访问层
 * @Author mian
 * @Date 2021/1/7 22:48
 */
@Mapper
public interface KindMapper {
    /**
     * @Description 添加Kind
     * @param kind 实例对象
     * @return 影响行数
     */
    int insert(Kind kind);

    /**
     * @Description 删除Kind
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    /**
     * @Description 查询单条数据
     * @param id 主键
     * @return 实例对象
     */
    Kind queryById(Integer id);

    /**
     * @Description 查询全部数据
     * 分页使用MyBatis的插件实现
     * @return 对象列表
     */
    List<Kind> queryAll();

    /**
     * @Description 实体作为筛选条件查询数据
     * @param kind 实例对象
     * @return 对象列表
     */
    List<Kind> queryAll(Kind kind);

    /**
     * @Description 修改Kind,根据 kind 的主键修改数据
     * @param kind
     * @return 影响行数
     */
    int update(Kind kind);


    /**
     * @Description 获取评论的数量
     * @Param []
     * @return java.lang.Integer
     **/
    Integer getCount();
}
