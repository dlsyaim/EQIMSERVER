package com.gisinfo.sand.commonData.provider;

import com.gisinfo.sand.commonData.bean.EqCountyPopulation;
import org.apache.ibatis.annotations.Param;

public class EqCountyPopulationProvider {
    public String getPageQuery(@Param("countyPopulation") EqCountyPopulation queryConditions) {
        StringBuilder builder = new StringBuilder("select * from(select t.*,rownum rn from (select * from county_population a where 1=1");
        if (queryConditions.getName() != null && !"".equals(queryConditions.getName())) {
            builder.append("and a.name =#{countyPopulation.name}");
        }
        if (queryConditions.getTotalMin() != null && !"".equals(queryConditions.getTotalMin()) && queryConditions.getTotalMax() != null && !"".equals(queryConditions.getTotalMax())) {
            builder.append("and a.total between #{countyPopulation.totalMin} and #{countyPopulation.totalMax}");
        }
        builder.append(" and rownum<=#{countyPopulation.top})t) t where t.rn >#{countyPopulation.bottom}");

        return builder.toString();
    }


    public String getCountQuery(@Param("countyPopulationCount") EqCountyPopulation queryConditions) {
        StringBuilder builder = new StringBuilder("select count(1) count from county_population a where 1=1 ");
        if (queryConditions.getName() != null && !"".equals(queryConditions.getName())) {
            builder.append("and a.name =#{countyPopulationCount.name}");
        }
        if (queryConditions.getTotalMin() != null && !"".equals(queryConditions.getTotalMin()) && queryConditions.getTotalMax() != null && !"".equals(queryConditions.getTotalMax())) {
            builder.append("and a.total between #{countyPopulationCount.totalMin} and #{countyPopulationCount.totalMax}");
        }
        return builder.toString();
    }

}
