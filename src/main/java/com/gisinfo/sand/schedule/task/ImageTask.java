package com.gisinfo.sand.schedule.task;

import com.gisinfo.sand.mapTemplate.printService.PrintService;
import com.gisinfo.sand.schedule.bean.TaskScheduleBean;
import com.gisinfo.sand.schedule.service.PlanService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 出图执行任务
 */
@Component
public class ImageTask{

    @Autowired
    private PrintService printService;
    @Autowired
    private PlanService service;

    @Async
    public void executeAsyncTask(String featid, String earthquakeFeatid, int batch) {
        if (StringUtils.isNotEmpty(earthquakeFeatid)) {
            if (StringUtils.isNotEmpty(featid)) {
                TaskScheduleBean previousBean = service.getTask(earthquakeFeatid, batch, PlanService.TYPE_ASSESS);
                if (previousBean.getTaskResult().equals(PlanService.STATUS_END)) {
                    execute(featid, earthquakeFeatid, batch);
                } else {
                    service.updateTaskStatus(featid, PlanService.STATUS_WAIT);
                }
            } else {
                execute(earthquakeFeatid, batch);
            }
        }
    }

    private void execute(String featid, String earthquakeFeatid, int batch) {
        TaskScheduleBean startBean = new TaskScheduleBean(featid, PlanService.STATUS_EXECUTE, new Date(), null);
        service.updateTaskTimeById(startBean);
        try {
            printService.getMapPrintService(earthquakeFeatid, batch + "");
            TaskScheduleBean endBean = new TaskScheduleBean(featid, PlanService.STATUS_END, null, new Date());
            service.updateTaskTimeById(endBean);
        } catch (Exception e) {
            service.updateTaskStatus(featid, PlanService.STATUS_FAIL);
            e.printStackTrace();
        }
    }

    private void execute(String earthquakeFeatid, int batch) {
        printService.getMapPrintService(earthquakeFeatid, batch + "");
    }
}
