package com.gisinfo.sand.queryGeographyInfo.geographyData.provider;

import com.gisinfo.sand.queryGeographyInfo.geographyData.condition.From1970ToCurrentEQcondition;

//构造获取1970以来小震相关数据的sql对象
public class From1970ToCurrentEQprovider {
    //根据条件查询数据
    public String getFrom1970ToCurrentEQlist(From1970ToCurrentEQcondition from1970ToCurrentEQcondition){
        StringBuilder builder =new StringBuilder("select * from(select t.*,rownum rn from (select * from INSTRUMENT_CATALOG t where 1=1 ");
        if(from1970ToCurrentEQcondition.getPlaceName()!=null&&!"".equals(from1970ToCurrentEQcondition.getPlaceName())){
            builder.append(" and t.LOCATION like concat(concat('%',#{placeName}),'%')");
        }
        if(from1970ToCurrentEQcondition.getMinMagnitude()!=null&&!"".equals(from1970ToCurrentEQcondition.getMinMagnitude())){
            builder.append(" and t.MAGNITUDE >= #{minMagnitude}");
        }
        if(from1970ToCurrentEQcondition.getMaxMagnitude()!=null&&!"".equals(from1970ToCurrentEQcondition.getMaxMagnitude())){
            builder.append(" and t.MAGNITUDE <= #{maxMagnitude}");
        }
        builder.append(" and rownum<=#{top})t) t where t.rn >#{bottom}");

        return builder.toString();
    }

    //根据条件查询总记录数
    public String getFrom1970ToCurrentEQcount(From1970ToCurrentEQcondition from1970ToCurrentEQcondition){
        StringBuilder builder =new StringBuilder("select count(1) count from INSTRUMENT_CATALOG t where 1=1");
        if(from1970ToCurrentEQcondition.getPlaceName()!=null&&!"".equals(from1970ToCurrentEQcondition.getPlaceName())){
            builder.append(" and t.LOCATION like concat(concat('%',#{placeName}),'%')");
        }
        if(from1970ToCurrentEQcondition.getMinMagnitude()!=null&&!"".equals(from1970ToCurrentEQcondition.getMinMagnitude())){
            builder.append(" and t.MAGNITUDE >= #{minMagnitude}");
        }
        if(from1970ToCurrentEQcondition.getMaxMagnitude()!=null&&!"".equals(from1970ToCurrentEQcondition.getMaxMagnitude())){
            builder.append(" and t.MAGNITUDE <= #{maxMagnitude}");
        }

        return builder.toString();

    }
}
