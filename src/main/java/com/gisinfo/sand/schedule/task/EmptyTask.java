package com.gisinfo.sand.schedule.task;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * 空执行任务
 */
@Service
public class EmptyTask {

    Random random = new Random();// 默认构造方法

    @Async
    public void executeAsyncTask() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
