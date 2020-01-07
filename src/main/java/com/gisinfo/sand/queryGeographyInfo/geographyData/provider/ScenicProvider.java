package com.gisinfo.sand.queryGeographyInfo.geographyData.provider;

import com.gisinfo.sand.queryGeographyInfo.geographyData.condition.ScenicCondition;

//旅游景区构建sql类
public class ScenicProvider {

    //查询总记录数
    public String getScenicCount(ScenicCondition scenicCondition){
        StringBuilder builder =new StringBuilder("select count(1) count from TOURISM_SPOT t where 1=1");
        if(scenicCondition.getScenicName()!=null&&!"".equals(scenicCondition.getScenicName())){
            builder.append(" and t.name like concat(concat('%',#{scenicName}),'%')");
        }
        if(scenicCondition.getScenicType()!=null&&!"".equals(scenicCondition.getScenicType())){
            builder.append(" and t.type like concat(concat('%',#{scenicType}),'%')");
        }
        return builder.toString();
    }

    //查询数据列表
    public String getScenicList(ScenicCondition scenicCondition){
        StringBuilder builder =new StringBuilder("select * from(select t.*,rownum rn from (select " +
                "t.objectid,t.name as ScenicName,t.type as scenicType," +
                "t.POSTCODE as scenicPostcode,t.NOTE_ as scenicNote from TOURISM_SPOT t where 1=1 ");
        if(scenicCondition.getScenicName()!=null&&!"".equals(scenicCondition.getScenicName())){
            builder.append(" and t.name like concat(concat('%',#{scenicName}),'%')");
        }
        if(scenicCondition.getScenicType()!=null&&!"".equals(scenicCondition.getScenicType())){
            builder.append(" and t.type like concat(concat('%',#{scenicType}),'%')");
        }

        builder.append(" and rownum<=#{top})t) t where t.rn >#{bottom}");

        return builder.toString();
    }

    //获取类别下拉列表
    public String getScenicTypeList(){
        StringBuilder builder =new StringBuilder("select distinct t.type as scenicType from TOURISM_SPOT t where t.type is not null");
        return builder.toString();
    }
    
}
