package com.gisinfo.sand.queryGeographyInfo.geographyData.provider;


import com.gisinfo.sand.queryGeographyInfo.geographyData.condition.TEarthquakeInfoCondition;

//地震触发列表构建sql类
public class TEarthquakeInfoProvider {

    //查询总记录数
    public String getTEarthquakeInfoCount(TEarthquakeInfoCondition tEarthquakeInfoCondition){
        StringBuilder builder =new StringBuilder("select count(1) count from T_EARTHQUAKE_INFO t where 1=1");
        return builder.toString();
    }

    //查询数据列表
    public String getTEarthquakeInfoList(TEarthquakeInfoCondition tEarthquakeInfoCondition){
        StringBuilder builder =new StringBuilder("SELECT a.* FROM T_EARTHQUAKE_INFO a  ORDER BY EARTHQUAKE_TIME DESC ");
//        StringBuilder builder =new StringBuilder("select * from(select t.*,rownum rn from (select * from T_EARTHQUAKE_INFO t where 1=1 ");

//        builder.append(" and rownum<=#{top})t) t where t.rn >#{bottom}");

        return builder.toString();
    }
    //查询数据列表
    public String getTEarthquakeId(TEarthquakeInfoCondition tEarthquakeInfoCondition){
        StringBuilder builder =new StringBuilder("SELECT DISTINCT a.EARTHQUAKE_NAME as EARTHQUAKE_NAME,to_char(a.EARTHQUAKE_TIME,'yyyy-MM-dd') as EARTHQUAKE_TIME,d.EMERGENCY_LEVEL as EMERGENCY_LEVEL FROM T_EARTHQUAKE_INFO a  inner join T_EARTHQUAKE_DETAIL d on a.FEATID = d.EARTHQUAKE_FEATID  WHERE 1=1 ");
        if(tEarthquakeInfoCondition.getFeatid()!=null&&!"".equals(tEarthquakeInfoCondition.getFeatid())){
            builder.append(" and a.FEATID = #{featid}");
        } else {
            builder.append(" and ROWNUM <= 1 ORDER BY EARTHQUAKE_TIME DESC");
        }

        return builder.toString();
    }


}
