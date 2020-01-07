package com.gisinfo.sand.queryGeographyInfo.geographyData.provider;

import com.gisinfo.sand.queryGeographyInfo.geographyData.condition.HistoricalEQcondition;

public class HistoricalProvider {
    //根据条件查询数据
    public String getHistoricalEQlist(HistoricalEQcondition historicalEQcondition){
        StringBuilder builder =new StringBuilder("select * from(select t.*,rownum rn from (select * from strong_catalog t where 1=1 ");
        if(historicalEQcondition.getPlaceName()!=null&&!"".equals(historicalEQcondition.getPlaceName())){
            builder.append(" and t.LOCATION like concat(concat('%',#{placeName}),'%')");
        }
        if(historicalEQcondition.getMinMangitude()!=null&&!"".equals(historicalEQcondition.getMinMangitude())){
            builder.append(" and t.MAGNITUDE >= #{minMangitude}");
        }
        if(historicalEQcondition.getMaxMangitude()!=null&&!"".equals(historicalEQcondition.getMaxMangitude())){
            builder.append(" and t.MAGNITUDE <= #{maxMangitude}");
        }
        builder.append(" and rownum<=#{top})t) t where t.rn >#{bottom}");

        return builder.toString();
    }

    //根据条件查询总记录数
    public String getHistoricalEQCount(HistoricalEQcondition historicalEQcondition){
        StringBuilder builder =new StringBuilder("select count(1) count from strong_catalog t where 1=1");
        if(historicalEQcondition.getPlaceName()!=null&&!"".equals(historicalEQcondition.getPlaceName())){
            builder.append(" and t.LOCATION like concat(concat('%',#{placeName}),'%')");
        }
        if(historicalEQcondition.getMinMangitude()!=null&&!"".equals(historicalEQcondition.getMinMangitude())){
            builder.append(" and t.MAGNITUDE >= #{minMangitude}");
        }
        if(historicalEQcondition.getMaxMangitude()!=null&&!"".equals(historicalEQcondition.getMaxMangitude())){
            builder.append(" and t.MAGNITUDE <= #{maxMangitude}");
        }

        return builder.toString();

    }
}
