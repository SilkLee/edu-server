//package com.silklee.video.config;
//
//import com.silklee.video.service.OmsPortalOrderService;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.amqp.rabbit.annotation.RabbitHandler;
//import org.springframework.amqp.rabbit.annotation.RabbitListener;
//import org.springframework.stereotype.Component;
//
//import javax.annotation.Resource;
//
///**
// * 取消订单消息的处理者
// */
//@Component
//@RabbitListener(queues = "edu.order.cancel")
//public class CancelOrderReceiver {
//    private static Logger LOGGER = LoggerFactory.getLogger(CancelOrderReceiver.class);
//
//    @Resource
//    private OmsPortalOrderService portalOrderService;
//
//    @RabbitHandler
//    public void handle(Long orderId){
//        LOGGER.info("receive delay message orderId:{}",orderId);
//        portalOrderService.cancelOrder(orderId);
//    }
//}
