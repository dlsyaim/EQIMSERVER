package com.gisinfo.sand.commonData.provider;

import com.gisinfo.sand.commonData.bean.EqMedical;
import org.apache.ibatis.annotations.Param;

public class EqMedicalProvider {
    public String getPageQuery(@Param("medicalList") EqMedical queryConditions) {
        StringBuilder builder = new StringBuilder("select * from(select t.*,rownum rn from (select * from medical a where 1=1");
        if (queryConditions.getId() != null && !"".equals(queryConditions.getId())) {
            builder.append("and a.id =#{medicalList.id}");
        }
        if (queryConditions.getHospitalMin() != null && !"".equals(queryConditions.getHospitalMin()) && queryConditions.getHospitalMax() != null && !"".equals(queryConditions.getHospitalMax())) {
            builder.append("and a.hospital between #{medicalList.hospitalMin} and #{medicalList.hospitalMax}");
        }
        builder.append(" and rownum<=#{medicalList.top})t) t where t.rn >#{medicalList.bottom}");
        return builder.toString();
    }


    public String getCountQuery(@Param("medicalCount") EqMedical queryConditions) {
        StringBuilder builder = new StringBuilder("select count(1) count from medical a where 1=1 ");
        if (queryConditions.getId() != null && !"".equals(queryConditions.getId())) {
            builder.append("and a.id =#{medicalCount.id}");
        }
        if (queryConditions.getHospitalMin() != null && !"".equals(queryConditions.getHospitalMin()) && queryConditions.getHospitalMax() != null && !"".equals(queryConditions.getHospitalMax())) {
            builder.append("and a.hospital between #{medicalCount.hospitalMin} and #{medicalCount.hospitalMax}");
        }
        return builder.toString();
    }
}
