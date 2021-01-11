package com.mian.service.impl;

import com.mian.entity.Admin;
import com.mian.redis.AdminKey;
import com.mian.service.AdminService;
import org.springframework.stereotype.Service;

/**
 * @Description: Admin服务实现类
 * @Author mian
 * @Date 2021/1/3 16:15
 */
@Service
public class AdminServiceImpl extends BaseService implements AdminService {

    /**
     * @param id 主键
     * @return 实例对象
     * @Description 查询单条数据
     */
    @Override
    public Admin queryById(Integer id) {
        Admin admin = null;
        if (redisService.exists(AdminKey.getById, String.valueOf(id))) {
            admin = redisService.get(AdminKey.getById, String.valueOf(id), Admin.class);
        } else {
            admin = adminMapper.queryById(id);
            redisService.set(AdminKey.getById, String.valueOf(id), admin, 60 * 60 * 24);
        }
        return admin;
    }

    /**
     * @param admin 实例对象
     * @return 是否成功
     * @Description 修改数据，哪个属性不为空就修改哪个属性
     */
    @Override
    public boolean update(Admin admin) {
        if (adminMapper.update(admin) == 1) {
            return true;
        }
        return false;
    }
}
