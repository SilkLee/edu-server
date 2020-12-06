package com.silklee.video.service;

/**
 * 前台订单管理Service
 */
public interface OmsPortalOrderService {
    /**
     * 根据提交信息生成订单
     */
    void generateOrder();

    /**
     * 取消单个超时订单
     */
    void cancelOrder(Long orderId);
}
