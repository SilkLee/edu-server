//package com.silklee.video.config;
//
//import org.aspectj.lang.JoinPoint;
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.*;
//import org.springframework.stereotype.Component;
//
//import java.lang.reflect.Method;
//
//@Component
//@Aspect
//public class LogHandle {
//
//    @Pointcut("@annotation(com.silklee.video.config.DemoLog)")
//    private void cut(){}
//
//    @Before("cut()")
//    public void inBefore(JoinPoint joinPoint){
//        Object[] args = joinPoint.getArgs();
//        System.out.println("args --> " + "xxxx");
//    }
//
//    @Around("cut()")
//    public void inAround(ProceedingJoinPoint joinPoint){
//        try {
//
//            System.out.println("环绕前");
//            joinPoint.proceed();
//            System.out.println("环绕后");
//        } catch (Throwable throwable) {
//            throwable.printStackTrace();
//        }
//    }
//
//    @After("cut()")
//    public void inAfter(JoinPoint joinPoint) throws ClassNotFoundException {
//
//        String methodName = joinPoint.getSignature().getName(); //方法名
//        String targetName = joinPoint.getTarget().getClass().getName(); //类的全路径
//        Object[] arguments = joinPoint.getArgs(); //获取方法中的参数
//        Class [] parameterTypes = null;
//        if(arguments != null){
//            parameterTypes = new Class[arguments.length];
//            for (int i = 0; i < arguments.length; i++) {
//                parameterTypes[i] = arguments[i].getClass();
//            }
//        }
//        String name = "";
//        String value = "";
//        Class targ  = Class.forName(targetName);
//        Method[] methods = targ.getMethods();
//        for (Method method: methods) {
//            boolean is = method.getName().equals(methodName);
//            if(is){
//                Class[] temp = method.getParameterTypes();//获取参数类型
//                if(temp.length == parameterTypes.length){
//                    name = method.getAnnotation(DemoLog.class).name();
//                    value = method.getAnnotation(DemoLog.class).value();
//                }
//            }
//        }
//        System.out.println(targetName + "{" + methodName + "}");
//        System.out.println(name + " | " + value);
//    }
//}
