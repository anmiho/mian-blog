package com.mian.service;

import com.mian.entity.Menu;

import java.util.List;

/**
 * @Description: Menu服务接口
 * @Author mian
 * @Date 2021/1/11 21:53
 */
public interface MenuService {

    /**
     * @param menu 实例对象
     * @return 是否成功
     * @Description 添加Menu
     */
    boolean insert(Menu menu);

    /**
     * @param id 主键
     * @return 是否成功
     * @Description 删除Menu
     */
    boolean deleteById(Integer id);

    /**
     * @param id 主键
     * @return 实例对象
     * @Description 查询单条数据
     */
    Menu queryById(Integer id);

    /**
     * @return 对象列表
     * @Description 查询全部数据
     * <p>
     * 分页使用MyBatis的插件实现
     */
    List<Menu> queryAll();

    /**
     * @param menu 实例对象
     * @return 对象列表
     * @Description 实体作为筛选条件查询数据
     */
    List<Menu> queryAll(Menu menu);

    /**
     * @return java.util.List<com.mian.entity.Menu>
     * @Description 获取左侧菜单
     * @Param []
     **/
    List<Menu> getLeftMenus();

    /**
     * @return java.util.List<com.mian.entity.Menu>
     * @Description 获取右侧菜单
     * @Param []
     **/
    List<Menu> getRightMenus();

    /**
     * @param menu 实例对象
     * @return 是否成功
     * @Description 修改数据，哪个属性不为空就修改哪个属性
     */
    boolean update(Menu menu);

}