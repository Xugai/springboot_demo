package com.example.demo.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * Created by rabbit on 2019/3/3.
 */
@Component
public class RedisUtil {

    @Autowired
    private StringRedisTemplate strRedis;

    /**
     * 返回给定key的剩余生存时间，单位为秒
     * @param key
     * @return
     */
    public long ttl(String key){
        return strRedis.getExpire(key);
    }

    /**
     * 为指定的key设定过期时间，单位为秒
     * @param key
     * @param timeout
     */
    public void expire(String key, long timeout){
        strRedis.expire(key, timeout, TimeUnit.SECONDS);
    }

    /**
     * 为指定的key增加指定的delter值，delter若不填，则默认增加1
     * @param key
     * @param delter
     * @return
     */
    public long incr(String key, long delter){
        return strRedis.opsForValue().increment(key, delter);
    }

    /**
     * 查找所有符合给定形式的key
     * @param pattern
     * @return
     */
    public Set<String> keys(String pattern){
        return strRedis.keys(pattern);
    }

    /**
     * 删除指定的key
     * @param key
     */
    public void del(String key){
        strRedis.delete(key);
    }

    /**
     * 创建一个String类型的数据结构
     * @param key
     * @param value
     */
    public void set(String key, String value){
        strRedis.opsForValue().set(key, value);
    }

    /**
     * 创建一个key-value键值对的同时，设置过期时间，单位为秒
     * @param key
     * @param value
     * @param timeout
     */
    public void setExepire(String key, String value, long timeout){
        strRedis.opsForValue().set(key, value, timeout, TimeUnit.SECONDS);
    }

    /**
     * 返回指定key的value
     * @param key
     * @return
     */
    public String get(String key){
        return (String) strRedis.opsForValue().get(key);
    }

    /**
     * 创建一个hash类型的数据结构，并往里面设置一对key-value
     * @param key
     * @param field
     * @param value
     */
    public void hset(String key, String field, String value){
        strRedis.opsForHash().put(key, field, value);
    }

    /**
     * 返回指定hash中的指定域的值
     * @param key
     * @param field
     * @return
     */
    public String hget(String key, String field){
        return (String) strRedis.opsForHash().get(key, field);
    }

    /**
     * 删除指定hash中的多个域的值，若不存在指定的域，则会略过该域执行下一个域的删除操作
     * @param key
     * @param fields
     */
    public void hdel(String key, Object... fields){
        strRedis.opsForHash().delete(key, fields);
    }

    /**
     * 返回指定key的hash的所有key-value键值对
     * @param key
     * @return
     */
    public Map<Object, Object> hgetall(String key){
        return strRedis.opsForHash().entries(key);
    }

    /**
     * 往指定的list类型的数据结构中插入一个value，从表头插入
     * @param key
     * @param value
     * @return
     */
    public long lpush(String key, String value){
        return strRedis.opsForList().leftPush(key, value);
    }

    /**
     * 从一个list中的最左端获取一个value
     * @param key
     * @return
     */
    public String lpop(String key){
        return (String) strRedis.opsForList().leftPop(key);
    }

    /**
     * 插入一个元素到list的最右端，也即往表尾插入数据
     * @param key
     * @param value
     * @return
     */
    public long rpush(String key, String value){
        return strRedis.opsForList().rightPush(key, value);
    }




}
