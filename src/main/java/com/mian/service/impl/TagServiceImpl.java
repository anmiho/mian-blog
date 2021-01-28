package com.mian.service.impl;

import com.mian.entity.Tag;
import com.mian.redis.TagKey;
import com.mian.service.TagService;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;

/**
 * @Description: Tag服务实现类
 * @Author mian
 * @Date 2021/1/16 20:02
 */
@Service
public class TagServiceImpl extends BaseService implements TagService {

    /**
     * @param tag 实例对象
     * @return 是否成功
     * @Description 添加Tag
     */
    @Override
    public boolean insert(Tag tag) {
        if (tagMapper.insert(tag) == 1) {
            return true;
        }
        return false;
    }

    /**
     * @param id 主键
     * @return 是否成功
     * @Description 删除Tag
     */
    @Override
    public boolean deleteById(Integer id) {
        if (tagMapper.deleteById(id) == 1) {
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
    public Tag queryById(Integer id) {
//        Tag tag = null;
//        if (redisService.exists(TagKey.getById,String.valueOf(id))){
//            tag = redisService.get(TagKey.getById, String.valueOf(id), Tag.class);
//        }else {
//            tag = tagMapper.queryById(id);
//            if (!ObjectUtils.isEmpty(tag)){
//                redisService.set(TagKey.getById,String.valueOf(id),tag,60*60*24);
//            }
//        }
//        return tag;
        return null;
    }

    /**
     * @return 对象列表
     * @Description 查询全部数据
     * 分页使用MyBatis的插件实现
     */
    @Override
    public List<Tag> queryAll() {
        List<Tag> tags = null;
        // 获取所有标签
        if (redisService.exists(TagKey.getIndex, "")) {
            tags = redisService.getList(TagKey.getIndex, "", Tag.class);
        } else {
            // 获取并存入缓存
            tags = tagMapper.queryAll();
            tags.forEach(tag -> {
                tag.setArticleCount(articleTagMapper.getArticleCount(tag.getId()));
            });
            if (!ObjectUtils.isEmpty(tags)) {
                redisService.setList(TagKey.getIndex, "", tags);
            }
        }
        return tags;
    }

    /**
     * @param tag 实例对象
     * @return 对象列表
     * @Description 实体作为筛选条件查询数据
     */
    @Override
    public List<Tag> queryAll(Tag tag) {
        return tagMapper.queryAll(tag);
    }

    /**
     * @param tag 实例对象
     * @return 是否成功
     * @Description 修改数据，哪个属性不为空就修改哪个属性
     */
    @Override
    public boolean update(Tag tag) {
        if (tagMapper.update(tag) == 1) {
            return true;
        }
        return false;
    }

    /**
     * @return java.util.List<com.mian.entity.Tag>
     * @Description 根据文章ID查询所有标签
     * @Param [id]
     **/
    @Override
    public List<Tag> queryByArticleId(Integer id) {
        return articleTagMapper.queryByArticleId(id);
    }

    /**
     * @return java.lang.Integer
     * @Description 根据标签ID获取关联文章的数量
     * @Param [id]
     **/
    @Override
    public Integer getArticleCount(Integer id) {
        return articleTagMapper.getArticleCount(id);
    }

    /**
     * @return java.lang.Integer
     * @Description 获取评论的数量
     * @Param []
     **/
    @Override
    public Integer getCount() {
        return tagMapper.getCount();
    }

}
