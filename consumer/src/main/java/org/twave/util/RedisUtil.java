package org.twave.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.HashMap;
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
    // 获取当前的服务名称
    @Value("${serviceName}")
    String serviceName;

    /**
     * 上传当前进度
     *
     * @param taskId 任务ID
     * @param now    当前打印了多少个字符
     * @param all    总共有多少个字符
     */
    public void sendSchedule(int taskId, int now, int all) {
        Map<String, String> map = new HashMap<>();
        map.put("taskId", String.valueOf(taskId));
        map.put("serviceName", serviceName);
        map.put("now", String.valueOf(all - now));
        map.put("all", String.valueOf(all));
        String key = "schedule:" + taskId;
        redisTemplate.opsForHash().putAll(key, map);
    }

    /**
     * 任务结束后删除对应的进度记录
     *
     * @param taskId 任务ID
     */
    public void deleteSchedule(int taskId) {
        String key = "schedule:" + taskId;
        redisTemplate.delete(key);
    }
}
