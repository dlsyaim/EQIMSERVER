package com.gisinfo.sand.schedule.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gisinfo.sand.schedule.bean.TaskScheduleBean;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import java.util.Date;

@Mapper
public interface TaskScheduleMapper extends BaseMapper<TaskScheduleBean> {

    @Update("update T_TASK_SCHEDULE set TASK_RESULT = #{status} where FEATID = #{id}")
    Integer updateStatus(@Param("id") String id, @Param("status") String status);

    @Update("update T_TASK_SCHEDULE set TASK_RESULT = #{status}, START_TIME = #{date} where FEATID = #{id}")
    Integer updateStartTimeStatus(@Param("id") String id, @Param("status") String status, @Param("date") Date date);

    @Update("update T_TASK_SCHEDULE set TASK_RESULT = #{status}, END_TIME = #{date} where FEATID = #{id}")
    Integer updateEndTimeStatus(@Param("id") String id, @Param("status") String status, @Param("date") Date date);

}
