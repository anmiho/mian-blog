package com.mian.mapper;

import com.mian.entity.Tag;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Description: Tag数据库访问层
 * @Author mian
 * @Date 2020/12/31 18:44
 */
@Mapper
public interface TagMapper {
    /**
     * @Description 添加Tag
     * @param tag 实例对象
     * @return 影响行数
     */
    int insert(Tag tag);

    /**
     * @Description 删除Tag
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    /**
     * @Description 查询单条数据
     * @param id 主键
     * @return 实例对象
     */
    Tag queryById(Integer id);

    /**
     * @Description 查询全部数据
     * 分页使用MyBatis的插件实现
     * @return 对象列表
     */
    List<Tag> queryAll();

    /**
     * @Description 实体作为筛选条件查询数据
     * @param tag 实例对象
     * @return 对象列表
     */
    List<Tag> queryAll(Tag tag);

    /**
     * @Description 修改Tag,根据 tag 的主键修改数据
     * @param tag
     * @return 影响行数
     */
    int update(Tag tag);

    /**
     * @Description 获取评论的数量
     * @Param []
     * @return java.lang.Integer
     **/
    Integer getCount();
}
