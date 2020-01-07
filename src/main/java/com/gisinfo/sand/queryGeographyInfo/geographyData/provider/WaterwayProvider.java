package com.gisinfo.sand.queryGeographyInfo.geographyData.provider;

import com.gisinfo.sand.queryGeographyInfo.geographyData.condition.WaterwayCondition;

//水道构建sql类
public class WaterwayProvider {
    //查询总记录数
    public String getWaterwayCount(WaterwayCondition waterwayCondition){
        StringBuilder builder =new StringBuilder("select count(1) count from WATERWAY t where 1=1");
        if(waterwayCondition.getWaterwayName()!=null&&!"".equals(waterwayCondition.getWaterwayName())){
            builder.append(" and t.name like concat(concat('%',#{waterwayName}),'%')");
        }
        if(waterwayCondition.getWaterwayClass()!=null&&!"".equals(waterwayCondition.getWaterwayClass())){
            builder.append(" and t.class like concat(concat('%',#{waterwayClass}),'%')");
        }

        return builder.toString();
    }

    //查询数据列表
    public String getWaterwayList(WaterwayCondition waterwayCondition){
        StringBuilder builder =new StringBuilder("select * from(select t.*,rownum rn from (select " +
                "t.objectid,t.name as waterwayName,t.class as waterwayClass," +
                "t.cover_area,t.length as waterwayLength,t.note_ as waterwayNote  from WATERWAY t where 1=1 ");
        if(waterwayCondition.getWaterwayName()!=null&&!"".equals(waterwayCondition.getWaterwayName())){
            builder.append(" and t.name like concat(concat('%',#{waterwayName}),'%')");
        }
        if(waterwayCondition.getWaterwayClass()!=null&&!"".equals(waterwayCondition.getWaterwayClass())){
            builder.append(" and t.class like concat(concat('%',#{waterwayClass}),'%')");
        }

        builder.append(" and rownum<=#{top})t) t where t.rn >#{bottom}");

        return builder.toString();
    }

    //获取道路等级下拉列表
    public String getWaterwayClassList(){
        StringBuilder builder =new StringBuilder("select distinct t.class as waterway_class from WATERWAY t where t.class is not null");
        return builder.toString();
    }
}
