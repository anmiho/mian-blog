package com.mian.mapper;

import com.mian.entity.Admin;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Description: Admin数据库访问层
 * @Author mian
 * @Date 2021/1/3 16:42
 */
@Mapper
public interface AdminMapper {

    /**
     * @Description 查询单条数据
     * @param id 主键
     * @return 实例对象
     */
    Admin queryById(Integer id);

    /**
     * @Description 修改Admin,根据id修改数据
     * @param admin
     * @return 影响行数
     */
    int update(Admin admin);
}
