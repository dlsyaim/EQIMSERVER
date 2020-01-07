package com.gisinfo.sand.queryGeographyInfo.geographyData.provider;

import com.gisinfo.sand.queryGeographyInfo.geographyData.condition.ShelterCondition;

//避难所构建sql类
public class ShelterProvider {

    //查询总记录数
    public String getShelterCount(ShelterCondition shelterCondition){
        StringBuilder builder =new StringBuilder("select count(1) count from CITY_SITE t where 1=1");
        if(shelterCondition.getShelterName()!=null&&!"".equals(shelterCondition.getShelterName())){
            builder.append(" and t.name like concat(concat('%',#{shelterName}),'%')");
        }
        if(shelterCondition.getShelterClass()!=null&&!"".equals(shelterCondition.getShelterClass())){
            builder.append(" and t.class like concat(concat('%',#{shelterClass}),'%')");
        }
        return builder.toString();
    }

    //查询数据列表
    public String getShelterList(ShelterCondition shelterCondition){
        StringBuilder builder =new StringBuilder("select * from(select t.*,rownum rn from (select " +
                "t.objectid,t.name as shelterName,t.class as shelterClass," +
                "t.AREA_ as shelterArfa,t.USEAGE as shelterUseage from CITY_SITE t where 1=1 ");
        if(shelterCondition.getShelterName()!=null&&!"".equals(shelterCondition.getShelterName())){
            builder.append(" and t.name like concat(concat('%',#{shelterName}),'%')");
        }
        if(shelterCondition.getShelterClass()!=null&&!"".equals(shelterCondition.getShelterClass())){
            builder.append(" and t.class like concat(concat('%',#{shelterClass}),'%')");
        }

        builder.append(" and rownum<=#{top})t) t where t.rn >#{bottom}");

        return builder.toString();
    }

    //获取类别下拉列表
    public String getShelterClassList(){
        StringBuilder builder =new StringBuilder("select distinct t.class as shelterClass from CITY_SITE t where t.class is not null");
        return builder.toString();
    }
    
}
