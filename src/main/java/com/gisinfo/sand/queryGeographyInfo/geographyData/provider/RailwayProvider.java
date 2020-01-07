package com.gisinfo.sand.queryGeographyInfo.geographyData.provider;

import com.gisinfo.sand.queryGeographyInfo.geographyData.condition.RailwayCondition;

//铁路构建sql类
public class RailwayProvider {

    //查询总记录数
    public String getRailwayCount(RailwayCondition railwayCondition){
        StringBuilder builder =new StringBuilder("select count(1) count from RAILWAY t where 1=1");
        if(railwayCondition.getName()!=null&&!"".equals(railwayCondition.getName())){
            builder.append(" and t.name like concat(concat('%',#{name}),'%')");
        }
        if(railwayCondition.getRailwayClass()!=null&&!"".equals(railwayCondition.getRailwayClass())){
            builder.append(" and t.class like concat(concat('%',#{name}),'%')");
        }

        return builder.toString();
    }

    //查询数据列表
    public String getRailwayList(RailwayCondition railwayCondition){
        StringBuilder builder =new StringBuilder("select * from(select t.*,rownum rn from (select * from RAILWAY t where 1=1 ");
        if(railwayCondition.getName()!=null&&!"".equals(railwayCondition.getName())){
            builder.append(" and t.name like concat(concat('%',#{name}),'%')");
        }
        if(railwayCondition.getRailwayClass()!=null&&!"".equals(railwayCondition.getRailwayClass())){
            builder.append(" and t.class like concat(concat('%',#{name}),'%')");
        }

        builder.append(" and rownum<=#{top})t) t where t.rn >#{bottom}");

        return builder.toString();
    }

    //获取道路等级下拉列表
    public String getRailwayClassList(){
        StringBuilder builder =new StringBuilder("select distinct t.class as railway_class from RAILWAY t");
        return builder.toString();
    }
}
