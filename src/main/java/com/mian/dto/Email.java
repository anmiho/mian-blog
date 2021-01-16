package com.mian.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @Description: 邮件工具类
 * @Author mian
 * @Date 2021/1/16 20:31
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Email {
    private String to;
    private String content;
    private String title;
    private String url;
}
