package com.mian.redis;

/**
 * @Description: BasePrefix
 * @Author mian
 * @Date 2021/1/3 16:36
 */
public class BasePrefix implements KeyPrefix {

    private String prefix;

    public BasePrefix(String prefix) {
        this.prefix = prefix;
    }

    @Override
    public String getPrefix() {
        String className = getClass().getSimpleName();
        return className + ":" + prefix;
    }
}
