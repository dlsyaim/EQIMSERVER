package com.gisinfo.sand.commonData.provider;

import com.gisinfo.sand.commonData.bean.EqClimate;
import org.apache.ibatis.annotations.Param;

public class EqClimateProvider {
    public String getPageQuery(@Param("climateList") EqClimate queryConditions) {
        StringBuilder builder = new StringBuilder("select * from(select t.*,rownum rn from (select * from CLIMATE a where 1=1");
        if (queryConditions.getName() != null && !"".equals(queryConditions.getName())) {
            builder.append("and a.name =#{climateList.name}");
        }
        if (queryConditions.getMonth() != null && !"".equals(queryConditions.getMonth())) {
            builder.append("and a.MONTH_ =#{climateList.month}");
        }
        builder.append(" and rownum<=#{climateList.top})t) t where t.rn >#{climateList.bottom}");
        return builder.toString();
    }


    public String getCountQuery(@Param("climateCount") EqClimate queryConditions) {
        StringBuilder builder = new StringBuilder("select count(1) count from CLIMATE a where 1=1 ");
        if (queryConditions.getName() != null && !"".equals(queryConditions.getName())) {
            builder.append("and a.name =#{climateCount.name}");
        }
        if (queryConditions.getMonth() != null && !"".equals(queryConditions.getMonth())) {
            builder.append("and a.MONTH_ = #{climateCount.month}");
        }
        return builder.toString();
    }
}
