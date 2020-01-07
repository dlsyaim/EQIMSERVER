package com.gisinfo.sand.queryGeographyInfo.geographyData.provider;

import com.gisinfo.sand.queryGeographyInfo.geographyData.condition.MetroStationCondition;

//地铁站构建sql类
public class MetroStationProvider {
    //查询总记录数
    public String getMetroStationCount(MetroStationCondition metroStationCondition){
        StringBuilder builder =new StringBuilder("select count(1) count from RAIL_STATION t where 1=1");
        if(metroStationCondition.getMetroStationName()!=null&&!"".equals(metroStationCondition.getMetroStationName())){
            builder.append(" and t.name like concat(concat('%',#{metroStationName}),'%')");
        }
        return builder.toString();
    }

    //查询数据列表
    public String getMetroStationList(MetroStationCondition metroStationCondition){
        StringBuilder builder =new StringBuilder("select * from(select t.*,rownum rn from (select " +
                "t.objectid,t.name as metroStationName,t.LINEBELONG as linebelong,t.SIMPLENAME as simplename," +
                "t.CHANGENAME as changename,t.CHANGETYPE as changetype,t.SXSTARTTIM as sxstarttime," +
                "t.SXENDTIME as sxendtime,t.XXSTARTTIM as xxstarttime,t.XXENDTIME as xxendtime from RAIL_STATION t where 1=1 ");
        if(metroStationCondition.getMetroStationName()!=null&&!"".equals(metroStationCondition.getMetroStationName())){
            builder.append(" and t.name like concat(concat('%',#{metroStationName}),'%')");
        }
        builder.append(" and rownum<=#{top})t) t where t.rn >#{bottom}");

        return builder.toString();
    }
}
