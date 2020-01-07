package com.gisinfo.sand.schedule.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gisinfo.sand.schedule.PlanThread;
import com.gisinfo.sand.schedule.bean.TaskScheduleBean;
import com.gisinfo.sand.schedule.dao.TaskScheduleMapper;
import com.gisinfo.sand.schedule.task.AssessTask;
import com.gisinfo.sand.schedule.task.ImageTask;
import com.gisinfo.sand.schedule.task.ReportTask;
import com.gisinfo.sand.schedule.task.SpatialTask;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PlanService extends ServiceImpl<TaskScheduleMapper, TaskScheduleBean> {

    //空间计算
    public static final String TYPE_SPATIAL = "spatial";
    //评估
    public static final String TYPE_ASSESS = "assess";
    //出图
    public static final String TYPE_IMAGE = "image";
    //出报告
    public static final String TYPE_REPORT = "report";

    //等待计算
    public static final String STATUS_WAIT = "wait";
    //执行队列中
    public static final String STATUS_QUEUE = "queue";
    //执行中
    public static final String STATUS_EXECUTE = "execute";
    //执行完毕
    public static final String STATUS_END = "end";
    //执行失败
    public static final String STATUS_FAIL = "fail";

    @Autowired(required = false)
    private TaskScheduleMapper taskScheduleMapper;

    @Autowired
    private SpatialTask spatialTask;
    @Autowired
    private AssessTask assessTask;
    @Autowired
    private ImageTask imageTask;
    @Autowired
    private ReportTask reportTask;

    /**
     * 快速计算地震分析结果，一步完成4步骤，不检验成功与否
     * @param earthquakeFeatid
     * @param batch
     */
    public void fastOneStep(String earthquakeFeatid, int batch) {
        spatialTask.executeAsyncTask(null, earthquakeFeatid, batch);
        assessTask.executeAsyncTask(null, earthquakeFeatid, batch);
        imageTask.executeAsyncTask(null, earthquakeFeatid, batch);
        reportTask.executeAsyncTask(null, earthquakeFeatid, batch);
    }

    /**
     * 创建执行计划任务
     * @param earthquakeFeatid
     * @param batch
     */
    public void createTask(String earthquakeFeatid, int batch) {
        if (StringUtils.isNotEmpty(earthquakeFeatid)) {
            Date date = new Date();
            TaskScheduleBean spatialBean = new TaskScheduleBean(earthquakeFeatid, batch, TYPE_SPATIAL, 1, date);
            TaskScheduleBean assessBean = new TaskScheduleBean(earthquakeFeatid, batch, TYPE_ASSESS, 2, date);
            TaskScheduleBean imageBean = new TaskScheduleBean(earthquakeFeatid, batch, TYPE_IMAGE, 3, date);
            TaskScheduleBean reportBean = new TaskScheduleBean(earthquakeFeatid, batch, TYPE_REPORT, 4, date);
            taskScheduleMapper.insert(spatialBean);
            taskScheduleMapper.insert(assessBean);
            taskScheduleMapper.insert(imageBean);
            taskScheduleMapper.insert(reportBean);
        }
    }

    /**
     * 获取当前等待或失败的执行计划
     */
    public TaskScheduleBean getWaitTask() {
        QueryWrapper<TaskScheduleBean> queryWrapper = new QueryWrapper<TaskScheduleBean>()
                .eq("TASK_RESULT", STATUS_WAIT)
                .or()
                .eq("TASK_RESULT", STATUS_FAIL)
                .orderByAsc("CREATE_TIME,DISPLAY_ORDER");
        List<TaskScheduleBean> list = taskScheduleMapper.selectList(queryWrapper);
        if (null != list && !list.isEmpty()) {
            return list.get(0);
        }
        return null;
    }

    /**
     * 根据id获取bean
     * @param id
     * @return
     */
    public TaskScheduleBean getTaskById(String id) {
        if (StringUtils.isNotEmpty(id)) {
            return taskScheduleMapper.selectById(id);
        }
        return null;
    }

    /**
     * 根据地震id，批次号，任务类型获取bean
     * @param earthquakeId
     * @param batch
     * @param type
     * @return
     */
    public TaskScheduleBean getTask(String earthquakeId, int batch, String type) {
        if (StringUtils.isNotEmpty(earthquakeId) && StringUtils.isNotEmpty(type)) {
            QueryWrapper<TaskScheduleBean> queryWrapper = new QueryWrapper<TaskScheduleBean>()
                    .eq("EARTHQUAKE_FEATID", earthquakeId)
                    .eq("BATCH_NUMBER", batch)
                    .eq("TASK_TYPE", type);
            List<TaskScheduleBean> list = taskScheduleMapper.selectList(queryWrapper);
            if (null != list && !list.isEmpty()) {
                return list.get(0);
            }
        }
        return null;
    }

    /**
     * 更新计划任务状态
     * @param id
     * @param status
     * @return
     */
    public Integer updateTaskStatus(String id, String status) {
        if (StringUtils.isNotEmpty(id)) {
            return taskScheduleMapper.updateStatus(id, status);
        }
        return -1;
    }

    /**
     * 更新计划任务状态+时间
     * @param bean
     * @return
     */
    public Integer updateTaskTimeById(TaskScheduleBean bean) {
        if (null != bean) {
            if (null != bean.getStartTime()) {
                return updateTaskStartTimeById(bean);
            } else if (null != bean.getEndTime()) {
                return updateTaskEndTimeById(bean);
            }
        }
        return -1;
    }

    /**
     * 更新计划任务状态+开始时间
     * @param bean
     * @return
     */
    public Integer updateTaskStartTimeById(TaskScheduleBean bean) {
        if (null != bean && StringUtils.isNotEmpty(bean.getFeatid())) {
            return taskScheduleMapper.updateStartTimeStatus(bean.getFeatid(), bean.getTaskResult(), bean.getStartTime());
        }
        return -1;
    }

    /**
     * 更新计划任务状态+结束时间
     * @param bean
     * @return
     */
    public Integer updateTaskEndTimeById(TaskScheduleBean bean) {
        if (null != bean && StringUtils.isNotEmpty(bean.getFeatid())) {
            return taskScheduleMapper.updateEndTimeStatus(bean.getFeatid(), bean.getTaskResult(), bean.getEndTime());
        }
        return -1;
    }

}
