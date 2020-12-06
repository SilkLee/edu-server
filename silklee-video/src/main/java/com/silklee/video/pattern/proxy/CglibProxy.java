package com.silklee.video.pattern.proxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibProxy implements MethodInterceptor {
    private Object target;

    public Object newProxyInstance(Object targetObject) {
        this.target = targetObject;
        Enhancer enhancer = new Enhancer();
        // 设置代理类的父类（目标类）
        enhancer.setSuperclass(this.target.getClass());
        // 设置回调函数
        enhancer.setCallback(this);
        // 创建子类（代理对象）
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        Object result = null;
        result = methodProxy.invokeSuper(o, objects);
        System.out.println(result);
        return result;
    }
}
