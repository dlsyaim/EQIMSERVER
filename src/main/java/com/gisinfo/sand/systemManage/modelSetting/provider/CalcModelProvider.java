package com.gisinfo.sand.systemManage.modelSetting.provider;

import java.util.Map;

//构建计算模型所需sql
public class CalcModelProvider {
    //根据地震id获取叠加分析数据类型
    public String getDataType(String earthquakeId){
        StringBuilder builder = new StringBuilder("select  t.ANALYSIS_DATA from T_EARTHQUAKE_INFO t where t.featid = #{earthquakeId}");
        return builder.toString();
    }

    //根据数据类型查询不同的叠加分析表数据
    public String getAnalysisData(Map<String,Object> params){
        String dataType = params.get("dataType").toString();
        StringBuilder builder = new StringBuilder("select * from ");
        if("town".equals(dataType)){
            builder.append("T_ANALYSIS_TOWN");
        }else if("grid".equals(dataType)){
            builder.append("T_ANALYSIS_GRID");
        }else if("community".equals(dataType)){
            builder.append("T_ANALYSIS_VILLAGE");
        }
        builder.append(" where batch_number = #{batchNumber}");
        return builder.toString();
    }
}
