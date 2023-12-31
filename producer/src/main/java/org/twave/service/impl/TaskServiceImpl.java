package org.twave.service.impl;

import com.alibaba.fastjson2.JSON;
import org.twave.controller.exception.sqlException.InsertTaskException;
import org.twave.entity.Task;
import org.twave.service.TaskService;
import org.twave.mapper.TaskMapper;
import org.springframework.stereotype.Service;
import org.twave.util.MqSendMessage;

import javax.annotation.Resource;
import java.util.List;

import static org.twave.constants.Names.TASK_QUEUE_NAME;

/**
 * TaskService的实现类
 *
 * @author TWAVE
 * @description 针对表【task】的数据库操作Service实现
 * @createDate 2023-07-28 15:33:07
 */
@Service
public class TaskServiceImpl implements TaskService {
    // 注入Mapper
    @Resource
    private TaskMapper taskMapper;
    // 注入消息队列工具类
    @Resource
    private MqSendMessage sendMessage;

    @Override
    public void sendTaskToMq() {
        // 获取全部任务
        List<Task> taskList = taskMapper.getAllTask();
        for (Task task : taskList) {
            // 将每一个任务打包成JSON字符串，送入消息队列
            sendTask(task);
        }
    }

    private void sendTask(Task task) {
        String jsonString = JSON.toJSONString(task);
        sendMessage.sendMessageToQueue(TASK_QUEUE_NAME, jsonString);
    }

    /**
     * 添加任务到数据库和MQ
     *
     * @param task 任务实体类
     */
    @Override
    public void addTask(Task task) {
        int result = taskMapper.addTask(task);
        sendTask(task);
        if (result == 0) {
            throw new InsertTaskException("添加任务失败");
        }
    }
}




