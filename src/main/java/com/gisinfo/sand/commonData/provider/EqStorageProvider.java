package com.gisinfo.sand.commonData.provider;

import com.gisinfo.sand.commonData.bean.EqStorage;
import org.apache.ibatis.annotations.Param;

public class EqStorageProvider {
    public String getPageQuery(@Param("storageList") EqStorage queryConditions) {
        StringBuilder builder = new StringBuilder("select * from(select t.*,rownum rn from (select * from storage a where 1=1");
        if (queryConditions.getName() != null && !"".equals(queryConditions.getName())) {
            builder.append("and a.name =#{storageList.name}");
        }
        builder.append(" and rownum<=#{storageList.top})t) t where t.rn >#{storageList.bottom}");
        return builder.toString();
    }


    public String getCountQuery(@Param("storageCount") EqStorage queryConditions) {
        StringBuilder builder = new StringBuilder("select count(1) count from storage a where 1=1 ");
        if (queryConditions.getName() != null && !"".equals(queryConditions.getName())) {
            builder.append("and a.name =#{storageCount.name}");
        }

        return builder.toString();
    }
}
