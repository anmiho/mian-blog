package com.mian.vo;

/**
 * @Description:
 * @Author mian
 * @Date 2021/1/11 21:50
 */
public class StatisticsCount {
    Integer requests;
    Integer visitor;

    public StatisticsCount() {
    }

    public Integer getRequests() {
        return requests;
    }

    public void setRequests(Integer requests) {
        this.requests = requests;
    }

    public Integer getVisitor() {
        return visitor;
    }

    public void setVisitor(Integer visitor) {
        this.visitor = visitor;
    }

    @Override
    public String toString() {
        return "StatisticsCount{" +
                "requests=" + requests +
                ", visitor=" + visitor +
                '}';
    }

    public StatisticsCount(Integer requests, Integer visitor) {
        this.requests = requests;
        this.visitor = visitor;
    }
}

