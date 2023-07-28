package org.twave.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 操作Redis的各种方法
 *
 * @author : twave
 * @date : 2023/7/28 16:11
 */
@Component
public class RedisUtil {
    // 注入StringRedisTemplate
    @Autowired
    StringRedisTemplate redisTemplate;

    List<Map<String, String>> getAllSchedule() {
        return null;
    }
}
