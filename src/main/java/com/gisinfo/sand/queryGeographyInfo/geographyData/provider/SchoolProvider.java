package com.gisinfo.sand.queryGeographyInfo.geographyData.provider;

import com.gisinfo.sand.queryGeographyInfo.geographyData.condition.SchoolCondition;

//学校构建sql类
public class SchoolProvider {

    //查询总记录数
    public String getSchoolCount(SchoolCondition schoolCondition){
        StringBuilder builder =new StringBuilder("select count(1) count from SCHOOL t where 1=1");
        if(schoolCondition.getUnitName()!=null&&!"".equals(schoolCondition.getUnitName())){
            builder.append(" and t.UNITNAME like concat(concat('%',#{unitName}),'%')");
        }
        if(schoolCondition.getSchoolScale()!=null&&!"".equals(schoolCondition.getSchoolScale())){
            builder.append(" and t.scale like concat(concat('%',#{schoolScale}),'%')");
        }
        if(schoolCondition.getSchoolClass()!=null&&!"".equals(schoolCondition.getSchoolClass())){
            builder.append(" and t.class like concat(concat('%',#{schoolClass}),'%')");
        }
        return builder.toString();
    }

    //查询数据列表
    public String getSchoolList(SchoolCondition schoolCondition){
        StringBuilder builder =new StringBuilder("select * from(select t.*,rownum rn from (select * from SCHOOL t where 1=1 ");
        if(schoolCondition.getUnitName()!=null&&!"".equals(schoolCondition.getUnitName())){
            builder.append(" and t.UNITNAME like concat(concat('%',#{unitName}),'%')");
        }
        if(schoolCondition.getSchoolScale()!=null&&!"".equals(schoolCondition.getSchoolScale())){
            builder.append(" and t.scale like concat(concat('%',#{schoolScale}),'%')");
        }
        if(schoolCondition.getSchoolClass()!=null&&!"".equals(schoolCondition.getSchoolClass())){
            builder.append(" and t.class like concat(concat('%',#{schoolClass}),'%')");
        }

        builder.append(" and rownum<=#{top})t) t where t.rn >#{bottom}");

        return builder.toString();
    }

    //获取类别下拉列表
    public String getSchoolClassList(){
        StringBuilder builder =new StringBuilder("select distinct t.class as schoolClass from SCHOOL t where t.class is not null");
        return builder.toString();
    }
    
}
