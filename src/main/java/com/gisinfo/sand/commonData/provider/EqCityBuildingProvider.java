package com.gisinfo.sand.commonData.provider;

import com.gisinfo.sand.commonData.bean.EqCityBuilding;
import org.apache.ibatis.annotations.Param;

public class EqCityBuildingProvider {
    public String getPageQuery(@Param("cityBuildingList") EqCityBuilding queryConditions) {
        StringBuilder builder = new StringBuilder("select * from(select t.*,rownum rn from (select * from city_building a where 1=1");
        if (queryConditions.getName() != null && !"".equals(queryConditions.getName())) {
            builder.append("and a.name =#{cityBuildingList.name}");
        }
        if (queryConditions.getTotalAreaMin() != null && !"".equals(queryConditions.getTotalAreaMin()) && queryConditions.getTotalAreaMax() != null && !"".equals(queryConditions.getTotalAreaMax())) {
            builder.append("and a.TOTAL_AREA between #{cityBuildingList.totalAreaMin} and #{cityBuildingList.totalAreaMax}");
        }
        if (queryConditions.getAverageMin() != null && !"".equals(queryConditions.getAverageMin()) && queryConditions.getAverageMax() != null && !"".equals(queryConditions.getAverageMax())) {
            builder.append("and a.average between #{cityBuildingList.averageMin} and #{cityBuildingList.averageMax}");
        }
        builder.append(" and rownum<=#{cityBuildingList.top})t) t where t.rn >#{cityBuildingList.bottom}");
        return builder.toString();
    }


    public String getCountQuery(@Param("cityBuildingCount") EqCityBuilding queryConditions) {
        StringBuilder builder = new StringBuilder("select count(1) count from city_building a where 1=1 ");
        if (queryConditions.getName() != null && !"".equals(queryConditions.getName())) {
            builder.append("and a.name =#{cityBuildingCount.name}");
        }
        if (queryConditions.getTotalAreaMin() != null && !"".equals(queryConditions.getTotalAreaMin()) && queryConditions.getTotalAreaMax() != null && !"".equals(queryConditions.getTotalAreaMax())) {
            builder.append("and a.TOTAL_AREA between #{cityBuildingCount.totalAreaMin} and #{cityBuildingCount.totalAreaMax}");
        }
        if (queryConditions.getAverageMin() != null && !"".equals(queryConditions.getAverageMin()) && queryConditions.getAverageMax() != null && !"".equals(queryConditions.getAverageMax())) {
            builder.append("and a.average between #{cityBuildingCount.averageMin} and #{cityBuildingCount.averageMax}");
        }
        return builder.toString();
    }
}
