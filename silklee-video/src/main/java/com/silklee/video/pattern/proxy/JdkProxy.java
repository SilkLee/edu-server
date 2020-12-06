package com.silklee.video.pattern.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JdkProxy implements InvocationHandler {

    private Object target;

    public Object newProxyInstance(Object targetObject) {
        this.target = targetObject;
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = null;
        result = method.invoke(target, args);
        System.out.println(result);
        return result;
    }
}
