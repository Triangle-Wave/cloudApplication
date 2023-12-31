package org.twave.service;


import org.twave.entity.Task;

/**
 * 任务Service
 *
 * @author TWAVE
 * @description 针对表【task】的数据库操作Service
 * @createDate 2023-07-28 15:33:07
 */
public interface TaskService {
    /**
     * 将任务发送到MQ
     */
    void sendTaskToMq();

    /**
     * 添加任务到数据库和MQ
     */
    void addTask(Task task);
}
