package com.silklee.video.config;

import com.silklee.video.annotations.MidTableMapping;
import lombok.Data;
import org.reflections.Reflections;
import org.reflections.scanners.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Configuration
@Data
public class MidTableConfig {
    private Map<String, Object> map = new HashMap<>();

    @Bean
    public void processMidMapping() {
        Reflections reflections = new Reflections("com.silklee.video.dao",
                Arrays.asList(
                        new SubTypesScanner(false)//允许getAllTypes获取所有Object的子类, 不设置为false则 getAllTypes 会报错.默认为true.
                        ,new MethodParameterNamesScanner()//设置方法参数名称 扫描器,否则调用getConstructorParamNames 会报错
                        ,new MethodAnnotationsScanner() //设置方法注解 扫描器, 否则getConstructorsAnnotatedWith,getMethodsAnnotatedWith 会报错
                        ,new MemberUsageScanner() //设置 member 扫描器,否则 getMethodUsage 会报错, 不推荐使用,有可能会报错 Caused by: java.lang.ClassCastException: javassist.bytecode.InterfaceMethodrefInfo cannot be cast to javassist.bytecode.MethodrefInfo
                        ,new TypeAnnotationsScanner()//设置类注解 扫描器 ,否则 getTypesAnnotatedWith 会报错
                ));
        Set<Class<?>> classes = reflections.getTypesAnnotatedWith(MidTableMapping.class ,true); // 不包含被继承的子类
        Map<String, Object> map = new HashMap<>();
//        public boolean put(String index, String key, String value) {
//            return storeMap.computeIfAbsent(index, s -> new ConcurrentHashMap<>())
//                    .computeIfAbsent(key, s -> new ArrayList<>())
//                    .add(value);
        classes.stream().forEach(var -> map.put(var.getDeclaredAnnotation(MidTableMapping.class).name(), var));
    }
}
