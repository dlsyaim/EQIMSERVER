package com.gisinfo.sand.commonData.provider;

import com.gisinfo.sand.commonData.bean.EqTroopCommunication;
import org.apache.ibatis.annotations.Param;

public class EqTroopCommunicationProvider {
    public String getPageQuery(@Param("troopCommunicationList") EqTroopCommunication queryConditions) {
        StringBuilder builder = new StringBuilder("select * from(select t.*,rownum rn from (select * from troop_communication a where 1=1");
        if (queryConditions.getName() != null && !"".equals(queryConditions.getName())) {
            builder.append("and a.name =#{troopCommunicationList.name}");
        }
        builder.append(" and rownum<=#{troopCommunicationList.top})t) t where t.rn >#{troopCommunicationList.bottom}");
        return builder.toString();
    }


    public String getCountQuery(@Param("troopCommunicationCount") EqTroopCommunication queryConditions) {
        StringBuilder builder = new StringBuilder("select count(1) count from troop_communication a where 1=1 ");
        if (queryConditions.getName() != null && !"".equals(queryConditions.getName())) {
            builder.append("and a.name =#{troopCommunicationCount.name}");
        }

        return builder.toString();
    }
}
