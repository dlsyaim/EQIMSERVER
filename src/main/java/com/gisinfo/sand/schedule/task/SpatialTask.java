package com.gisinfo.sand.schedule.task;

import com.gisinfo.sand.dataManage.service.SpatialAnalysisService;
import com.gisinfo.sand.schedule.bean.TaskScheduleBean;
import com.gisinfo.sand.schedule.service.PlanService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 空间叠加分析执行任务
 */
@Component
public class SpatialTask{

    @Autowired
    private SpatialAnalysisService spatialAnalysisService;
    @Autowired
    private PlanService service;

    @Async
    public void executeAsyncTask(String featid, String earthquakeFeatid, int batch) {
        if (StringUtils.isNotEmpty(earthquakeFeatid)) {
            System.out.println("空间叠加分析执行任务 = " + System.currentTimeMillis());
            if (StringUtils.isNotEmpty(featid)) {
                TaskScheduleBean startBean = new TaskScheduleBean(featid, PlanService.STATUS_EXECUTE, new Date(), null);
                service.updateTaskTimeById(startBean);
                try {
                    boolean success = spatialAnalysisService.start(earthquakeFeatid, batch);
                    if (success) {
                        TaskScheduleBean endBean = new TaskScheduleBean(featid, PlanService.STATUS_END, null, new Date());
                        service.updateTaskTimeById(endBean);
                    } else {
                        service.updateTaskStatus(featid, PlanService.STATUS_FAIL);
                    }
                } catch (Exception e) {
                    service.updateTaskStatus(featid, PlanService.STATUS_FAIL);
                    e.printStackTrace();
                }
            } else {
                spatialAnalysisService.start(earthquakeFeatid, batch);
            }
        }
    }
}
