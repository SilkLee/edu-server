//package com.silklee.video.pattern.proxy;
//
//public class ProxyTest {
//
//
//    public static void main(String [] args){
//
//        // JDK动态代理
//        JdkProxy jdkProxy = new JdkProxy();
//        //获取代理类对象
//        PayService payServiceProxy = (PayService)jdkProxy.newProxyInstance(new PayServiceImpl());
//        //调用目标方法
//        String outTradeNo = payServiceProxy.callback("dsfsdfdsfew");
//        int productId = payServiceProxy.save(23,42423);
//
//        //CGlib动态代理
//        CglibProxy cglibProxy = new CglibProxy();
//        PayService payService  = (PayService) cglibProxy.newProxyInstance(new PayServiceImpl());
//
//        //调用目标方法
//        payService.save(23,2434);
//        payService.callback("f2323dfrv3f23");
//
//    }
//
//
//}
