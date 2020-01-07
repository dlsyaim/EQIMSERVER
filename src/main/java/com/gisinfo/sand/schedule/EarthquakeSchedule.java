package com.gisinfo.sand.schedule;


import com.gisinfo.sand.schedule.bean.TaskScheduleBean;
import com.gisinfo.sand.schedule.service.PlanService;
import com.gisinfo.sand.schedule.task.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.File;
import java.util.Calendar;
import java.util.Date;

@Component
public class EarthquakeSchedule {

    private static boolean IS_INIT = false;

    /*@Autowired
    private SpatialTask spatialTask;
    @Autowired
    private AssessTask assessTask;
    @Autowired
    private ImageTask imageTask;
    @Autowired
    private ReportTask reportTask;
    @Autowired
    private EmptyTask emptyTask;
    @Autowired
    private PlanService service;*/

    // 每隔15秒执行
    @Scheduled(fixedDelay = 15000)
    public void run() {
        /*if (!IS_INIT) {
            initThread();
            return;
        }
        TaskScheduleBean bean = service.getWaitTask();
        if (null != bean && StringUtils.isNotEmpty(bean.getEarthquakeFeatid())) {
            switch (bean.getTaskType()) {
                case PlanService.TYPE_SPATIAL:
                    spatialTask.executeAsyncTask(bean.getFeatid(), bean.getEarthquakeFeatid(), bean.getBatchNumber());
                    break;
                case PlanService.TYPE_ASSESS:
                    assessTask.executeAsyncTask(bean.getFeatid(), bean.getEarthquakeFeatid(), bean.getBatchNumber());
                    break;
                case PlanService.TYPE_IMAGE:
                    imageTask.executeAsyncTask(bean.getFeatid(), bean.getEarthquakeFeatid(), bean.getBatchNumber());
                    break;
                case PlanService.TYPE_REPORT:
                    reportTask.executeAsyncTask(bean.getFeatid(), bean.getEarthquakeFeatid(), bean.getBatchNumber());
                    break;
            }
        }*/
    }

    /*private void initThread() {
        emptyTask.executeAsyncTask();
        IS_INIT = true;
    }*/

}
