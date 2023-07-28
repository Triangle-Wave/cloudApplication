package org.twave.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * @author : twave
 * @date : 2023/7/28 15:55
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class TaskServiceImplTest {
    @Resource
    TaskServiceImpl taskService;

    @Test
    public void sendTaskToMq() {
        taskService.sendTaskToMq();
    }
}