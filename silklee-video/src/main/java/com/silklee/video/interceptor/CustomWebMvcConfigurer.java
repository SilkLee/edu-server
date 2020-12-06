//package com.silklee.video.interceptor;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
///**
// * 拦截器配置类
// */
//@Configuration
//public class CustomWebMvcConfigurer implements WebMvcConfigurer {
//
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//
//        registry.addInterceptor(getLoginInterceptor())
//            .addPathPatterns("/api/v1/pri/**","/api/v1/pri/user/**")
//            .excludePathPatterns("/**/*.html","/**/*.js"); //配置不拦截某些路径;
//        registry.addInterceptor(new SecondInterceptor()).addPathPatterns("/api/v1/pri/**");
//        WebMvcConfigurer.super.addInterceptors(registry);
//    }
//
//    @Bean
//    public LoginInterceptor getLoginInterceptor() {
//        return new LoginInterceptor();
//    }
//}
