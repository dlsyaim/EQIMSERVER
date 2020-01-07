package com.gisinfo.sand.queryGeographyInfo.geographyData.provider;

import com.gisinfo.sand.queryGeographyInfo.geographyData.condition.FaultCondition;

//构造断裂相关sql
public class FaultProvider {
    //根据条件查询数据
    public String getFaultlist(FaultCondition faultCondition){
        StringBuilder builder =new StringBuilder("select * from(select t.*,rownum rn from (select " +
                "t.objectid as objectId,t.attr as faultAttr,t.name as faultName,t.character_ from fault t where 1=1 ");
        if(faultCondition.getFaultAttr()!=null&&!"".equals(faultCondition.getFaultAttr())){
            builder.append(" and t.attr like concat(concat('%',#{faultAttr}),'%')");
        }
        if(faultCondition.getFaultName()!=null&&!"".equals(faultCondition.getFaultName())){
            builder.append(" and t.name like concat(concat('%',#{faultName}),'%')");
        }

        builder.append(" and rownum<=#{top})t) t where t.rn >#{bottom}");

        return builder.toString();
    }

    //根据条件查询总记录数
    public String getFaultcount(FaultCondition faultCondition){
        StringBuilder builder =new StringBuilder("select count(1) count from fault t where 1=1");
        if(faultCondition.getFaultAttr()!=null&&!"".equals(faultCondition.getFaultAttr())){
            builder.append(" and t.attr like concat(concat('%',#{faultAttr}),'%')");
        }
        if(faultCondition.getFaultName()!=null&&!"".equals(faultCondition.getFaultName())){
            builder.append(" and t.name like concat(concat('%',#{faultName}),'%')");
        }

        return builder.toString();

    }
}
