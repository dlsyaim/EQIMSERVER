package com.gisinfo.sand.commonData.provider;

import com.gisinfo.sand.commonData.bean.EqTownBuilding;
import org.apache.ibatis.annotations.Param;

public class EqTownBuildingProvider {
    public String getPageQuery(@Param("townBuildingList") EqTownBuilding queryConditions) {
        StringBuilder builder = new StringBuilder("select * from(select t.*,rownum rn from (select * from town_building a where 1=1");
        if (queryConditions.getName() != null && !"".equals(queryConditions.getName())) {
            builder.append("and a.name =#{townBuildingList.name}");
        }
        if (queryConditions.getTotalAreaMin() != null && !"".equals(queryConditions.getTotalAreaMin()) && queryConditions.getTotalAreaMax() != null && !"".equals(queryConditions.getTotalAreaMax())) {
            builder.append("and a.TOTAL_AREA between #{townBuildingList.totalAreaMin} and #{townBuildingList.totalAreaMax}");
        }
        if (queryConditions.getAverageMin() != null && !"".equals(queryConditions.getAverageMin()) && queryConditions.getAverageMax() != null && !"".equals(queryConditions.getAverageMax())) {
            builder.append("and a.average between #{townBuildingList.averageMin} and #{townBuildingList.averageMax}");
        }
        builder.append(" and rownum<=#{townBuildingList.top})t) t where t.rn >#{townBuildingList.bottom}");
        return builder.toString();
    }

    public String getCountQuery(@Param("townBuildingCount") EqTownBuilding queryConditions) {
        StringBuilder builder = new StringBuilder("select count(1) count from town_building a where 1=1 ");
        if (queryConditions.getName() != null && !"".equals(queryConditions.getName())) {
            builder.append("and a.name =#{townBuildingCount.name}");
        }
        if (queryConditions.getTotalAreaMin() != null && !"".equals(queryConditions.getTotalAreaMin()) && queryConditions.getTotalAreaMax() != null && !"".equals(queryConditions.getTotalAreaMax())) {
            builder.append("and a.TOTAL_AREA between #{townBuildingCount.totalAreaMin} and #{townBuildingCount.totalAreaMax}");
        }
        if (queryConditions.getAverageMin() != null && !"".equals(queryConditions.getAverageMin()) && queryConditions.getAverageMax() != null && !"".equals(queryConditions.getAverageMax())) {
            builder.append("and a.average between #{townBuildingCount.averageMin} and #{townBuildingCount.averageMax}");
        }
        return builder.toString();
    }
}
