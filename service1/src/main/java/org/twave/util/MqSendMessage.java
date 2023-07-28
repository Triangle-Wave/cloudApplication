package org.twave.util;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 这个类用于向消息队列发送消息，使用的是RabbitTemplate
 * <p>
 * 有两个方法：分别是向交换机发送消息和向队列发送消息
 *
 * @author : twave
 * @date : 2023/7/28 13:15
 */
@Component
public class MqSendMessage {
    // 注入RabbitTemplate
    @Resource
    private RabbitTemplate rabbitTemplate;

    /**
     * 这个方法用于向消息队列发送消息
     *
     * @param exchange   路由名称
     * @param routingKey 路由key
     * @param message    消息内容
     */
    public void sendMessageToExchange(String exchange, String routingKey, Object message) {
        rabbitTemplate.convertAndSend(exchange, routingKey, message);
    }

    /**
     * 这个方法用于向消息队列发送消息，使用的是默认的交换机
     *
     * @param queueName 队列名称
     * @param message   消息内容
     */
    public void sendMessageToQueue(String queueName, Object message) {
        rabbitTemplate.convertAndSend(queueName, message);
    }
}
