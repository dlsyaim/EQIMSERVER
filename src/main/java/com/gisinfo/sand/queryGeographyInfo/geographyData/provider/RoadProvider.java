package com.gisinfo.sand.queryGeographyInfo.geographyData.provider;

import com.gisinfo.sand.queryGeographyInfo.geographyData.condition.RoadCondition;

//道路构造sql类
public class RoadProvider {
    //查询总记录数
    public String getRoadCount(RoadCondition roadCondition){
        StringBuilder builder =new StringBuilder("select count(1) count from ROAD t where 1=1");
        if(roadCondition.getRoadName()!=null&&!"".equals(roadCondition.getRoadName())){
            builder.append(" and t.name like concat(concat('%',#{roadName}),'%')");
        }
        if(roadCondition.getRoadClass()!=null&&!"".equals(roadCondition.getRoadClass())){
            builder.append(" and t.class like concat(concat('%',#{roadClass}),'%')");
        }

        return builder.toString();
    }

    //查询数据列表
    public String getRoadList(RoadCondition roadCondition){
        StringBuilder builder =new StringBuilder("select * from(select t.*,rownum rn from (select " +
                "t.objectid as objectId,t.name as roadName,t.class as roadClass," +
                "t.cover as roadCover,t.length as roadLength,t.width as roadWidth," +
                "t.capacity as roadCapacity,t.note_ as roadNote  from ROAD t where 1=1 ");
        if(roadCondition.getRoadName()!=null&&!"".equals(roadCondition.getRoadName())){
            builder.append(" and t.name like concat(concat('%',#{roadName}),'%')");
        }
        if(roadCondition.getRoadClass()!=null&&!"".equals(roadCondition.getRoadClass())){
            builder.append(" and t.class like concat(concat('%',#{roadClass}),'%')");
        }

        builder.append(" and rownum<=#{top})t) t where t.rn >#{bottom}");

        return builder.toString();
    }

    //获取道路等级下拉列表
    public String getRoadClassList(){
        StringBuilder builder =new StringBuilder("select distinct t.class as road_class from ROAD t");
        return builder.toString();
    }
}
