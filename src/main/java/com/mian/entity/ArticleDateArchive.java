package com.mian.entity;

import lombok.*;

import java.io.Serializable;

/**
 * @Description: ArticleDateArchive实体类
 * @Author Anmiho
 * @Date 2020/12/14 23:01
 */
@Builder
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class ArticleDateArchive implements Serializable {
    /**
     * 日期：只取年月
     */
    private String date;
    /**
     * 文章数量
     */
    private int count;
}
