package com.mian.service;

import com.mian.entity.Front;

/**
 * @Description: Front服务接口
 * @Author mian
 * @Date 2021/1/11 21:51
 */
public interface FrontService {

    /**
     * @param id 主键
     * @return 实例对象
     * @Description 查询单条数据
     */
    Front queryById(Integer id);

    /**
     * @param front 实例对象
     * @return 是否成功
     * @Description 修改数据，哪个属性不为空就修改哪个属性
     */
    boolean update(Front front);

}