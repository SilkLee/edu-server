package com.silklee.video.schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * 定时统计订单、金额
 */
@Component
public class VideoOrderTask {
    // 每两秒执行一次
//    @Scheduled(fixedRate = 4000)
//    @Scheduled(fixedDelay = 4000)
//    @Scheduled(cron = "*/1 * * * * *")
    public void sum() {
        System.out.println(LocalDateTime.now() + "当前交易额" + Math.random() * 1000);

        try {
            Thread.sleep(2000L);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
