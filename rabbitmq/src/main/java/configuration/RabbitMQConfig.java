package configuration;


import com.zq.constant.RabbitMQConstant;
import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class RabbitMQConfig {
    /**
     * 创建正常队列
     */
    @Bean
    public Queue createProductQueue(){
        return new Queue(RabbitMQConstant.PRODUCT_QUEUE);
    }

    /**
     * 创建延迟队列
     */
    @Bean
    public Queue createTtlCommentQueue(){
        Map<String,Object> args = new HashMap<>(16);
        //设置延迟时间
        args.put("x-message-ttl", RabbitMQConstant.COMMENT_DEFAULT_TIME * 1000);
        //设置死信队列的交换器
        args.put("x-dead-letter-exchange", RabbitMQConstant.COMMENT_PRODUCT_EXCHANGE);
        //设置死信队列的路由关键字
        args.put("x-dead-routing-key", RabbitMQConstant.COMMENT_ROUTING_KEY_DLX);
        return QueueBuilder.durable(RabbitMQConstant.COMMENT_QUEUE_TTL).withArguments(args).build();
    }

    /**
     * 创建死信队列
     */
    @Bean
    public Queue createDlxCommentQueue(){

        return new Queue(RabbitMQConstant.COMMENT_QUEUE_DLX);
    }

    /***
     * 创建fanout交换机  直接转发
     */
    @Bean
    public FanoutExchange createProductExchange(){
        return new FanoutExchange(RabbitMQConstant.PRODUCT_EXCHANGE);
    }

    /***
     * 创建direct交换机 延迟队列的超时消息 转发到死信队列
     */
    @Bean
    public DirectExchange createTtlCommentExchange(){
        return new DirectExchange(RabbitMQConstant.COMMENT_PRODUCT_EXCHANGE);
    }

    //绑定队列和交换机

    @Bean
    public Binding bindProduct(){
        return BindingBuilder.bind(createProductQueue()).to(createProductExchange());
    }

    @Bean
    public Binding bindTtlComment(){
        return BindingBuilder.bind(createTtlCommentQueue()).to(createProductExchange());
    }

    @Bean
    public Binding bindDlxComment(){
        return BindingBuilder.bind(createDlxCommentQueue()).to(createTtlCommentExchange()).with(RabbitMQConstant.COMMENT_ROUTING_KEY_DLX);
    }

}
