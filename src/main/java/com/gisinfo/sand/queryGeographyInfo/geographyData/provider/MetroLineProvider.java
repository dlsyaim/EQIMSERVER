package com.gisinfo.sand.queryGeographyInfo.geographyData.provider;

import com.gisinfo.sand.queryGeographyInfo.geographyData.condition.MetroLineCondition;

//地铁线路构建sql类
public class MetroLineProvider {
    //查询总记录数
    public String getMetroLineCount(MetroLineCondition metroLineCondition){
        StringBuilder builder =new StringBuilder("select count(1) count from TRACK_LINE t where 1=1");
        if(metroLineCondition.getTrackName()!=null&&!"".equals(metroLineCondition.getTrackName())){
            builder.append(" and t.TRACK_NAME like concat(concat('%',#{trackName}),'%')");
        }
        return builder.toString();
    }

    //查询数据列表
    public String getMetroLineList(MetroLineCondition metroLineCondition){
        StringBuilder builder =new StringBuilder("select * from(select t.*,rownum rn from (select *  from TRACK_LINE t where 1=1 ");
        if(metroLineCondition.getTrackName()!=null&&!"".equals(metroLineCondition.getTrackName())){
            builder.append(" and t.TRACK_NAME like concat(concat('%',#{trackName}),'%')");
        }
        builder.append(" and rownum<=#{top})t) t where t.rn >#{bottom}");

        return builder.toString();
    }

}
