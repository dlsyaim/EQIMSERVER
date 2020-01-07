package com.gisinfo.sand.commonData.provider;

import com.gisinfo.sand.commonData.bean.EqFirePower;
import org.apache.ibatis.annotations.Param;

public class EqFirePowerProvider {
    public String getPageQuery(@Param("firePowerList") EqFirePower queryConditions) {
        StringBuilder builder = new StringBuilder("select * from(select t.*,rownum rn from (select * from fire_power a where 1=1");
        if (queryConditions.getName() != null && !"".equals(queryConditions.getName())) {
            builder.append("and a.name =#{firePowerList.name}");
        }
        builder.append(" and rownum<=#{firePowerList.top})t) t where t.rn >#{firePowerList.bottom}");
        return builder.toString();
    }


    public String getCountQuery(@Param("firePowerCount") EqFirePower queryConditions) {
        StringBuilder builder = new StringBuilder("select count(1) count from fire_power a where 1=1 ");
        if (queryConditions.getName() != null && !"".equals(queryConditions.getName())) {
            builder.append("and a.name =#{firePowerCount.name}");
        }

        return builder.toString();
    }
}
