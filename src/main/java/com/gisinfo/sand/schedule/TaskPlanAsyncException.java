package com.gisinfo.sand.schedule;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;

import java.lang.reflect.Method;

/**
 * @version 1.0
 * @author: majun
 * @create: 2019-12-31 11:51
 * @description: 计划任务线程池异常类
 **/
public class TaskPlanAsyncException implements AsyncUncaughtExceptionHandler {

    //手动处理捕获的异常
    @Override
    public void handleUncaughtException(Throwable throwable, Method method, Object... obj) {
        System.out.println("-------------》》》捕获计划任务线程池异常信息");
        System.out.println("Exception message - " + throwable.getMessage());
        System.out.println("Method name - " + method.getName());
        for (Object param : obj) {
            System.out.println("Parameter value - " + param);
        }
    }

}
