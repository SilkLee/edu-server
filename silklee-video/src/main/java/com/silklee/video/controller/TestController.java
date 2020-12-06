package com.silklee.video.controller;

import com.silklee.common.bean.Resp;
import com.silklee.video.task.AsyncTask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * 测试
 */
@RestController
@RequestMapping("/api/v1/test")
public class TestController {
    Logger logger = LoggerFactory.getLogger(TestController.class);
    @Resource
    private AsyncTask asyncTask;


    @GetMapping("async")
    public Resp testAsync() {
        long begin = System.currentTimeMillis();
        Future<String> task1 = asyncTask.task1();
        Future<String> task2 =asyncTask.task2();

        while (true) {
            if (task1.isDone() && task2.isDone()) {
                try {
                    String task1Result = task1.get();
                    System.out.println(task1Result);
                    String task2Result = task2.get();
                    System.out.println(task2Result);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                } finally {
                    break;
                }
            }
        }
        long end = System.currentTimeMillis();
        return Resp.ok(end - begin);
    }

    @GetMapping("/test2Async")
    public <T> Callable<T> test2Async() {
        logger.info("主线程开始======>" + Thread.currentThread().getName());
        Callable<T> callable = () -> {
            logger.info("异步线程开始======>" + Thread.currentThread().getName());
            Thread.sleep(30000);
            logger.info("异步线程结束======>" + Thread.currentThread().getName());
            return (T) "success";
        };
        logger.info("主线程结束======>" + Thread.currentThread().getName());
        return callable;
    }

}
