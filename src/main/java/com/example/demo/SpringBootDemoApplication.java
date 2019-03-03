package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import tk.mybatis.spring.annotation.MapperScan;

/*
* 	默认扫描启动类所在路径下的所有bean
* */
@SpringBootApplication
@MapperScan(basePackages = "com.example.demo.mapper")
// 开启定时任务，扫描IOC容器中那些具有@Scheduled注解的方法的类
@EnableScheduling
// 开启异步任务
@EnableAsync
public class SpringBootDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDemoApplication.class, args);
	}
}
