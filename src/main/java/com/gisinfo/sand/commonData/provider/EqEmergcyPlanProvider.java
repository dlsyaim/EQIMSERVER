package com.gisinfo.sand.commonData.provider;

import com.gisinfo.sand.commonData.bean.EqEmergcyPlan;
import org.apache.ibatis.annotations.Param;

public class EqEmergcyPlanProvider{
    public String getPageQuery(@Param("emergencyPlanList") EqEmergcyPlan queryConditions) {
        StringBuilder builder = new StringBuilder("select * from(select t.*,rownum rn from (select * from emergcy_plan a where 1=1");
        if (queryConditions.getUnitname() != null && !"".equals(queryConditions.getUnitname())) {
            builder.append("and a.unitname =#{emergencyPlanList.unitname}");
        }
        if (queryConditions.getFullName() != null && !"".equals(queryConditions.getFullName())) {
            builder.append("and a.FULL_NAME =#{emergencyPlanList.fullName}");
        }
        builder.append(" and rownum<=#{emergencyPlanList.top})t) t where t.rn >#{emergencyPlanList.bottom}");
        System.out.println(builder.toString());
        return builder.toString();
    }


    public String getCountQuery(@Param("emergencyPlanCount") EqEmergcyPlan queryConditions) {
        StringBuilder builder = new StringBuilder("select count(1) count from emergcy_plan a where 1=1 ");
        if (queryConditions.getUnitname() != null && !"".equals(queryConditions.getUnitname())) {
            builder.append("and a.unitname =#{emergencyPlanCount.unitname}");
        }
        if (queryConditions.getFullName() != null && !"".equals(queryConditions.getFullName())) {
            builder.append("and a.FULL_NAME = #{emergencyPlanCount.fullName}");
        }
        return builder.toString();
    }
}
