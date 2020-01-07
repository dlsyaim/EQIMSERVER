package com.gisinfo.sand.queryGeographyInfo.geographyData.provider;

import com.gisinfo.sand.queryGeographyInfo.geographyData.condition.ActiveFaultCondition;

//活跃断层构建sql类
public class ActiveFaultProvider {
    //根据条件查询数据
    public String getActiveFaultList(ActiveFaultCondition activeFaultCondition){
        StringBuilder builder =new StringBuilder("select * from(select t.*,rownum rn from (select " +
                "t.objectid as objectId,t.name as faultName,t.strike as faultStrike," +
                " t.dip_dir as dipDir,t.dip_angle as dipAngle," +
                "t.length as faultLength,t.width as faultWidth," +
                "t.feature,t.active_period as activePeriod,t.comment_  from activefault t where 1=1 ");
        if(activeFaultCondition.getFaultName()!=null&&!"".equals(activeFaultCondition.getFaultName())){
            builder.append(" and t.name like concat(concat('%',#{faultName}),'%')");
        }
        if(activeFaultCondition.getFeature()!=null&&!"".equals(activeFaultCondition.getFeature())){
            builder.append(" and t.feature like concat(concat('%',#{feature}),'%')");
        }

        builder.append(" and rownum<=#{top})t) t where t.rn >#{bottom}");

        return builder.toString();
    }

    //根据条件查询总记录数
    public String getActiveFaultCount(ActiveFaultCondition activeFaultCondition){
        StringBuilder builder =new StringBuilder("select count(1) count from activefault t where 1=1");
        if(activeFaultCondition.getFaultName()!=null&&!"".equals(activeFaultCondition.getFaultName())){
            builder.append(" and t.name like concat(concat('%',#{faultName}),'%')");
        }
        if(activeFaultCondition.getFeature()!=null&&!"".equals(activeFaultCondition.getFeature())){
            builder.append(" and t.feature like concat(concat('%',#{feature}),'%')");
        }

        return builder.toString();

    }
}
