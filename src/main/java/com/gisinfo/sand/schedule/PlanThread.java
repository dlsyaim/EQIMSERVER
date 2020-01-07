package com.gisinfo.sand.schedule;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Configuration
@ComponentScan("com.gisinfo.sand.schedule")
@EnableAsync
public class PlanThread implements AsyncConfigurer {

    @Override
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        taskExecutor.setCorePoolSize(1);// 最小线程数
        taskExecutor.setMaxPoolSize(1);// 最大线程数
        taskExecutor.setQueueCapacity(10000);// 等待队列
        taskExecutor.initialize();
        taskExecutor.setThreadNamePrefix("TASK_PLAN_THREAD-");//  线程名称前缀
        taskExecutor.initialize(); // 初始化
        System.out.println("---------------------------开启计划任务线程池");
        return taskExecutor;
    }

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return new TaskPlanAsyncException();
    }

}
