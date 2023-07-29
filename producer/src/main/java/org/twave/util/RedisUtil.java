package org.twave.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.*;

import static org.twave.constants.Names.REDIS_SCHEDULE_KEY;

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

    /**
     * 从Redis中获取所有的任务
     *
     * @return
     */
    public List<Map<String, String>> getAllSchedule() {
        // 用scheduleList保存所有的任务，每个任务是一个Map
        List<Map<String, String>> scheduleList = new ArrayList<>();
        // 先获取所有的key
        Set<String> keys = redisTemplate.keys(REDIS_SCHEDULE_KEY);
        if (keys == null) {
            return null;
        }
        // 通过key获取每一个任务，将其转换为Map，再添加到scheduleList中
        for (String key : keys) {
            // 获取每一个任务
            Map<Object, Object> entries = redisTemplate.opsForHash().entries(key);
            // 用Map<String, String>保存每一个任务
            Map<String, String> result = new HashMap<>();
            // Map<Object, Object>转Map<String, String>
            for (Map.Entry<Object, Object> entry : entries.entrySet()) {
                result.put(String.valueOf(entry.getKey()), String.valueOf(entry.getValue()));
            }
            // 加入list
            scheduleList.add(result);
        }
        // 返回list
        return scheduleList;
    }
}
