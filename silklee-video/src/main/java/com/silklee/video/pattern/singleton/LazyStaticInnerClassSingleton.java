package com.silklee.video.pattern.singleton;

public class LazyStaticInnerClassSingleton {
    // 使用LazyInnerClassGeneral的时候，默认会先初始化内部类
    // 如果没使用，则内部类是不加载的
    private LazyStaticInnerClassSingleton() {
        if (LazyHolder.INSTANCE != null) {
            throw new RuntimeException("不允许创建多个实例");
        }
    }
    // 每个关键字都不是多余的，static是为了使单例模式的空间共享，保证这个方法不会被重写、重载
    private static LazyStaticInnerClassSingleton getInstance() {
        // 在返回结果之前，一定会先加载内部类
        return LazyHolder.INSTANCE;
    }
    //利用Java本身的语法特点，默认不加载内部类
    private static class LazyHolder {
        private static final LazyStaticInnerClassSingleton INSTANCE = new LazyStaticInnerClassSingleton();
    }
}
