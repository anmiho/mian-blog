package com.mian.redis;

import com.mian.utils.BeanUtils;
import com.mian.utils.LogUtils;
import com.mian.utils.RedisUtils;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import redis.clients.jedis.Jedis;

import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * @Description: RedisService
 * @Author mian
 * @Date 2021/1/3 16:32
 */
@Service
public class RedisService {

    private Logger logger = LogUtils.getInstance(RedisService.class);

    /**
     * 判断key是否存在
     */
    public <T> boolean exists(KeyPrefix prefix, String key) {
        logger.warn("【Redis】是否存在，键：" + prefix.getPrefix() + key);
        //生成真正的key
        String realKey = ObjectUtils.isEmpty(key) ? prefix.getPrefix() : prefix.getPrefix() + ":" + key;
        logger.warn("【Redis】结果："+ RedisUtils.hasKey(realKey));
        return RedisUtils.hasKey(realKey);
    }

    /**
     * 获取某个对象
     */
    public <T> T get(KeyPrefix prefix, String key, Class<T> clazz) {
        logger.warn("【Redis】获取值，键：" + prefix.getPrefix()+":"+ key);
        //生成真正的key
        String realKey = ObjectUtils.isEmpty(key) ? prefix.getPrefix() : prefix.getPrefix() + ":" + key;
        String str = (String) RedisUtils.get(realKey);
        T t = BeanUtils.stringToBean(str, clazz);
        logger.warn("【Redis】结果："+t);
        return t;
    }

    /**
     * 设置对象
     */
    public <T> boolean set(KeyPrefix prefix, String key, T value, long exTime) {
        logger.warn("【Redis】设置对象，键：" + prefix.getPrefix() + key);

        String str = BeanUtils.beanToString(value);
        if (str == null || str.length() <= 0) {
            return false;
        }
        //生成真正的key
        String realKey = ObjectUtils.isEmpty(key) ? prefix.getPrefix() : prefix.getPrefix() + ":" + key;
        if (exTime == 0) {
            //直接保存
            RedisUtils.set(realKey, str);
        } else {
            //设置过期时间
            RedisUtils.set(realKey, str, exTime);
        }
        logger.warn("【Redis】结果：设置对象成功");
        return true;
    }

    /**
     //     * 删除对象
     //     */
    public Long del(KeyPrefix prefix, String key) {
        logger.warn("【Redis】删除对象，键：" + prefix.getPrefix() +":"+ key);
        String realKey = ObjectUtils.isEmpty(key) ? prefix.getPrefix() : prefix.getPrefix() + ":" + key;
        Long result = RedisUtils.del(realKey);
        logger.warn("【Redis】结果："+result + ",realKey："+realKey);
        return result;
    }

//    /**
//     * 获取整合集合
//     */
//    public <T> List<T> getList(KeyPrefix prefix, String key, Class<T> clazz) {
//        logger.warn("【Redis】获取整合集合，键：" + prefix.getPrefix() + key);
//        Jedis jedis = null;
//        try {
//            jedis = jedisPool.getResource();
//            //生成真正的key
//            String realKey = ObjectUtils.isEmpty(key) ? prefix.getPrefix() : prefix.getPrefix() + ":" + key;
//            List<String> names = jedis.lrange(realKey, 0, -1);
//            List<T> list = new ArrayList<T>();
//            names.forEach(name -> {
//                T t = BeanUtils.stringToBean(name, clazz);
//                list.add(t);
//            });
//            Collections.reverse(list);
//            logger.warn("【Redis】结果："+list);
//            return list;
//        } finally {
//            returnToPool(jedis);
//        }
//    }
//
//    /**
//     * 设置定时
//     */
//    public Long expice(KeyPrefix prefix, String key, int exTime) {
//        logger.warn("【Redis】设置定时，键：" + prefix.getPrefix() + key);
//        Jedis jedis = null;
//        Long result = null;
//        try {
//            jedis = jedisPool.getResource();
//            // 生成真正的Key
//            String realKey = ObjectUtils.isEmpty(key) ? prefix.getPrefix() : prefix.getPrefix() + ":" + key;
//            result = jedis.expire(realKey, exTime);
//            logger.warn("【Redis】结果："+result);
//            return result;
//        } finally {
//            returnToPool(jedis);
//        }
//    }
//
//    /**
//     * 设置整个集合
//     */
//    public <T> void setList(KeyPrefix prefix, String key, List<T> list) {
//        logger.warn("【Redis】设置集合，键：" + prefix.getPrefix()+ ":" + key);
//        Jedis jedis = null;
//        try {
//            jedis = jedisPool.getResource();
//            //生成真正的key
//            String realKey = ObjectUtils.isEmpty(key) ? prefix.getPrefix() : prefix.getPrefix() + ":" + key;
//            for (int i = 0; i < list.size(); i++) {
//                String string = BeanUtils.beanToString(list.get(i));
//                jedis.lpush(realKey, string);
//            }
//            logger.warn("【Redis】结果：设置集合成功,realKey:"+realKey);
//        } finally {
//            returnToPool(jedis);
//        }
//    }
//
//
//
//    /**
//     * 删除多个对象
//     */
//    public Long del(KeyPrefix prefix) {
//        logger.warn("【Redis】删除多个对象，键包含：" + prefix.getPrefix());
//        Jedis jedis = null;
//        Long result = 0L;
//        try {
//            jedis = jedisPool.getResource();
//            Set<String> keys = keys(prefix);
//            if (keys.size() == 0){
//                return result;
//            }
//            for (String key : keys) {
//                result += jedis.del(key);
//            }
//            logger.warn("【Redis】结果："+result);
//            return result;
//        } finally {
//            returnToPool(jedis);
//        }
//    }
//
//    /**
//     * 增加值
//     */
//    public <T> Long incr(KeyPrefix prefix, String key) {
//        logger.warn("【Redis】增加值，键：" + prefix.getPrefix() + key);
//        Jedis jedis = null;
//        try {
//            jedis = jedisPool.getResource();
//            //生成真正的key
//            String realKey = ObjectUtils.isEmpty(key) ? prefix.getPrefix() : prefix.getPrefix() + ":" + key;
//            return jedis.incr(realKey);
//        } finally {
//            returnToPool(jedis);
//        }
//    }
//
//    /**
//     * 减少值
//     */
//    public <T> Long decr(KeyPrefix prefix, String key) {
//        logger.warn("【Redis】减少值，键：" + prefix.getPrefix() + key);
//        Jedis jedis = null;
//        try {
//            jedis = jedisPool.getResource();
//            //生成真正的key
//            String realKey = ObjectUtils.isEmpty(key) ? prefix.getPrefix() : prefix.getPrefix() + ":" + key;
//            return jedis.decr(realKey);
//        } finally {
//            returnToPool(jedis);
//        }
//    }
//
//    /**
//     * 根据大键查询所有键
//     */
//    public Set<String> keys(KeyPrefix prefix) {
//        logger.warn("【Redis】查询所有子键，父键：" + prefix.getPrefix());
//        Jedis jedis = null;
//        try {
//            jedis = jedisPool.getResource();
//            Set<String> keys = jedis.keys(prefix.getPrefix() + "*");
//            logger.warn("【Redis】结果："+keys);
//            return keys;
//        } finally {
//            returnToPool(jedis);
//        }
//    }

//    /**
//     * 关闭当前连接对象，返回到连接池
//     */
//    private void returnToPool(Jedis jedis) {
//        if (jedis != null) {
//            jedis.close();
//        }
//    }
//
//    /**
//     * 清空数据库
//     */
//    public void flush(){
//        logger.warn("【Redis】清空数据库");
//        Jedis jedis = null;
//        try {
//            jedis = jedisPool.getResource();
//            jedis.flushDB();
//        } finally {
//            returnToPool(jedis);
//        }
//    }


}
