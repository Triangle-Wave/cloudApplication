package org.twave.constants;

/**
 * 字符串常量
 *
 * @author : twave
 * @date : 2023/7/28 15:53
 */
public class Names {
    // 消息队列名称
    public static final String TASK_QUEUE_NAME = "task_queue";
    // Redis中的任务key，通过这个key获取全部任务
    public static final String REDIS_SCHEDULE_KEY = "schedule:*";
}
