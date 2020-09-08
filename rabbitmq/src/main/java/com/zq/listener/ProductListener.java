package com.zq.listener;

import com.zq.constant.RabbitMQConstant;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class ProductListener {

    @RabbitHandler
    @RabbitListener(queues = RabbitMQConstant.PRODUCT_QUEUE)
    public void product(String name) {
        System.out.println(name + "用户查看产品");
    }
}
