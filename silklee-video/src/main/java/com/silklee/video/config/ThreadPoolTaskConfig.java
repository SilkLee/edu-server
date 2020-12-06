package com.silklee.video.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.context.request.async.TimeoutCallableProcessingInterceptor;
import org.springframework.web.servlet.config.annotation.AsyncSupportConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.concurrent.ThreadPoolExecutor;

@Configuration
@EnableAsync
public class ThreadPoolTaskConfig implements WebMvcConfigurer {

    // 核心线程数（默认线程数）
    @Value("${async.executor.thread.core_pool_size}")
    private int corePoolSize;
    // 最大线程数
    @Value("${async.executor.thread.max_pool_size}")
    private int maxPoolSize;
    // 缓冲队列数
    @Value("${async.executor.thread.queue_capacity}")
    private int queueCapacity;
    // 线程池名前缀
    @Value("${async.executor.thread.name.prefix}")
    private String threadNamePrefix;
    // 允许线程空闲时间（单位：默认为秒）
    @Value("${async.executor.thread.keep.alive.time}")
    private int keepAliveTime;

    @Bean("taskExecutor")
    public ThreadPoolTaskExecutor taskExecutor() {
        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
        threadPoolTaskExecutor.setCorePoolSize(corePoolSize);
        threadPoolTaskExecutor.setQueueCapacity(queueCapacity);
        threadPoolTaskExecutor.setMaxPoolSize(maxPoolSize);
        threadPoolTaskExecutor.setKeepAliveSeconds(keepAliveTime);
        threadPoolTaskExecutor.setThreadNamePrefix(threadNamePrefix);

        // 线程池对拒绝任务的处理策略
        threadPoolTaskExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.AbortPolicy());

        // 初始化
        threadPoolTaskExecutor.initialize();
        return threadPoolTaskExecutor;
    }

    @Override
    public void configureAsyncSupport(final AsyncSupportConfigurer configurer) {
        configurer.setDefaultTimeout(60 * 1000L);
        configurer.registerCallableInterceptors(timeoutInterceptor());
        configurer.setTaskExecutor(taskExecutor());
    }

    @Bean
    public TimeoutCallableProcessingInterceptor timeoutInterceptor() {
        return new TimeoutCallableProcessingInterceptor();
    }
}
