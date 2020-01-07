package com.gisinfo.sand.queryGeographyInfo.geographyData.provider;

import com.gisinfo.sand.queryGeographyInfo.geographyData.condition.LargeOilgasPipelineCondition;

//大型油气管线构建sql类
public class LargeOilgasPipelineProvider {

    //查询总记录数
    public String getLargeOilgasPipelineCount(LargeOilgasPipelineCondition LargeOilgasPipelineCondition){
        StringBuilder builder =new StringBuilder("select count(1) count from PETROLINE t where 1=1");
        if(LargeOilgasPipelineCondition.getPipelineName()!=null&&!"".equals(LargeOilgasPipelineCondition.getPipelineName())){
            builder.append(" and t.name like concat(concat('%',#{pipelineName}),'%')");
        }
        if(LargeOilgasPipelineCondition.getFeature()!=null&&!"".equals(LargeOilgasPipelineCondition.getFeature())){
            builder.append(" and t.FEATURE like concat(concat('%',#{feature}),'%')");
        }
        return builder.toString();
    }

    //查询数据列表
    public String getLargeOilgasPipelineList(LargeOilgasPipelineCondition LargeOilgasPipelineCondition){
        StringBuilder builder =new StringBuilder("select * from(select t.*,rownum rn from (select " +
                "t.objectid,t.name as pipelineName,t.NOTE_ as note,t.LOCATION as location," +
                "t.FEATURE as feature,t.BUILT_ERA as builtEra from PETROLINE t where 1=1 ");
        if(LargeOilgasPipelineCondition.getPipelineName()!=null&&!"".equals(LargeOilgasPipelineCondition.getPipelineName())){
            builder.append(" and t.name like concat(concat('%',#{pipelineName}),'%')");
        }
        if(LargeOilgasPipelineCondition.getFeature()!=null&&!"".equals(LargeOilgasPipelineCondition.getFeature())){
            builder.append(" and t.FEATURE like concat(concat('%',#{feature}),'%')");
        }
        builder.append(" and rownum<=#{top})t) t where t.rn >#{bottom}");

        return builder.toString();
    }

    //获取类别下拉列表
    public String getLargeOilgasPipelineClassList(){
        StringBuilder builder =new StringBuilder("select distinct t.FEATURE as feature from PETROLINE t where t.FEATURE is not null");
        return builder.toString();
    }
}
