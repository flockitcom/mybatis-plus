package com.zq.listener;

import com.zq.constant.RabbitMQConstant;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class CommentListener {

    @RabbitHandler
    @RabbitListener(queues = RabbitMQConstant.COMMENT_QUEUE_DLX)
    public void comment(String name) {
        System.out.println(name + "用户默认好评");
    }
}
