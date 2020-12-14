package com.mian.entity;

import java.io.Serializable;

/**
 * @Description: Link实体类
 * @Author Anmiho
 * @Date 2020/12/14 23:11
 */
public class Link implements Serializable {

    private static final long serialVersionUID = 564121663147423979L;

    /**
     * 主键ID
     */
    private Integer id;

    /**
     * 名称
     */
    private String name;

    /**
     * 链接地址
     */
    private String url;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Link{" +
                "id=" + id +
                "name=" + name +
                "url=" + url +
                '}';
    }
}
