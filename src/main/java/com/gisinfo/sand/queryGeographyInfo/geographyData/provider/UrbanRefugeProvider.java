package com.gisinfo.sand.queryGeographyInfo.geographyData.provider;

import com.gisinfo.sand.queryGeographyInfo.geographyData.condition.UrbanRefugeCondition;

//城市避难所构建sql类
public class UrbanRefugeProvider {

    //查询总记录数
    public String getUrbanRefugeCount(UrbanRefugeCondition urbanRefugeCondition){
        StringBuilder builder =new StringBuilder("select count(1) count from urban_shelters t where 1=1");
        if(urbanRefugeCondition.getRef()!=null&&!"".equals(urbanRefugeCondition.getRef())){
            builder.append(" and t.ref like concat(concat('%',#{ref}),'%')");
        }
        if(urbanRefugeCondition.getType()!=null&&!"".equals(urbanRefugeCondition.getType())){
            builder.append(" and t.type like concat(concat('%',#{type}),'%')");
        }
        if(urbanRefugeCondition.getCit()!=null&&!"".equals(urbanRefugeCondition.getCit())){
            builder.append(" and t.cit like concat(concat('%',#{cit}),'%')");
        }

        return builder.toString();
    }

    //查询数据列表
    public String getUrbanRefugeList(UrbanRefugeCondition urbanRefugeCondition){
        StringBuilder builder =new StringBuilder("select * from(select t.*,rownum rn from (select * from urban_shelters t where 1=1 ");
        if(urbanRefugeCondition.getRef()!=null&&!"".equals(urbanRefugeCondition.getRef())){
            builder.append(" and t.ref like concat(concat('%',#{ref}),'%')");
        }
        if(urbanRefugeCondition.getType()!=null&&!"".equals(urbanRefugeCondition.getType())){
            builder.append(" and t.type like concat(concat('%',#{type}),'%')");
        }
        if(urbanRefugeCondition.getCit()!=null&&!"".equals(urbanRefugeCondition.getCit())){
            builder.append(" and t.cit like concat(concat('%',#{cit}),'%')");
        }

        builder.append(" and rownum<=#{top})t) t where t.rn >#{bottom}");

        return builder.toString();
    }

    //获取类别下拉列表
    public String getUrbanRefugeTypeList(){
        StringBuilder builder =new StringBuilder("select distinct t.type from urban_shelters t where t.type is not null");
        return builder.toString();
    }

    //获取桥梁等级下拉列表
    public String getUrbanRefugeCitList(){
        StringBuilder builder =new StringBuilder("select distinct t.cit from urban_shelters t where t.cit is not null");
        return builder.toString();
    }
    
}
