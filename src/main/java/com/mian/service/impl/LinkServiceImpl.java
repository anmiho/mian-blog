package com.mian.service.impl;

import com.mian.entity.Link;
import com.mian.service.LinkService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description: Link服务实现类
 * @Author mian
 * @Date 2021/1/16 19:42
 */
@Service
public class LinkServiceImpl extends BaseService implements LinkService {

    /**
     * @param link 实例对象
     * @return 是否成功
     * @Description 添加Link
     */
    @Override
    public boolean insert(Link link) {
        if (linkMapper.insert(link) == 1) {
            return true;
        }
        return false;
    }

    /**
     * @param id 主键
     * @return 是否成功
     * @Description 删除Link
     */
    @Override
    public boolean deleteById(Integer id) {
        if (linkMapper.deleteById(id) == 1) {
            return true;
        }
        return false;
    }

    /**
     * @param id 主键
     * @return 实例对象
     * @Description 查询单条数据
     */
    @Override
    public Link queryById(Integer id) {
        return linkMapper.queryById(id);
    }

    /**
     * @return 对象列表
     * @Description 查询全部数据
     * 分页使用MyBatis的插件实现
     */
    @Override
    public List<Link> queryAll() {
//        // 获取缓存中的友情链接
//        List<Link> links = null;
//        if (redisService.exists(LinkKey.getIndex, "")) {
//            links = redisService.getList(LinkKey.getIndex, "", Link.class);
//        } else {
//            // 获取并存入缓存
//            links = linkMapper.queryAll();
//            redisService.setList(LinkKey.getIndex, "", links);
//        }
//        return links;
        return null;
    }

    /**
     * @param link 实例对象
     * @return 对象列表
     * @Description 实体作为筛选条件查询数据
     */
    @Override
    public List<Link> queryAll(Link link) {
        return linkMapper.queryAll(link);
    }

    /**
     * @param link 实例对象
     * @return 是否成功
     * @Description 修改数据，哪个属性不为空就修改哪个属性
     */
    @Override
    public boolean update(Link link) {
        if (linkMapper.update(link) == 1) {
            return true;
        }
        return false;
    }
}
