package org.twave.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @author : twave
 * @date : 2023/7/28 15:38
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class TaskMapperTest {
    @Autowired
    TaskMapper taskMapper;

    @Test
    public void getAllTask() {
        System.out.println(taskMapper.getAllTask());
    }
}