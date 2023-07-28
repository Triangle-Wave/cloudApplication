package org.twave.service1;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.twave.util.MqSendMessage;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author : twave
 * @date : 2023/7/28 10:59
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class MQPTest {
    @Autowired
    MqSendMessage sendMessage;

    @Test
    public void testSimpleQueue() {
        String queueName = "simple.queue";
        // 获取当前系统时间，格式为：yyyy-MM-dd HH:mm:ss
        // 创建30条消息，每条消息间隔1秒发送
        // 发送消息到队列中
        for (int i = 0; i < 30; i++) {
            String time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            String message = "AMQP send message: " + time;
            sendMessage.sendMessageToQueue(queueName, message);
        }
    }
}
