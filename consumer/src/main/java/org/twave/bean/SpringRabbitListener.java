package org.twave.bean;

import com.alibaba.fastjson2.JSON;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.twave.entity.Task;
import org.twave.util.RedisUtil;


import static org.twave.constants.Names.TASK_QUEUE_NAME;

/**
 * @author : twave
 * @date : 2023/7/28 11:00
 */
@Component
public class SpringRabbitListener {
    @Autowired
    private RedisUtil redisUtil;

    // 监听TASK_QUEUE_NAME队列
    @RabbitListener(queues = TASK_QUEUE_NAME)
    public void listenQueue(String message) {
        // 获取任务，策略是每次获取一个任务，消费完后再继续获取
        // 解析JSON字符串为Task对象
        Task task = JSON.parseObject(message, Task.class);
        System.out.printf("\n收到编号为 %s 的任务，打印 %s 个 %s 符号，时间间隔 %s 毫秒\n",
                task.getTaskId(),
                task.getNum(),
                task.getPrintCharacters(),
                task.getIntervalTime());
        int num = task.getNum();
        while (num > 0) {
            try {
                System.out.printf(task.getPrintCharacters() + " ");
                Thread.sleep(task.getIntervalTime());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            num -= 1;
            // 调用sendSchedule方法将当前进度上传到Redis中
            redisUtil.sendSchedule(task.getTaskId(), num, task.getNum());
        }
        // 任务结束以后删除Redis中的记录
        redisUtil.deleteSchedule(task.getTaskId());
    }
}
