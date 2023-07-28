package org.twave;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.twave.service.impl.TaskServiceImpl;
import org.twave.util.RedisUtil;

import javax.annotation.Resource;

/**
 * @author : twave
 * @date : 2023/7/28 9:52
 */
@SpringBootApplication
public class producer {
    @Autowired
    RedisUtil redisUtil;

    public static void main(String[] args) {
        SpringApplication.run(producer.class, args);
    }
}