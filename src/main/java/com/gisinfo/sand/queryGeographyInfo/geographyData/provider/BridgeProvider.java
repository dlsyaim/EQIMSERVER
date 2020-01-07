package com.gisinfo.sand.queryGeographyInfo.geographyData.provider;

import com.gisinfo.sand.queryGeographyInfo.geographyData.condition.BridgeCondition;

//桥梁构建sql类
public class BridgeProvider {
    //查询总记录数
    public String getBridgeCount(BridgeCondition bridgeCondition){
        StringBuilder builder =new StringBuilder("select count(1) count from BRIDGE t where 1=1");
        if(bridgeCondition.getBridgeName()!=null&&!"".equals(bridgeCondition.getBridgeName())){
            builder.append(" and t.name like concat(concat('%',#{bridgeName}),'%')");
        }
        if(bridgeCondition.getBridgeClass()!=null&&!"".equals(bridgeCondition.getBridgeClass())){
            builder.append(" and t.class like concat(concat('%',#{bridgeClass}),'%')");
        }
        if(bridgeCondition.getBridgeGrade()!=null&&!"".equals(bridgeCondition.getBridgeGrade())){
            builder.append(" and t.grade like concat(concat('%',#{bridgeGrade}),'%')");
        }
        if(bridgeCondition.getBridgeIntensity()!=null&&!"".equals(bridgeCondition.getBridgeIntensity())){
            builder.append(" and t.intensity like concat(concat('%',#{bridgeIntensity}),'%')");
        }

        return builder.toString();
    }

    //查询数据列表
    public String getBridgeList(BridgeCondition bridgeCondition){
        StringBuilder builder =new StringBuilder("select * from(select t.*,rownum rn from (select " +
                "t.objectid,t.name as bridgeName,t.class as bridgeClass," +
                "t.location,t.grade as bridgeGrade,t.length as bridgeLength," +
                "t.width as bridgeWidth,t.max_load,t.intensity,t.structure as bridgeStructure," +
                "t.built_era,t.note_  from BRIDGE t where 1=1 ");
        if(bridgeCondition.getBridgeName()!=null&&!"".equals(bridgeCondition.getBridgeName())){
            builder.append(" and t.name like concat(concat('%',#{bridgeName}),'%')");
        }
        if(bridgeCondition.getBridgeClass()!=null&&!"".equals(bridgeCondition.getBridgeClass())){
            builder.append(" and t.class like concat(concat('%',#{bridgeClass}),'%')");
        }
        if(bridgeCondition.getBridgeGrade()!=null&&!"".equals(bridgeCondition.getBridgeGrade())){
            builder.append(" and t.grade like concat(concat('%',#{bridgeGrade}),'%')");
        }
        if(bridgeCondition.getBridgeIntensity()!=null&&!"".equals(bridgeCondition.getBridgeIntensity())){
            builder.append(" and t.intensity like concat(concat('%',#{bridgeIntensity}),'%')");
        }

        builder.append(" and rownum<=#{top})t) t where t.rn >#{bottom}");

        return builder.toString();
    }

    //获取类别下拉列表
    public String getBridgeClassList(){
        StringBuilder builder =new StringBuilder("select distinct t.class as bridge_class from BRIDGE t where t.class is not null");
        return builder.toString();
    }

    //获取桥梁等级下拉列表
    public String getBridgeGradeList(){
        StringBuilder builder =new StringBuilder("select distinct t.grade as bridge_grade from BRIDGE t where t.grade is not null");
        return builder.toString();
    }
}
