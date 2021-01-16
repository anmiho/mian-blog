package com.mian.service.impl;

import com.mian.entity.Menu;
import com.mian.service.MenuService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description: Menu服务实现类
 * @Author mian
 * @Date 2021/1/16 19:45
 */
@Service
public class MenuServiceImpl extends BaseService implements MenuService {

    /**
     * @param menu 实例对象
     * @return 是否成功
     * @Description 添加Menu
     */
    @Override
    public boolean insert(Menu menu) {
        if (menuMapper.insert(menu) == 1) {
            return true;
        }
        return false;
    }

    /**
     * @param id 主键
     * @return 是否成功
     * @Description 删除Menu
     */
    @Override
    public boolean deleteById(Integer id) {
        if (menuMapper.deleteById(id) == 1) {
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
    public Menu queryById(Integer id) {
        return menuMapper.queryById(id);
    }

    /**
     * @return 对象列表
     * @Description 查询全部数据
     * 分页使用MyBatis的插件实现
     */
    @Override
    public List<Menu> queryAll() {
        return menuMapper.queryAll();
    }

    /**
     * @param menu 实例对象
     * @return 对象列表
     * @Description 实体作为筛选条件查询数据
     */
    @Override
    public List<Menu> queryAll(Menu menu) {
        return menuMapper.queryAll(menu);
    }

    /**
     * @Description 获取左侧菜单
     * @Param []
     * @return java.util.List<com.mian.entity.Menu>
     **/
    @Override
    public List<Menu> getLeftMenus() {
//        // 获取缓存中左侧菜单
//        List<Menu> leftMenus = null;
//        if (redisService.exists(MenuKey.getLeftMenu,"")) {
//            leftMenus = redisService.getList(MenuKey.getLeftMenu, "", Menu.class);
//        }else {
//            leftMenus = menuMapper.queryAll(new Menu(0));
//            // 获取并存入缓存
//            redisService.setList(MenuKey.getLeftMenu,"",leftMenus);
//        }
//        return leftMenus;
        return null;
    }

    /**
     * @Description 获取右侧菜单
     * @Param []
     * @return java.util.List<com.mian.entity.Menu>
     **/
    @Override
    public List<Menu> getRightMenus() {
//        // 获取缓存中右侧菜单
//        List<Menu> rightMenus = null;
//        if (redisService.exists(MenuKey.getRightMenu,"")) {
//            rightMenus = redisService.getList(MenuKey.getRightMenu, "", Menu.class);
//        }else {
//            rightMenus = menuMapper.queryAll(new Menu(1));
//            // 获取并存入缓存
//            redisService.setList(MenuKey.getRightMenu,"",rightMenus);
//        }
//        return rightMenus;
        return null;
    }

    /**
     * @param menu 实例对象
     * @return 是否成功
     * @Description 修改数据，哪个属性不为空就修改哪个属性
     */
    @Override
    public boolean update(Menu menu) {
        if (menuMapper.update(menu) == 1) {
            return true;
        }
        return false;
    }
}
