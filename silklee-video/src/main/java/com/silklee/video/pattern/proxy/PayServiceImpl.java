package com.silklee.video.pattern.proxy;

public class PayServiceImpl implements PayService {

    public String callback(String outTradeNo) {

        return outTradeNo;

    }

    public int save(int userId, int productId) {

        return productId;

    }
}
