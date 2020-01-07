package com.gisinfo.sand.commonData.provider;

import com.gisinfo.sand.commonData.bean.EqEconomy;
import org.apache.ibatis.annotations.Param;

public class EqEconomyProvider {
    public String getPageQuery(@Param("eqEconomyList") EqEconomy queryConditions) {
        StringBuilder builder = new StringBuilder("select * from(select t.*,rownum rn from (select * from economy a where 1=1");
        if (queryConditions.getName() != null && !"".equals(queryConditions.getName())) {
            builder.append("and a.name =#{eqEconomyList.name}");
        }
        if (queryConditions.getGdpMin() != null && !"".equals(queryConditions.getGdpMin()) && queryConditions.getGdpMax() != null && !"".equals(queryConditions.getGdpMax())) {
            builder.append("and a.gdp between #{eqEconomyList.gdpMin} and #{eqEconomyList.gdpMax}");
        }
        builder.append(" and rownum<=#{eqEconomyList.top})t) t where t.rn >#{eqEconomyList.bottom}");
        return builder.toString();
    }


    public String getCountQuery(@Param("eqEconomyCount") EqEconomy queryConditions) {
        StringBuilder builder = new StringBuilder("select count(1) count from economy a where 1=1 ");
        if (queryConditions.getName() != null && !"".equals(queryConditions.getName())) {
            builder.append("and a.name =#{eqEconomyCount.name}");
        }
        if (queryConditions.getGdpMin() != null && !"".equals(queryConditions.getGdpMin()) && queryConditions.getGdpMax() != null && !"".equals(queryConditions.getGdpMax())) {
            builder.append("and a.gdp between #{eqEconomyCount.gdpMin} and #{eqEconomyCount.gdpMax}");
        }
        System.out.println(builder.toString());
        return builder.toString();
    }
}
