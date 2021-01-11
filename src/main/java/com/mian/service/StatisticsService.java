package com.mian.service;

import com.mian.entity.Statistics;
import com.mian.vo.StatisticsCount;
import com.mian.vo.VisitStatistics;
import com.mian.vo.VisitorStatistics;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Description: Statistics服务接口
 * @Author mian
 * @Date 2021/1/11 21:55
 */
public interface StatisticsService {

    /**
     * @param statistics 实例对象
     * @return 是否成功
     * @Description 添加Statistics
     */
    boolean insert(Statistics statistics);

    /**
     * @param id 主键
     * @return 是否成功
     * @Description 删除Statistics
     */
    boolean deleteById(Integer id);

    /**
     * @param id 主键
     * @return 实例对象
     * @Description 查询单条数据
     */
    Statistics queryById(Integer id);

    /**
     * @return 对象列表
     * @Description 查询全部数据
     * <p>
     * 分页使用MyBatis的插件实现
     */
    List<Statistics> queryAll();

    /**
     * @param statistics 实例对象
     * @return 对象列表
     * @Description 实体作为筛选条件查询数据
     */
    List<Statistics> queryAll(Statistics statistics);

    /**
     * @Description 更新访问数据，如果不存在就插入，如果存在就增加请求数
     */
    void update(HttpServletRequest request, Integer aId);

    /**
     * @return com.moti.entity.Statistics
     * @Description 根据IP地址获取今日访问数据
     * @Param [ip]
     **/
    Statistics findByIp(String ip, Integer aId);

    /**
     * @return void
     * @Description 添加IP今日的访问数次数
     * @Param [ip]
     **/
    void addRequestCount(String ip, Integer aId);


    /**
     * @return java.util.List<java.util.Date>
     * @Description 获取从昨天开始近10天的日期
     * @Param []
     **/
    List<Date> getRecentDates();

    /**
     * @return java.util.List<java.lang.Integer>
     * @Description 获取从昨天开始近10天每天的访问量
     * @Param []
     **/
    List<Integer> getRecentRequests();

    /**
     * @return java.util.List<java.lang.Integer>
     * @Description 获取从昨天开始近10天每天的访客数
     * @Param []
     **/
    List<Integer> getRecentVisitors();

    /**
     * @return com.moti.vo.VisitStatistics
     * @Description 获取访问数据
     * @Param []
     **/
    VisitStatistics getVisitStatistics();

    /**
     * @return java.util.List<com.moti.vo.VisitorStatistics>
     * @Description 获取所有访客数据
     * @Param []
     **/
    List<VisitorStatistics> getVisitorStatistics();

    /**
     * @return java.util.Map<java.lang.String, com.moti.vo.StatisticsCount>
     * @Description 获取统计数量信息
     * @Param []
     **/
    Map<String, StatisticsCount> getStatisticsCount();

}