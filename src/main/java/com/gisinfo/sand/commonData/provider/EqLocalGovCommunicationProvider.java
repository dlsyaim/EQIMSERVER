package com.gisinfo.sand.commonData.provider;

import com.gisinfo.sand.commonData.bean.EqLocalGovCommunication;
import org.apache.ibatis.annotations.Param;

public class EqLocalGovCommunicationProvider {
    public String getPageQuery(@Param("govCommunicationList") EqLocalGovCommunication queryConditions) {
        StringBuilder builder = new StringBuilder("select * from(select t.*,rownum rn from (select * from local_gov_communication a where 1=1");
        if (queryConditions.getName() != null && !"".equals(queryConditions.getName())) {
            builder.append("and a.name =#{govCommunicationList.name}");
        }
        builder.append(" and rownum<=#{govCommunicationList.top})t) t where t.rn >#{govCommunicationList.bottom}");
        return builder.toString();
    }


    public String getCountQuery(@Param("govCommunicationCount") EqLocalGovCommunication queryConditions) {
        StringBuilder builder = new StringBuilder("select count(1) count from local_gov_communication a where 1=1 ");
        if (queryConditions.getName() != null && !"".equals(queryConditions.getName())) {
            builder.append("and a.name =#{govCommunicationCount.name}");
        }

        return builder.toString();
    }
}
