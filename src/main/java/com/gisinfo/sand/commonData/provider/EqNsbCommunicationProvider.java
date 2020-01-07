package com.gisinfo.sand.commonData.provider;

import com.gisinfo.sand.commonData.bean.EqNsbCommunication;
import org.apache.ibatis.annotations.Param;

public class EqNsbCommunicationProvider {
    public String getPageQuery(@Param("nsbCommunicationList") EqNsbCommunication queryConditions) {
        StringBuilder builder = new StringBuilder("select * from(select t.*,rownum rn from (select * from nsb_communication a where 1=1");
        if (queryConditions.getName() != null && !"".equals(queryConditions.getName())) {
            builder.append("and a.name =#{nsbCommunicationList.name}");
        }
        builder.append(" and rownum<=#{nsbCommunicationList.top})t) t where t.rn >#{nsbCommunicationList.bottom}");
        return builder.toString();
    }


    public String getCountQuery(@Param("nsbCommunicationCount") EqNsbCommunication queryConditions) {
        StringBuilder builder = new StringBuilder("select count(1) count from nsb_communication a where 1=1 ");
        if (queryConditions.getName() != null && !"".equals(queryConditions.getName())) {
            builder.append("and a.name =#{nsbCommunicationCount.name}");
        }

        return builder.toString();
    }
}
