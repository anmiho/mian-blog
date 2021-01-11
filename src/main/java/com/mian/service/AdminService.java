package com.mian.service;

import com.mian.entity.Admin;

/**
 * @Description: Admin服务接口
 * @Author mian
 * @Date 2021/1/3 16:12
 */
public interface AdminService {
    /**
     * @Description 查询单条数据
     * @param id 主键
     * @return 实例对象
     */
    Admin queryById(Integer id);


    /**
     * @Description 修改数据，哪个属性不为空就修改哪个属性
     * @param admin 实例对象
     * @return 是否成功
     */
    boolean update(Admin admin);

}
