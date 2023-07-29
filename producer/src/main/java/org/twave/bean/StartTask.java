package org.twave.bean;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.twave.service.impl.TaskServiceImpl;

import javax.annotation.Resource;

/**
 * Springboot项目启动时，将数据库中的任务添加到消息队列中
 *
 * @author : twave
 * @date : 2023/7/28 17:38
 */
@Component
public class StartTask implements ApplicationRunner {
    // 注入TaskServiceImpl
    @Resource
    TaskServiceImpl taskService;

    /**
     * 项目启动时，将数据库中的任务添加到消息队列中
     *
     * @param args
     */
    @Override
    public void run(ApplicationArguments args) {
        // 调用TaskServiceImpl的sendTaskToMq方法将所有任务添加到消息队列中
        taskService.sendTaskToMq();
    }
}