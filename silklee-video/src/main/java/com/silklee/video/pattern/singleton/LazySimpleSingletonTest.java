package com.silklee.video.pattern.singleton;

import java.lang.reflect.Constructor;

public class LazySimpleSingletonTest {
    public static void main(String[] args) {
//        new Thread(() -> {
//            LazyDoubleCheckSingleton singleton = LazyDoubleCheckSingleton.getInstance();
//            System.out.println(Thread.currentThread().getName() + ":" + singleton);
//        }, "t1").start();
//
//        new Thread(() -> {
//            LazyDoubleCheckSingleton singleton = LazyDoubleCheckSingleton.getInstance();
//            System.out.println(Thread.currentThread().getName() + ":" + singleton);
//        }, "t2").start();
//
//        System.out.println("End");

        try {
            // 恶意用反射破坏
            Class<?> clazz = LazyStaticInnerClassSingleton.class;

            // 通过反射获取私有的构造方法
            Constructor c = clazz.getDeclaredConstructor(null);

            // 强制访问
            c.setAccessible(true);

            // 暴力初始化
            Object o1 = c.newInstance();

            // 调用了两次构造方法，相当于new了两次
            Object o2 = c.newInstance();

            System.out.println(o1 == o2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
