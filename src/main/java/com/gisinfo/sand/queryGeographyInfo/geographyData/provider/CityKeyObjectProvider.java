package com.gisinfo.sand.queryGeographyInfo.geographyData.provider;

import com.gisinfo.sand.queryGeographyInfo.geographyData.condition.CityKeyObjectCondition;

//城市主要目标构建sql类
public class CityKeyObjectProvider {

    //查询总记录数
    public String getCityKeyObjectCount(CityKeyObjectCondition cityKeyObjectCondition){
        StringBuilder builder =new StringBuilder("select count(1) count from CITY_KEYOBJECT t where 1=1");
        if(cityKeyObjectCondition.getCitykeyName()!=null&&!"".equals(cityKeyObjectCondition.getCitykeyName())){
            builder.append(" and t.name like concat(concat('%',#{citykeyName}),'%')");
        }
        if(cityKeyObjectCondition.getCitykeyClass()!=null&&!"".equals(cityKeyObjectCondition.getCitykeyClass())){
            builder.append(" and t.class like concat(concat('%',#{citykeyClass}),'%')");
        }
        return builder.toString();
    }

    //查询数据列表
    public String getCityKeyObjectList(CityKeyObjectCondition cityKeyObjectCondition){
        StringBuilder builder =new StringBuilder("select * from(select t.*,rownum rn from (select " +
                "t.objectid,t.name as citykeyName,t.class as citykeyClass," +
                "t.NOTE_ as citykeyNote_,t.POSTCODE as citykeyPostcode from CITY_KEYOBJECT t where 1=1 ");
        if(cityKeyObjectCondition.getCitykeyName()!=null&&!"".equals(cityKeyObjectCondition.getCitykeyName())){
            builder.append(" and t.name like concat(concat('%',#{citykeyName}),'%')");
        }
        if(cityKeyObjectCondition.getCitykeyClass()!=null&&!"".equals(cityKeyObjectCondition.getCitykeyClass())){
            builder.append(" and t.class like concat(concat('%',#{citykeyClass}),'%')");
        }

        builder.append(" and rownum<=#{top})t) t where t.rn >#{bottom}");

        return builder.toString();
    }

    //获取类别下拉列表
    public String getCityKeyObjectClassList(){
        StringBuilder builder =new StringBuilder("select distinct t.class as citykeyClass from CITY_KEYOBJECT t where t.class is not null");
        return builder.toString();
    }

}
