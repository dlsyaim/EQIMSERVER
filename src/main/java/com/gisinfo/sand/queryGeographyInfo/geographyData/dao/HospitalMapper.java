package com.gisinfo.sand.queryGeographyInfo.geographyData.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gisinfo.sand.queryGeographyInfo.geographyData.bean.Hospital;
import com.gisinfo.sand.queryGeographyInfo.geographyData.condition.HospitalCondition;
import com.gisinfo.sand.queryGeographyInfo.geographyData.provider.HospitalProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;
import java.util.Map;

//医院执行sql接口
@Mapper
public interface HospitalMapper extends BaseMapper<Hospital> {

    //查询类别下拉列表
    @SelectProvider(type= HospitalProvider.class,method = "getHospitalTypeList")
    List<Map<String,Object>> getHospitalTypeList();

    //查询等级列表
    @SelectProvider(type= HospitalProvider.class,method = "getHospitalGradeList")
    List<Map<String,Object>> getHospitalGradeList();

    //查询总记录数
    @SelectProvider(type= HospitalProvider.class,method = "getHospitalCount")
    Map<String,Object> getHospitalCount(HospitalCondition hospitalCondition);

    //查询记录列表
    @SelectProvider(type= HospitalProvider.class,method = "getHospitalList")
    List<Hospital> getHospitalList(HospitalCondition hospitalCondition);
}