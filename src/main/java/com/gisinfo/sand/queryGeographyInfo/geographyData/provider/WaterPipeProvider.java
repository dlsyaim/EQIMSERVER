package com.gisinfo.sand.queryGeographyInfo.geographyData.provider;

import com.gisinfo.sand.queryGeographyInfo.geographyData.condition.WaterPipeCondition;

//供水主干管网构建sql类
public class WaterPipeProvider {
    //查询总记录数
    public String getWaterPipeCount(WaterPipeCondition waterPipeCondition){
        StringBuilder builder =new StringBuilder("select count(1) count from MAIN_WATER_SUPPLY_NETWORK t where 1=1");
        if(waterPipeCondition.getWaterpipemateial()!=null&&!"".equals(waterPipeCondition.getWaterpipemateial())){
            builder.append(" and t.MATERIAL like concat(concat('%',#{waterpipemateial}),'%')");
        }
        if(waterPipeCondition.getWaterpipeClass()!=null&&!"".equals(waterPipeCondition.getWaterpipeClass())){
            builder.append(" and t.class like concat(concat('%',#{waterpipeClass}),'%')");
        }
        return builder.toString();
    }

    //查询数据列表
    public String getWaterPipeList(WaterPipeCondition waterPipeCondition){
        StringBuilder builder =new StringBuilder("select * from(select t.*,rownum rn from (select * from MAIN_WATER_SUPPLY_NETWORK t where 1=1 ");
        if(waterPipeCondition.getWaterpipemateial()!=null&&!"".equals(waterPipeCondition.getWaterpipemateial())){
            builder.append(" and t.MATERIAL like concat(concat('%',#{waterpipemateial}),'%')");
        }
        if(waterPipeCondition.getWaterpipeClass()!=null&&!"".equals(waterPipeCondition.getWaterpipeClass())){
            builder.append(" and t.class like concat(concat('%',#{waterpipeClass}),'%')");
        }

        builder.append(" and rownum<=#{top})t) t where t.rn >#{bottom}");

        return builder.toString();
    }

    //获取类别下拉列表
    public String getWaterPipeClassList(){
        StringBuilder builder =new StringBuilder("select distinct t.class as waterpipeClass from MAIN_WATER_SUPPLY_NETWORK t where t.class is not null");
        return builder.toString();
    }

    //获取材料等级下拉列表
    public String getWaterpipeMateialList(){
        StringBuilder builder =new StringBuilder("select distinct t.MATERIAL as waterpipemateial from MAIN_WATER_SUPPLY_NETWORK t where t.MATERIAL is not null");
        return builder.toString();
    }
}
