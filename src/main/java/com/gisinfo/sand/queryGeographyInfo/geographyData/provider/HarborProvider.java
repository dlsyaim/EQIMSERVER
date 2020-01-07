package com.gisinfo.sand.queryGeographyInfo.geographyData.provider;

import com.gisinfo.sand.queryGeographyInfo.geographyData.condition.HarborCondition;

//港口构造sql类
public class HarborProvider {
    //查询总记录数
    public String getHarborCount(HarborCondition harborCondition){
        StringBuilder builder =new StringBuilder("select count(1) count from HARBOR t where 1=1");
        if(harborCondition.getHarborName()!=null&&!"".equals(harborCondition.getHarborName())){
            builder.append(" and t.name like concat(concat('%',#{harborName}),'%')");
        }
        if(harborCondition.getHarborIntensity()!=null&&!"".equals(harborCondition.getHarborIntensity())){
            builder.append(" and t.intensity like concat(concat('%',#{harborIntensity}),'%')");
        }
        if(harborCondition.getMinHarborVolume()!=null&&!"".equals(harborCondition.getMinHarborVolume())){
            builder.append(" and t.volume >=#{minHarborVolume}");
        }
        if(harborCondition.getMaxHarborVolume()!=null&&!"".equals(harborCondition.getMaxHarborVolume())){
            builder.append(" and t.volume <=#{maxHarborVolume}");
        }

        return builder.toString();
    }

    //查询数据列表
    public String getHarborList(HarborCondition harborCondition){
        StringBuilder builder =new StringBuilder("select * from(select t.*,rownum rn from (select " +
                "t.objectid as objectId,t.name as harborName,t.postcode ," +
                "t.location,t.volume as harborVolume,t.Intensity ,t.note_ as harborNote from HARBOR t where 1=1 ");
        if(harborCondition.getHarborName()!=null&&!"".equals(harborCondition.getHarborName())){
            builder.append(" and t.name like concat(concat('%',#{harborName}),'%')");
        }
        if(harborCondition.getHarborIntensity()!=null&&!"".equals(harborCondition.getHarborIntensity())){
            builder.append(" and t.intensity like concat(concat('%',#{harborIntensity}),'%')");
        }
        if(harborCondition.getMinHarborVolume()!=null&&!"".equals(harborCondition.getMinHarborVolume())){
            builder.append(" and t.volume >=#{minHarborVolume}");
        }
        if(harborCondition.getMaxHarborVolume()!=null&&!"".equals(harborCondition.getMaxHarborVolume())){
            builder.append(" and t.volume <=#{maxHarborVolume}");
        }

        builder.append(" and rownum<=#{top})t) t where t.rn >#{bottom}");

        return builder.toString();
    }
}
