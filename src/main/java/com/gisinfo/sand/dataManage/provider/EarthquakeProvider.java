package com.gisinfo.sand.dataManage.provider;

import com.gisinfo.sand.dataManage.bean.EarthquakeInfo;
import org.apache.ibatis.annotations.Param;

public class EarthquakeProvider {
    public String getPageByQuery(@Param("earthquakeInfo") EarthquakeInfo queryConditions){
        StringBuilder builder = new StringBuilder("select * from(select t.*,rownum rn from (select * from T_EARTHQUAKE_INFO t where 1=1 ");
        if(queryConditions.getEarthquakeName()!=null&&!"".equals(queryConditions.getEarthquakeName())){
            builder.append("and t.earthquake_name like concat(concat('%',#{earthquakeInfo.earthquakeName}),'%')");
        }
        if(queryConditions.getStartTime()!=null&&!"".equals(queryConditions.getStartTime())&&queryConditions.getEndTime()!=null&&!"".equals(queryConditions.getEndTime())){
            builder.append("and t.earthquake_time between to_date(#{earthquakeInfo.startTime},'yyyy-mm-dd HH24:mi:ss') and to_date(#{earthquakeInfo.endTime},'yyyy-mm-dd HH24:mi:ss')");
        }
        if(queryConditions.getEarthquakeLevel()!=null&&!"".equals(queryConditions.getEarthquakeLevel())){
            builder.append("and t.earthquake_level like concat(#{earthquakeInfo.earthquakeLevel},'%')");
        }
        if(queryConditions.getFocalDepth()!=null&&!"".equals(queryConditions.getFocalDepth())){
            builder.append("and t.focal_depth like concat(#{earthquakeInfo.focalDepth},'%')");
        }
        if(queryConditions.getFaultName()!=null&&!"".equals(queryConditions.getFaultName())){
            builder.append("and t.fault_name=#{earthquakeInfo.faultName}");
        }
        if(queryConditions.getDataSource()!=null&&!"".equals(queryConditions.getDataSource())){
            builder.append("and t.data_source=#{earthquakeInfo.dataSource}");
        }
        builder.append(" and rownum<=#{earthquakeInfo.top})t) t where t.rn >#{earthquakeInfo.bottom}");

        return builder.toString();
    }

    public String getEqInfoCountByQuery(@Param("earthquakeInfo") EarthquakeInfo queryConditions){
        StringBuilder builder = new StringBuilder("select count(1) count from T_EARTHQUAKE_INFO t where 1=1 ");
        if(queryConditions.getEarthquakeName()!=null&&!"".equals(queryConditions.getEarthquakeName())){
            builder.append("and t.earthquake_name like concat(concat('%',#{earthquakeInfo.earthquakeName}),'%')");
        }
        if(queryConditions.getStartTime()!=null&&!"".equals(queryConditions.getStartTime())&&queryConditions.getEndTime()!=null&&!"".equals(queryConditions.getEndTime())){
            builder.append("and t.earthquake_time between to_date(#{earthquakeInfo.startTime},'yyyy-mm-dd HH24:mi:ss') and to_date(#{earthquakeInfo.endTime},'yyyy-mm-dd HH24:mi:ss')");
        }
        if(queryConditions.getEarthquakeLevel()!=null&&!"".equals(queryConditions.getEarthquakeLevel())){
            builder.append("and t.earthquake_level like concat(#{earthquakeInfo.earthquakeLevel},'%')");
        }
        if(queryConditions.getFocalDepth()!=null&&!"".equals(queryConditions.getFocalDepth())){
            builder.append("and t.focal_depth like concat(#{earthquakeInfo.focalDepth},'%')");
        }
        if(queryConditions.getFaultName()!=null&&!"".equals(queryConditions.getFaultName())){
            builder.append("and t.fault_name=#{earthquakeInfo.faultName}");
        }
        if(queryConditions.getDataSource()!=null&&!"".equals(queryConditions.getDataSource())){
            builder.append("and t.data_source=#{earthquakeInfo.dataSource}");
        }

        return builder.toString();
    }

}
