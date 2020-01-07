package com.gisinfo.sand.commonData.provider;

import com.gisinfo.sand.commonData.bean.EqTownPopulation;
import org.apache.ibatis.annotations.Param;

public class EqTownPopulationProvider {
    public String getPageQuery(@Param("townPopulation") EqTownPopulation queryConditions) {
        StringBuilder builder = new StringBuilder("select * from(select t.*,rownum rn from (select * from town_population a where 1=1");
        if (queryConditions.getName() != null && !"".equals(queryConditions.getName())) {
            builder.append("and a.name =#{townPopulation.name}");
        }
        if (queryConditions.getTotalMin() != null && !"".equals(queryConditions.getTotalMin()) && queryConditions.getTotalMax() != null && !"".equals(queryConditions.getTotalMax())) {
            builder.append("and a.total between #{townPopulation.totalMin} and #{townPopulation.totalMax}");
        }
        builder.append(" and rownum<=#{townPopulation.top})t) t where t.rn >#{townPopulation.bottom}");
        return builder.toString();
    }


    public String getCountQuery(@Param("townPopulationCount") EqTownPopulation queryConditions) {
        StringBuilder builder = new StringBuilder("select count(1) count from town_population a where 1=1 ");
        if (queryConditions.getName() != null && !"".equals(queryConditions.getName())) {
            builder.append("and a.name =#{townPopulationCount.name}");
        }
        if (queryConditions.getTotalMin() != null && !"".equals(queryConditions.getTotalMin()) && queryConditions.getTotalMax() != null && !"".equals(queryConditions.getTotalMax())) {
            builder.append("and a.total between #{townPopulationCount.totalMin} and #{townPopulationCount.totalMax}");
        }
        return builder.toString();
    }

}
