package com.zq.constant;

public class RabbitMQConstant {

    //队列
    /***
     * 正常队列
     */
    public static final String PRODUCT_QUEUE = "product_queue";

    /**
     * 评论  延迟队列
     */
    public static final String COMMENT_QUEUE_TTL = "comment_queue_ttl";

    /***
     * 评论  死信队列
     */
    public static final String COMMENT_QUEUE_DLX = "comment_queue_dlx";

    //交换机
    /***
     * 产品交换机 fanout 直接转发
     */
    public static final String PRODUCT_EXCHANGE = "product_exchange";

    /***
     * 产品评论交换机 direct 路由匹配
     */
    public static final String  COMMENT_PRODUCT_EXCHANGE = "comment_product_exchange";

    /***
     * 定义路由规则名称
     */
    public static final String COMMENT_ROUTING_KEY_DLX = "comment_dlx";

    /***
     * 7天后 默认好评
     */
//    public static final int COMMENT_DEFAULT_TIME = 7 * 24 * 60 * 60;
    public static final int COMMENT_DEFAULT_TIME = 30;

}
