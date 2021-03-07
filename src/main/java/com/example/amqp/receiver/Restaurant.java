package com.example.amqp.receiver;


import com.example.amqp.config.OrderAmqpConfig;
import com.example.amqp.dto.Order;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Restaurant {

    @RabbitListener(queues = OrderAmqpConfig.QUEUE_NAME)
    public void receiveMessage(Order order) {
        System.out.println("배달의 민족 주문~ : " + order.toString());
    }


}