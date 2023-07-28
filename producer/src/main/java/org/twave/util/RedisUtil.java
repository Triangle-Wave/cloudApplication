package org.twave.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.*;

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

    public List<Map<String, String>> getAllSchedule() {
        List<Map<String, String>> scheduleList = new ArrayList<>();
        Set<String> keys = redisTemplate.keys("schedule:*");
        if (keys == null) {
            return null;
        }
        for (String key : keys) {
            Map<Object, Object> entries = redisTemplate.opsForHash().entries(key);
            Map<String, String> result = new HashMap<>();
            for (Map.Entry<Object, Object> entry : entries.entrySet()) {
                result.put(String.valueOf(entry.getKey()), String.valueOf(entry.getValue()));
            }
            scheduleList.add(result);
        }
        return scheduleList;
    }
}
