package com.mian.mapper;

import com.mian.entity.Front;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Description: Front数据访问层
 * @Author mian
 * @Date 2021/1/7 22:47
 */
@Mapper
public interface FrontMapper {
    /**
     * @Description 查询单条数据
     * @param id 主键
     * @return 实例对象
     */
    Front queryById(Integer id);

    /**
     * @Description 修改Front,根据 front 的主键修改数据
     * @param front
     * @return 影响行数
     */
    int update(Front front);
}
