package com.example.demo.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by rabbit on 2019/3/3.
 */
@Component
public class ReportTask {

    private SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");

    /**
     * 定义该任务每过4s打印出当前系统时间
     */
    @Scheduled(fixedRate = 4000)
    public void reportTimeAtFixedRate(){
        System.out.println(format.format(new Date()));
    }
}
