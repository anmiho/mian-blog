package com.mian.vo;

import com.mian.entity.Statistics;

/**
 * @Description:
 * @Author mian
 * @Date 2021/1/11 21:50
 */
public class VisitorStatistics {
    String target;
    Statistics statistics;

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public Statistics getStatistics() {
        return statistics;
    }

    public void setStatistics(Statistics statistics) {
        this.statistics = statistics;
    }

    public VisitorStatistics() {
    }

    public VisitorStatistics(String target, Statistics statistics) {
        this.target = target;
        this.statistics = statistics;
    }

    @Override
    public String toString() {
        return "VisitorStatistics{" +
                "target='" + target + '\'' +
                ", statistics=" + statistics +
                '}';
    }
}

