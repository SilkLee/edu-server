package com.silklee.video.config;

import cn.hutool.extra.spring.SpringUtil;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan("com.silklee.video")
@EnableAspectJAutoProxy
@EnableTransactionManagement
@Import(SpringUtil.class)
public class AnnotationAppConfig {
}
