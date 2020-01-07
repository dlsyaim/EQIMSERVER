package com.gisinfo.sand.queryGeographyInfo.geographyData.provider;

import com.gisinfo.sand.queryGeographyInfo.geographyData.condition.RockCondition;
import com.gisinfo.sand.queryGeographyInfo.geographyData.condition.StratigraphyCondition;

//构造查询岩体相关数据的sql
public class RockProvider {
    //根据条件查询数据
    public String getRocklist(RockCondition rockCondition){
        StringBuilder builder =new StringBuilder("select * from(select t.*,rownum rn from (select * from rock t where 1=1 ");
        if(rockCondition.getUnitName()!=null&&!"".equals(rockCondition.getUnitName())){
            builder.append(" and t.UNITNAME like concat(concat('%',#{unitName}),'%')");
        }
        if(rockCondition.getCharacter()!=null&&!"".equals(rockCondition.getCharacter())){
            builder.append(" and t.CHARACTER_ like concat(concat('%',#{character}),'%')");
        }

        builder.append(" and rownum<=#{top})t) t where t.rn >#{bottom}");

        return builder.toString();
    }

    //根据条件查询总记录数
    public String getRockcount(RockCondition rockCondition){
        StringBuilder builder =new StringBuilder("select count(1) count from rock t where 1=1");
        if(rockCondition.getUnitName()!=null&&!"".equals(rockCondition.getUnitName())){
            builder.append(" and t.UNITNAME like concat(concat('%',#{unitName}),'%')");
        }
        if(rockCondition.getCharacter()!=null&&!"".equals(rockCondition.getCharacter())){
            builder.append(" and t.CHARACTER_ like concat(concat('%',#{character}),'%')");
        }

        return builder.toString();

    }
}
