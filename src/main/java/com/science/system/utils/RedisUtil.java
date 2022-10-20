package com.science.system.utils;

/**
 * @Description: Redis 工具类
 * @Author: Cauchy
 * @CreateTime: 2022/10/9
 */

import lombok.AllArgsConstructor;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class RedisUtil {

    private final StringRedisTemplate template;

    /**
     * 检查是否存在某个 key
     *
     * @param key 键
     * @return Boolean
     */
    public Boolean hasKey(String key) {
        return this.template.hasKey(key);
    }

    /**
     * 添加键值对
     *
     * @param key   键
     * @param value 值
     */
    public void set(String key, String value) {
        this.template.opsForValue().set(key, value);
    }

    /**
     * 查询键值对
     *
     * @param key 键
     */
    public String get(String key) {
        return this.template.opsForValue().get(key);
    }

    /**
     * list 设置值
     *
     * @param key   键
     * @param index 索引
     * @param value 值
     */
    public void lset(String key, long index, String value) {
        this.template.opsForList().set(key, index, value);
    }

    /**
     * 依据索引获取值
     *
     * @param key   键
     * @param index 索引
     * @return 值
     */
    public String lindex(String key, long index) {
        return this.template.opsForList().index(key, index);
    }

    /**
     * set 添加
     *
     * @param key    键
     * @param values 值
     */
    public void sadd(String key, String... values) {
        this.template.opsForSet().add(key, values);
    }

}


