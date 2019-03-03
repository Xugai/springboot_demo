package com.example.demo.controller;

import com.example.demo.common.ServerResponse;
import com.example.demo.task.AsyncTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Future;

/**
 * Created by rabbit on 2019/3/3.
 */
@RestController
@RequestMapping("/asynctask")
public class AsyncTaskController {

    @Autowired
    private AsyncTask asyncTask;

    @RequestMapping("do")
    public ServerResponse doAsyncTask() throws Exception{
        long startTime = System.currentTimeMillis();

        Future<Boolean> a = asyncTask.doTask1();
        Future<Boolean> b = asyncTask.doTask2();
        Future<Boolean> c = asyncTask.doTask3();

        while(!a.isDone() || !b.isDone() || !c.isDone()){
            if(a.isDone() && b.isDone() && c.isDone()){
                break;
            }
        }

        long endTime = System.currentTimeMillis();
//        System.out.println("任务执行完成, 总耗时: " + (endTime - startTime) + "毫秒");
        return ServerResponse.createBySuccessAndMsg("任务执行完成, 总耗时: " + (endTime - startTime) + "毫秒");
    }
}
