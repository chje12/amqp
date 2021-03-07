package com.example.amqp.publisher;

import java.util.UUID;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.amqp.config.OrderAmqpConfig;
import com.example.amqp.dto.Order;

@RestController
@RequestMapping("/order")
public class OrderPublisherController {
    private final RabbitTemplate template;

    public OrderPublisherController(RabbitTemplate template) {
        this.template = template;
    }

    @PostMapping("{restaurant}")
    public String order(@RequestBody Order order, @PathVariable String restaurant) {
        order.setOrderId(UUID.randomUUID().toString());
        template.convertAndSend(OrderAmqpConfig.EXCHANGE_NAME, OrderAmqpConfig.ROUTING_KEY_PREPEND + restaurant, order);
        return "주문 완료";
    }
}