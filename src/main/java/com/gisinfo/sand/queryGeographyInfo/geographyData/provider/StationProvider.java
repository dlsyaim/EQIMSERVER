package com.gisinfo.sand.queryGeographyInfo.geographyData.provider;

import com.gisinfo.sand.queryGeographyInfo.geographyData.condition.StationCondition;

//台站构建sql类
public class StationProvider {

    //查询总记录数
    public String getStationCount(StationCondition stationCondition){
        StringBuilder builder =new StringBuilder("select count(1) count from observation_station t where 1=1");
        if(stationCondition.getName()!=null&&!"".equals(stationCondition.getName())){
            builder.append(" and t.NAME like concat(concat('%',#{name}),'%')");
        }
        return builder.toString();
    }

    //查询数据列表
    public String getStationList(StationCondition stationCondition){
        StringBuilder builder =new StringBuilder("select * from(select t.*,rownum rn from (select * from observation_station t where 1=1 ");
        if(stationCondition.getName()!=null&&!"".equals(stationCondition.getName())){
            builder.append(" and t.NAME like concat(concat('%',#{name}),'%')");
        }

        builder.append(" and rownum<=#{top})t) t where t.rn >#{bottom}");

        return builder.toString();
    }
    
}
