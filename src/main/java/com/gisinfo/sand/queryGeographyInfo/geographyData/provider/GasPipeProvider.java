package com.gisinfo.sand.queryGeographyInfo.geographyData.provider;

import com.gisinfo.sand.queryGeographyInfo.geographyData.condition.GasPipeCondition;

//燃气管网构建sql类
public class GasPipeProvider {
    //查询总记录数
    public String getGasPipeCount(GasPipeCondition gasPipeCondition){
        StringBuilder builder =new StringBuilder("select count(1) count from GAS_PIPELINE_NETWORK t where 1=1");
        if(gasPipeCondition.getGaspipeName()!=null&&!"".equals(gasPipeCondition.getGaspipeName())){
            builder.append(" and t.name like concat(concat('%',#{gaspipeName}),'%')");
        }
        if(gasPipeCondition.getGaspipematerial()!=null&&!"".equals(gasPipeCondition.getGaspipematerial())){
            builder.append(" and t.MATERIAL like concat(concat('%',#{gaspipematerial}),'%')");
        }
        return builder.toString();
    }

    //查询数据列表
    public String getGasPipeList(GasPipeCondition gasPipeCondition){
        StringBuilder builder =new StringBuilder("select * from(select t.*,rownum rn from (select * from GAS_PIPELINE_NETWORK t where 1=1 ");
        if(gasPipeCondition.getGaspipeName()!=null&&!"".equals(gasPipeCondition.getGaspipeName())){
            builder.append(" and t.name like concat(concat('%',#{gaspipeName}),'%')");
        }
        if(gasPipeCondition.getGaspipematerial()!=null&&!"".equals(gasPipeCondition.getGaspipematerial())){
            builder.append(" and t.MATERIAL like concat(concat('%',#{gaspipematerial}),'%')");
        }

        builder.append(" and rownum<=#{top})t) t where t.rn >#{bottom}");

        return builder.toString();
    }

    //获取类别下拉列表
    public String getGaspipeMaterialList(){
        StringBuilder builder =new StringBuilder("select distinct t.MATERIAL as gaspipematerial from GAS_PIPELINE_NETWORK t where t.MATERIAL is not null");
        return builder.toString();
    }
}
