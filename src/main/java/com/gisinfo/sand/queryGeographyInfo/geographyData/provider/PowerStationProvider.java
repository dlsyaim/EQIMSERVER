package com.gisinfo.sand.queryGeographyInfo.geographyData.provider;

import com.gisinfo.sand.queryGeographyInfo.geographyData.condition.PowerStationCondition;

//重要发电厂房信息构建sql类
public class PowerStationProvider {

    //查询总记录数
    public String getPowerStationCount(PowerStationCondition powerStationCondition){
        StringBuilder builder =new StringBuilder("select count(1) count from power_plant_information t where 1=1");
        if(powerStationCondition.getName()!=null&&!"".equals(powerStationCondition.getName())){
            builder.append(" and t.name like concat(concat('%',#{name}),'%')");
        }
        return builder.toString();
    }

    //查询数据列表
    public String getPowerStationList(PowerStationCondition powerStationCondition){
        StringBuilder builder =new StringBuilder("select * from(select t.*,rownum rn from (select * from power_plant_information t where 1=1 ");
        if(powerStationCondition.getName()!=null&&!"".equals(powerStationCondition.getName())){
            builder.append(" and t.name like concat(concat('%',#{name}),'%')");
        }

        builder.append(" and rownum<=#{top})t) t where t.rn >#{bottom}");

        return builder.toString();
    }
    
}
