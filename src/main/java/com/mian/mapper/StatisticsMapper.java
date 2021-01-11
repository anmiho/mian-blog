package com.mian.mapper;

import com.mian.entity.Statistics;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * @Description: Statistics数据访问层
 * @Author mian
 * @Date 2021/1/7 22:55
 */
@Mapper
public interface StatisticsMapper {
    /**
     * @Description 添加Statistics
     * @param statistics 实例对象
     * @return 影响行数
     */
    int insert(Statistics statistics);

    /**
     * @Description 删除Statistics
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    /**
     * @Description 查询单条数据
     * @param id 主键
     * @return 实例对象
     */
    Statistics queryById(Integer id);

    /**
     * @Description 查询全部数据
     * 分页使用MyBatis的插件实现
     * @return 对象列表
     */
    List<Statistics> queryAll();

    /**
     * @Description 实体作为筛选条件查询数据
     * @param statistics 实例对象
     * @return 对象列表
     */
    List<Statistics> queryAll(Statistics statistics);

    /**
     * @Description 修改Statistics,根据 statistics 的主键修改数据
     * @param statistics
     * @return 影响行数
     */
    int update(Statistics statistics);

    /**
     * @Description 根据IP地址获取今日访问数据
     * @Param [ip]
     * @return com.moti.entity.Statistics
     **/
    Statistics findByIp(@Param("ip") String ip, @Param("aId")Integer aId);

    /**
     * @Description 添加IP今日的访问数次数
     * @Param [ip]
     * @return void
     **/
    void addRequestCount(@Param("ip") String ip,@Param("aId")Integer aId);

    /**
     * @Description 获取从昨天开始近10天的日期
     * @Param []
     * @return java.util.List<java.util.Date>
     **/
    List<Date> getRecentDates();

    /**
     * @Description 获取从昨天开始近10天每天的访问量
     * @Param []
     * @return java.util.List<java.lang.Integer>
     **/
    List<Integer> getRecentRequests();

    /**
     * @Description 获取从昨天开始近10天每天的访客数
     * @Param []
     * @return java.util.List<java.lang.Integer>
     **/
    List<Integer> getRecentVisitors();

    /**
     * @Description 获取不同时间段的访问数量
     * @Param [type]
     * @return Integer
     **/
    Integer getRequestCount(Integer type);

    /**
     * @Description 获取不同时间段的访客数量
     * @Param [type]
     * @return Integer
     **/
    Integer getVisitorCount(Integer type);
}
