package com.mian.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Description: 日志工具类
 * @Author mian
 * @Date 2020/12/31 15:45
 */
public class LogUtils {
    private static Logger logger;
    private LogUtils(){}
    public static Logger getInstance(Class c){
        return logger = LoggerFactory.getLogger(c);
    }
}
