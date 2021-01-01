package com.mian.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description: 返回结果
 * @Author mian
 * @Date 2020/12/31 15:53
 */
@Data
@NoArgsConstructor
public class ResponseResult {
    private int code;
    private String message;
    private Object data;
    private String url;
    private int success;

    public ResponseResult(int code) {
        this.code = code;
    }

    public ResponseResult(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public ResponseResult(int code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public ResponseResult(int code, String message, String url) {
        this.code = code;
        this.message = message;
        this.url = url;
    }
}
