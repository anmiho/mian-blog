package com.mian.service.impl;

import com.mian.entity.Statistics;
import com.mian.service.StatisticsService;
import com.mian.utils.IPUtils;
import com.mian.vo.StatisticsCount;
import com.mian.vo.VisitStatistics;
import com.mian.vo.VisitorStatistics;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Description: Statistics服务实现类
 * @Author mian
 * @Date 2021/1/16 19:47
 */
@Service
public class StatisticsServiceImpl extends BaseService implements StatisticsService {


    /**
     * @param statistics 实例对象
     * @return 是否成功
     * @Description 添加Statistics
     */
    @Override
    public boolean insert(Statistics statistics) {
        if (statisticsMapper.insert(statistics) == 1) {
            return true;
        }
        return false;
    }

    /**
     * @param id 主键
     * @return 是否成功
     * @Description 删除Statistics
     */
    @Override
    public boolean deleteById(Integer id) {
        if (statisticsMapper.deleteById(id) == 1) {
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
    public Statistics queryById(Integer id) {
        return statisticsMapper.queryById(id);
    }

    /**
     * @return 对象列表
     * @Description 查询全部数据
     * 分页使用MyBatis的插件实现
     */
    @Override
    public List<Statistics> queryAll() {
        return statisticsMapper.queryAll();
    }

    /**
     * @param statistics 实例对象
     * @return 对象列表
     * @Description 实体作为筛选条件查询数据
     */
    @Override
    public List<Statistics> queryAll(Statistics statistics) {
        return statisticsMapper.queryAll(statistics);
    }

    /**
     * @Description 更新访问数据，如果不存在就插入，如果存在就增加请求数
     */
    @Override
    public void update(HttpServletRequest request, Integer aId) {
//        // 获取请求的IP地址
//        String ip = IPUtils.getIpAddress(request);
//        redisService.incr(StatisticsKey.todayVisitor, ip + ":" + aId);
    }

    /**
     * @return com.moti.entity.RequestStatic
     * @Description 根据IP获取访问数据
     * @Param [ip]
     **/
    @Override
    public Statistics findByIp(String ip, Integer aId) {
        return statisticsMapper.findByIp(ip, aId);
    }

    /**
     * @return void
     * @Description 增加访问次数
     * @Param [ip]
     **/
    @Override
    public void addRequestCount(String ip, Integer aId) {
        statisticsMapper.addRequestCount(ip, aId);
    }

    /**
     * @return java.util.List<java.util.Date>
     * @Description 获取从昨天开始近10天的日期
     * @Param []
     **/
    @Override
    public List<Date> getRecentDates() {
        return statisticsMapper.getRecentDates();
    }

    /**
     * @return java.util.List<java.lang.Integer>
     * @Description 获取从昨天开始近10天每天的访问量
     * @Param []
     **/
    @Override
    public List<Integer> getRecentRequests() {
        return statisticsMapper.getRecentRequests();
    }

    /**
     * @return java.util.List<java.lang.Integer>
     * @Description 获取从昨天开始近10天每天的访客数
     * @Param []
     **/
    @Override
    public List<Integer> getRecentVisitors() {
        return statisticsMapper.getRecentVisitors();
    }

    /**
     * @return com.mian.vo.VisitStatistics
     * @Description 获取访问数据
     * @Param []
     **/
    @Override
    public VisitStatistics getVisitStatistics() {
        VisitStatistics statistics = new VisitStatistics();
        // 设置日期
        List<Date> recentDates = getRecentDates();
        Collections.reverse(recentDates);
        String[] dates = new String[10];
        for (int i = 0; i < recentDates.size(); i++) {
            SimpleDateFormat dateFm = new SimpleDateFormat("MM-dd");
            dates[i] = dateFm.format(recentDates.get(i));
        }
        statistics.setDates(dates);
        // 设置访问量
        List<Integer> recentRequests = getRecentRequests();
        Collections.reverse(recentRequests);
        Integer[] requests = new Integer[10];
        for (int i = 0; i < recentRequests.size(); i++) {
            requests[i] = recentRequests.get(i);
        }
        statistics.setRequests(requests);
        // 设置访客量
        List<Integer> recentVisitors = getRecentVisitors();
        Collections.reverse(recentVisitors);
        Integer[] visitors = new Integer[10];
        for (int i = 0; i < recentVisitors.size(); i++) {
            visitors[i] = recentVisitors.get(i);
        }
        statistics.setVisitors(visitors);
        return statistics;
    }

    /**
     * @return java.util.List<com.mian.vo.VisitorStatistics>
     * @Description 获取所有访客数据
     * @Param []
     **/
    @Override
    public List<VisitorStatistics> getVisitorStatistics() {
        // 获取所有的访问信息
        List<Statistics> statistics = statisticsMapper.queryAll();
        List<VisitorStatistics> visitorStatistics = new ArrayList<>();
        statistics.forEach(temp -> {
            if (temp.getArticleId() == -1) {
                visitorStatistics.add(new VisitorStatistics("主页", temp));
            } else {
                String title = articleMapper.getTitle(temp.getArticleId());
                if (!ObjectUtils.isEmpty(title)) {
                    visitorStatistics.add(new VisitorStatistics(title, temp));
                } else {
                    visitorStatistics.add(new VisitorStatistics("其他", temp));
                }
            }
        });
        return visitorStatistics;
    }

    /**
     * @return java.util.Map<java.lang.String, com.mian.vo.StatisticsCount>
     * @Description 获取统计数量信息
     * @Param []
     **/
    @Override
    public Map<String, StatisticsCount> getStatisticsCount() {
        Map<String, StatisticsCount> map = new HashMap<>();
        map.put("yesterday", new StatisticsCount(statisticsMapper.getRequestCount(1), statisticsMapper.getVisitorCount(1)));
        map.put("week", new StatisticsCount(statisticsMapper.getRequestCount(7), statisticsMapper.getVisitorCount(7)));
        map.put("month", new StatisticsCount(statisticsMapper.getRequestCount(30), statisticsMapper.getVisitorCount(30)));
        map.put("year", new StatisticsCount(statisticsMapper.getRequestCount(365), statisticsMapper.getVisitorCount(365)));
        map.put("total", new StatisticsCount(statisticsMapper.getRequestCount(-1), statisticsMapper.getVisitorCount(-1)));
        return map;
    }
}