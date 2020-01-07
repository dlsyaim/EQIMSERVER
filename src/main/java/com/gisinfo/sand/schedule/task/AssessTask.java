package com.gisinfo.sand.schedule.task;

import com.gisinfo.sand.schedule.bean.TaskScheduleBean;
import com.gisinfo.sand.schedule.service.PlanService;
import com.gisinfo.sand.systemManage.modelSetting.service.CalcModelService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 评估执行任务
 */
@Component
public class AssessTask{

    @Autowired
    private CalcModelService calcModelService;
    @Autowired
    private PlanService service;

    @Async
    public void executeAsyncTask(String featid, String earthquakeFeatid, int batch) {
        if (StringUtils.isNotEmpty(earthquakeFeatid)) {
            System.out.println("评估执行任务 = " + System.currentTimeMillis());
            if (StringUtils.isNotEmpty(featid)) {
                TaskScheduleBean previousBean = service.getTask(earthquakeFeatid, batch, PlanService.TYPE_SPATIAL);
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
            calcModelService.startCalcModel(earthquakeFeatid, batch);
            TaskScheduleBean endBean = new TaskScheduleBean(featid, PlanService.STATUS_END, null, new Date());
            service.updateTaskTimeById(endBean);
        } catch (Exception e) {
            service.updateTaskStatus(featid, PlanService.STATUS_FAIL);
            e.printStackTrace();
        }
    }

    private void execute(String earthquakeFeatid, int batch) {
        calcModelService.startCalcModel(earthquakeFeatid, batch);
    }
}
