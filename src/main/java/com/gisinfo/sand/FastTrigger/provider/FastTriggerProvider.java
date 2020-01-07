package com.gisinfo.sand.FastTrigger.provider;

import com.gisinfo.sand.FastTrigger.bean.FastTriggerBean;

//快速触发sql构造类
public class FastTriggerProvider {
    //构造添加数据sql
    public String addEQinfoData(FastTriggerBean fastTriggerBean){
        StringBuilder builder =new StringBuilder("insert into t_earthquake_info(featid,data_source," +
                "earthquake_level,earthquake_time,latitude,longitude,earthquake_location)" +
                " values(#{featId},#{dataSource},#{earthquakeLevel},to_date(#{earthquakeTime},'yyyy-mm-dd HH24:mi:ss')," +
                "#{latitude},#{longitude},#{earthquakeLocation})");
        return builder.toString();
    }
}
