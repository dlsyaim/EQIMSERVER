package com.gisinfo.sand.queryGeographyInfo.geographyData.provider;

import com.gisinfo.sand.queryGeographyInfo.geographyData.condition.AirportContition;

//机场构造sql类
public class AirportProvider {
    //根据条件查询数据
    public String getAirportlist(AirportContition airportContition){
        StringBuilder builder =new StringBuilder("select * from(select t.*,rownum rn from (select " +
                "t.objectid as objectId,t.name as airportName,t.postcode," +
                "t.location,t.other,t.civil as isCivil,t.plane,t.note from AIRPORT t where 1=1 ");
        if(airportContition.getAirportName()!=null&&!"".equals(airportContition.getAirportName())){
            builder.append(" and t.name like concat(concat('%',#{airportName}),'%')");
        }

        builder.append(" and rownum<=#{top})t) t where t.rn >#{bottom}");

        return builder.toString();
    }

    //根据条件查询总记录数
    public String getAirportCount(AirportContition airportContition){
        StringBuilder builder =new StringBuilder("select count(1) count from AIRPORT t where 1=1");
        if(airportContition.getAirportName()!=null&&!"".equals(airportContition.getAirportName())){
            builder.append(" and t.name like concat(concat('%',#{airportName}),'%')");
        }

        return builder.toString();

    }
}
