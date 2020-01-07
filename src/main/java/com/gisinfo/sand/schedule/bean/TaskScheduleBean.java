package com.gisinfo.sand.schedule.bean;

import cn.hutool.core.util.IdUtil;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.gisinfo.sand.schedule.service.PlanService;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

/**
 * @version 1.0
 * @author: majun
 * @create: 2019-12-24 09:51
 * @description: 计划任务实体类
 **/
@Entity
@TableName("T_TASK_SCHEDULE")
public class TaskScheduleBean {

    public TaskScheduleBean() {}

    public TaskScheduleBean(String earthquakeFeatid, int batchNumber, String taskType, int displayOrder, Date createTime) {
        this.earthquakeFeatid = earthquakeFeatid;
        this.batchNumber = batchNumber;
        this.taskType = taskType;
        this.displayOrder = displayOrder;
        this.createTime = createTime;
        this.featid = IdUtil.simpleUUID();
        this.taskResult = PlanService.STATUS_WAIT;
    }

    public TaskScheduleBean(String featid, String taskResult, Date startTime, Date endTime) {
        this.featid = featid;
        this.taskResult = taskResult;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    @Id
    @TableField("FEATID")
    private String featid;

    @TableField("EARTHQUAKE_FEATID")
    private String earthquakeFeatid;

    @TableField("BATCH_NUMBER")
    private int batchNumber;

    @TableField("TASK_TYPE")
    private String taskType;

    @TableField("TASK_RESULT")
    private String taskResult;

    @TableField("START_TIME")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date startTime;

    @TableField("END_TIME")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endTime;

    @TableField("DISPLAY_ORDER")
    private int displayOrder;

    @TableField("CREATE_TIME")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    public String getFeatid() {
        return featid;
    }

    public void setFeatid(String featid) {
        this.featid = featid;
    }

    public String getEarthquakeFeatid() {
        return earthquakeFeatid;
    }

    public void setEarthquakeFeatid(String earthquakeFeatid) {
        this.earthquakeFeatid = earthquakeFeatid;
    }

    public int getBatchNumber() {
        return batchNumber;
    }

    public void setBatchNumber(int batchNumber) {
        this.batchNumber = batchNumber;
    }

    public String getTaskType() {
        return taskType;
    }

    public void setTaskType(String taskType) {
        this.taskType = taskType;
    }

    public String getTaskResult() {
        return taskResult;
    }

    public void setTaskResult(String taskResult) {
        this.taskResult = taskResult;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public int getDisplayOrder() {
        return displayOrder;
    }

    public void setDisplayOrder(int displayOrder) {
        this.displayOrder = displayOrder;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
