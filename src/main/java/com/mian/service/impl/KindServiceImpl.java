package com.mian.service.impl;

import com.mian.entity.Kind;
import com.mian.service.KindService;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;

/**
 * @Description: Kind服务实现类
 * @Author mian
 * @Date 2021/1/16 19:38
 */
@Service
public class KindServiceImpl extends BaseService implements KindService {

    /**
     * @param kind 实例对象
     * @return 是否成功
     * @Description 添加Kind
     */
    @Override
    public boolean insert(Kind kind) {
        if (kindMapper.insert(kind) == 1) {
            return true;
        }
        return false;
    }

    /**
     * @param id 主键
     * @return 是否成功
     * @Description 删除Kind
     */
    @Override
    public boolean deleteById(Integer id) {
        if (kindMapper.deleteById(id) == 1) {
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
    public Kind queryById(Integer id) {
//        Kind kind = null;
//        if (redisService.exists(KindKey.getById, String.valueOf(id))) {
//            kind = redisService.get(KindKey.getById, String.valueOf(id), Kind.class);
//        } else {
//            kind = kindMapper.queryById(id);
//            if (!ObjectUtils.isEmpty(kind)) {
//                redisService.set(KindKey.getById, String.valueOf(id), kind, 60 * 60 * 24);
//            }
//        }
//        return kind;
        return null;
    }

    /**
     * @return 对象列表
     * @Description 查询全部数据
     * 分页使用MyBatis的插件实现
     */
    @Override
    public List<Kind> queryAll() {
//        // 获取缓存中的文集
//        List<Kind> kinds = null;
//        if (redisService.exists(KindKey.getIndex, "")) {
//            kinds = redisService.getList(KindKey.getIndex, "", Kind.class);
//        } else {
//            // 获取并存入缓存
//            kinds = kindMapper.queryAll();
//            kinds.forEach(kind -> {
//                kind.setArticleCount(articleKindMapper.getArticleCount(kind.getId()));
//            });
//            redisService.setList(KindKey.getIndex, "", kinds);
//        }
//        return kinds;
        return null;
    }

    /**
     * @param kind 实例对象
     * @return 对象列表
     * @Description 实体作为筛选条件查询数据
     */
    @Override
    public List<Kind> queryAll(Kind kind) {
        return kindMapper.queryAll(kind);
    }

    /**
     * @param kind 实例对象
     * @return 是否成功
     * @Description 修改数据，哪个属性不为空就修改哪个属性
     */
    @Override
    public boolean update(Kind kind) {
        if (kindMapper.update(kind) == 1) {
            return true;
        }
        return false;
    }

    /**
     * @return java.util.List<com.mian.entity.Kind>
     * @Description 根据文章ID查询所有分类
     * @Param [id]
     **/
    @Override
    public Kind queryByArticleId(Integer id) {
        return articleKindMapper.queryByArticleId(id);
    }

    /**
     * @return java.lang.Integer
     * @Description 根据文集ID获取关联文章的数量
     * @Param [id]
     **/
    @Override
    public Integer getArticleCount(Integer id) {
        return articleKindMapper.getArticleCount(id);
    }

    /**
     * @return java.lang.Integer
     * @Description 获取评论的数量
     * @Param []
     **/
    @Override
    public Integer getCount() {
        return kindMapper.getCount();
    }

}
