package com.example.demo.task;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;

/**
 * Created by rabbit on 2019/3/3.
 */
@Component
public class AsyncTask {


    @Async
    public Future<Boolean> doTask1() throws InterruptedException{
        long startTime = System.currentTimeMillis();
        Thread.sleep(8000);
        long endTime = System.currentTimeMillis();
        System.out.println("任务1耗时: " + (endTime - startTime) + "毫秒");
        return new AsyncResult<>(true);
    }

    @Async
    public Future<Boolean> doTask2() throws InterruptedException{
        long startTime = System.currentTimeMillis();
        Thread.sleep(4000);
        long endTime = System.currentTimeMillis();
        System.out.println("任务2耗时: " + (endTime - startTime) + "毫秒");
        return new AsyncResult<>(true);
    }

    @Async
    public Future<Boolean> doTask3() throws InterruptedException{
        long startTime = System.currentTimeMillis();
        Thread.sleep(3000);
        long endTime = System.currentTimeMillis();
        System.out.println("任务3耗时: " + (endTime - startTime) + "毫秒");
        return new AsyncResult<>(true);
    }
}
