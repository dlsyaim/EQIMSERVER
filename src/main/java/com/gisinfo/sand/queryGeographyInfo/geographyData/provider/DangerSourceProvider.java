package com.gisinfo.sand.queryGeographyInfo.geographyData.provider;

import com.gisinfo.sand.queryGeographyInfo.geographyData.condition.DangerSourceCondition;

//危险源构建sql类
public class DangerSourceProvider {

    //查询总记录数
    public String getDangerSourceCount(DangerSourceCondition dangerSourceCondition){
        StringBuilder builder =new StringBuilder("select count(1) count from DANGEROUS_SOURCE t where 1=1");
        if(dangerSourceCondition.getFeature()!=null&&!"".equals(dangerSourceCondition.getFeature())){
            builder.append(" and t.feature like concat(concat('%',#{feature}),'%')");
        }

        return builder.toString();
    }

    //查询数据列表
    public String getDangerSourceList(DangerSourceCondition dangerSourceCondition){
        StringBuilder builder =new StringBuilder("select * from(select t.*,rownum rn from (select " +
                "t.objectid,t.name as dangerName,t.postcode,t.location,t.feature,t.storage," +
                "t.capacity,t.intensity,t.fire,t.NOTE_ as note from DANGEROUS_SOURCE t where 1=1 ");
        if(dangerSourceCondition.getFeature()!=null&&!"".equals(dangerSourceCondition.getFeature())){
            builder.append(" and t.feature like concat(concat('%',#{feature}),'%')");
        }

        builder.append(" and rownum<=#{top})t) t where t.rn >#{bottom}");

        return builder.toString();
    }

}
