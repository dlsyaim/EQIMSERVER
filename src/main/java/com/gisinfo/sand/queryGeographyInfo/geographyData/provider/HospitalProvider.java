package com.gisinfo.sand.queryGeographyInfo.geographyData.provider;


import com.gisinfo.sand.queryGeographyInfo.geographyData.condition.HospitalCondition;

//医院构建sql类
public class HospitalProvider {

    //查询总记录数
    public String getHospitalCount(HospitalCondition hospitalCondition){
        StringBuilder builder =new StringBuilder("select count(1) count from HOSPITAL t where 1=1");
        if(hospitalCondition.getName()!=null&&!"".equals(hospitalCondition.getName())){
            builder.append(" and t.name like concat(concat('%',#{name}),'%')");
        }
        if(hospitalCondition.getType()!=null&&!"".equals(hospitalCondition.getType())){
            builder.append(" and t.type like concat(concat('%',#{type}),'%')");
        }
        if(hospitalCondition.getGrade()!=null&&!"".equals(hospitalCondition.getGrade())){
            builder.append(" and t.grade like concat(concat('%',#{hospitalGrade}),'%')");
        }

        return builder.toString();
    }

    //查询数据列表
    public String getHospitalList(HospitalCondition hospitalCondition){
        StringBuilder builder =new StringBuilder("select * from(select t.*,rownum rn from (select * from HOSPITAL t where 1=1 ");
        if(hospitalCondition.getName()!=null&&!"".equals(hospitalCondition.getName())){
            builder.append(" and t.name like concat(concat('%',#{name}),'%')");
        }
        if(hospitalCondition.getType()!=null&&!"".equals(hospitalCondition.getType())){
            builder.append(" and t.type like concat(concat('%',#{type}),'%')");
        }
        if(hospitalCondition.getGrade()!=null&&!"".equals(hospitalCondition.getGrade())){
            builder.append(" and t.grade like concat(concat('%',#{grade}),'%')");
        }

        builder.append(" and rownum<=#{top})t) t where t.rn >#{bottom}");

        return builder.toString();
    }

    //获取类别下拉列表
    public String getHospitalTypeList(){
        StringBuilder builder =new StringBuilder("select distinct t.type from HOSPITAL t where t.type is not null");
        return builder.toString();
    }

    //获取桥梁等级下拉列表
    public String getHospitalGradeList(){
        StringBuilder builder =new StringBuilder("select distinct t.grade from HOSPITAL t where t.grade is not null");
        return builder.toString();
    }
    
}
