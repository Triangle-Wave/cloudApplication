package org.twave.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.twave.service.impl.TaskServiceImpl;
import org.twave.util.RedisUtil;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 定时任务，每500ms从Redis中获取一次当前进度，打印到控制台
 *
 * @author : twave
 * @date : 2023/7/28 17:28
 */
@Configuration
@EnableScheduling
public class GetSchedule {
    @Autowired
    RedisUtil redisUtil;

    /**
     * 每500ms获取一次进度
     */
    @Scheduled(fixedRate = 500)
    public void getSchedule() {
        // 用list接收Redis中的所有任务进度
        List<Map<String, String>> list = redisUtil.getAllSchedule();
        // 如果list为空，说明当前没有任务在运行
        if (list == null || list.size() == 0) {
            System.out.print("\r当前没有任务在运行");
        } else {
            // 打印信息
            System.out.print("\r所有任务进度：");
            for (Map<String, String> map : list) {
                System.out.printf("任务%s 运行在%s上 进度%s/%s; ",
                        map.get("taskId"),
                        map.get("serviceName"),
                        map.get("now"),
                        map.get("all"));
            }
        }
    }
}