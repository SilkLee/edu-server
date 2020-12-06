//package com.silklee.video.aop;
//
//import com.silklee.video.annotations.MidTableMapping;
//import org.aspectj.lang.JoinPoint;
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.*;
//import org.aspectj.lang.reflect.MethodSignature;
//import org.reflections.Reflections;
//import org.springframework.core.annotation.AnnotationUtils;
//import org.springframework.stereotype.Component;
//
//import java.lang.reflect.Method;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.Set;
//
//@Component
//@Aspect
//public class MidTableAOP {
//    // 切⼊点表达式
//    @Pointcut("execution(* com.silklee.video.dao.*.*(..))")
//    public void pointCut() {
//    }
//
//    // 前置通知
//    @Before("pointCut()")
//    public void before(JoinPoint joinPoint){
////        Reflections reflections = new Reflections("com.silklee.video.dao");
////        Set<Class<?>> classesList = reflections.getTypesAnnotatedWith(MidTableMapping.class);
//        MethodSignature sign = (MethodSignature) joinPoint.getSignature();
//        Method method = sign.getMethod();
//        //获取方法上的注解
//        MidTableMapping annotation = method.getAnnotation(MidTableMapping.class);
//        // 存放url和ExecutorBean的对应关系
//        Map<String, Object> mapp = new HashMap<>();
//
//        MidTableMapping annotation1 = AnnotationUtils.findAnnotation(sign.getMethod().getDeclaringClass(), MidTableMapping.class);
//        System.out.println();
//
//    }
//
//    // 后置通知
////    @After("pointCut()")
////    public void afterLog(JoinPoint joinPoint){
////        System.out.println("LogAdvice afterLog");
////    }
//
//    /**
//     * 环绕通知
//     * @param joinPoint
//     */
////    @Around("pointCut()")
////    public void around(JoinPoint joinPoint) {
////        String name = joinPoint.getTarget().getClass().getName();
////        System.out.println("调⽤者="+name);
////        //⽬标⽅法签名
////        System.out.println("调⽤⽅法="+joinPoint.getSignature());
////        //通过joinPoint获取参数
//////        Object[] args = joinPoint.getArgs();
//////        System.out.println("参数="+args[0]);
////
////        long start = System.currentTimeMillis();
////        System.out.println("环绕通知 环绕前=========");
////
////        try {
////            ((ProceedingJoinPoint)joinPoint).proceed();
////        } catch (Throwable throwable) {
////            throwable.printStackTrace();
////        }
////
////        long end = System.currentTimeMillis();
////        System.out.println("环绕通知 环绕后=========");
////        System.out.println("调⽤⽅法总耗时 time = " + (end - start) +" ms");
////    }
//}
