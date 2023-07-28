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
 * 定时任务
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
        List<Map<String, String>> list = redisUtil.getAllSchedule();
        if (list == null || list.size() == 0) {
            System.out.print("\r当前没有任务");
        } else {
            for (Map<String, String> map : list) {
                System.out.println("\r" + map);
            }
        }
    }
}
