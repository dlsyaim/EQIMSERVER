package com.gisinfo.sand.queryGeographyInfo.geographyData.provider;
import com.gisinfo.sand.queryGeographyInfo.geographyData.condition.StratigraphyCondition;

//构造查询地层相关数据的sql
public class StratigraphyProvider {
    //根据条件查询数据
    public String getStratigraphyList(StratigraphyCondition stratigraphyCondition){
        StringBuilder builder =new StringBuilder("select * from(select t.*,rownum rn from (select * from stratigraphy t where 1=1 ");
        if(stratigraphyCondition.getUnitName()!=null&&!"".equals(stratigraphyCondition.getUnitName())){
            builder.append(" and t.UNITNAME like concat(concat('%',#{unitName}),'%')");
        }
        if(stratigraphyCondition.getCharacter()!=null&&!"".equals(stratigraphyCondition.getCharacter())){
            builder.append(" and t.CHARACTER_ like concat(concat('%',#{character}),'%')");
        }

        builder.append(" and rownum<=#{top})t) t where t.rn >#{bottom}");

        return builder.toString();
    }

    //根据条件查询总记录数
    public String getStratigraphycount(StratigraphyCondition stratigraphyCondition){
        StringBuilder builder =new StringBuilder("select count(1) count from stratigraphy t where 1=1");
        if(stratigraphyCondition.getUnitName()!=null&&!"".equals(stratigraphyCondition.getUnitName())){
            builder.append(" and t.UNITNAME like concat(concat('%',#{unitName}),'%')");
        }
        if(stratigraphyCondition.getCharacter()!=null&&!"".equals(stratigraphyCondition.getCharacter())){
            builder.append(" and t.CHARACTER_ like concat(concat('%',#{character}),'%')");
        }

        return builder.toString();

    }
}
