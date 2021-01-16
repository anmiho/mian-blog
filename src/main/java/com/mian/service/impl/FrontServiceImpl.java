package com.mian.service.impl;

import com.mian.entity.Front;
import com.mian.redis.AdminKey;
import com.mian.service.FrontService;
import org.springframework.stereotype.Service;

/**
 * @Description: Front服务实现类
 * @Author mian
 * @Date 2021/1/16 19:34
 */
@Service
public class FrontServiceImpl extends BaseService implements FrontService {

    /**
     * @param id 主键
     * @return 实例对象
     * @Description 查询单条数据
     */
    @Override
    public Front queryById(Integer id) {
        Front front = null;
        if (redisService.exists(AdminKey.getByFront,String.valueOf(id))) {
            front = redisService.get(AdminKey.getByFront, String.valueOf(id), Front.class);
        }else {
            front = frontMapper.queryById(id);
            redisService.set(AdminKey.getByFront, String.valueOf(id),front,60*60*24);
        }
        return front;
    }

    /**
     * @param front 实例对象
     * @return 是否成功
     * @Description 修改数据，哪个属性不为空就修改哪个属性
     */
    @Override
    public boolean update(Front front) {
        if (frontMapper.update(front) == 1) {
            return true;
        }
        return false;
    }

}
