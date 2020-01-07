package com.gisinfo.sand.queryGeographyInfo.geographyData.provider;

import com.gisinfo.sand.queryGeographyInfo.geographyData.condition.DetachedBuildingCondition;

//独立建筑构建sql类
public class DetachedBuildingProvider {

    //查询总记录数
    public String getDetachedBuildingCount(DetachedBuildingCondition detachedBuildingCondition){
        StringBuilder builder =new StringBuilder("select count(1) count from SINGLE_BUILDING t where 1=1");
        if(detachedBuildingCondition.getBuildingName()!=null&&!"".equals(detachedBuildingCondition.getBuildingName())){
            builder.append(" and t.BUILDING_NAME like concat(concat('%',#{buildingName}),'%')");
        }
        if(detachedBuildingCondition.getBuildingType()!=null&&!"".equals(detachedBuildingCondition.getBuildingType())){
            builder.append(" and t.BUILDING_TYPE like concat(concat('%',#{buildingType}),'%')");
        }


        return builder.toString();
    }

    //查询数据列表
    public String getDetachedBuildingList(DetachedBuildingCondition detachedBuildingCondition){
        StringBuilder builder =new StringBuilder("select * from(select t.*,rownum rn from (select " +
                "t.objectid,t.BUILDING_NAME as buildingName,t.use,t.YEAR_ as year," +
                "t.STORY_NUMBER as storyNumber,t.BUILDING_TYPE as buildingType,t.height from SINGLE_BUILDING t where 1=1 ");
        if(detachedBuildingCondition.getBuildingName()!=null&&!"".equals(detachedBuildingCondition.getBuildingName())){
            builder.append(" and t.BUILDING_NAME like concat(concat('%',#{buildingName}),'%')");
        }
        if(detachedBuildingCondition.getBuildingType()!=null&&!"".equals(detachedBuildingCondition.getBuildingType())){
            builder.append(" and t.BUILDING_TYPE like concat(concat('%',#{buildingType}),'%')");
        }

        builder.append(" and rownum<=#{top})t) t where t.rn >#{bottom}");

        return builder.toString();
    }

    //获取类别下拉列表
    public String getDetachedBuildingTypeList(){
        StringBuilder builder =new StringBuilder("select distinct t.BUILDING_TYPE as buildingType from SINGLE_BUILDING t where t.BUILDING_TYPE is not null");
        return builder.toString();
    }

}
