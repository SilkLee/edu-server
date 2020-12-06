package com.silklee.video.task;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;

@Component
@Async
public class AsyncTask {
    public Future<String> task1() {
        try {
            Thread.sleep(4000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(" task 1 ");
        return new AsyncResult<String>("task1");
    }

    public Future<String> task2() {
        try {
            Thread.sleep(4000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(" task 2 ");
        return new AsyncResult<String>("task2");
    }

    public Future<String> task3() {
        try {
            Thread.sleep(4000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(" task 3 ");
        return new AsyncResult<String>("task3");
    }
}
