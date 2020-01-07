package com.gisinfo.sand.queryGeographyInfo.geographyData.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gisinfo.sand.queryGeographyInfo.geographyData.bean.School;
import com.gisinfo.sand.queryGeographyInfo.geographyData.condition.SchoolCondition;
import com.gisinfo.sand.queryGeographyInfo.geographyData.provider.SchoolProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;
import java.util.Map;

//学校执行sql接口
@Mapper
public interface SchoolMapper extends BaseMapper<School> {

    //查询类别下拉列表
    @SelectProvider(type= SchoolProvider.class,method = "getSchoolClassList")
    List<Map<String,Object>> getSchoolClassList();

    //查询总记录数
    @SelectProvider(type= SchoolProvider.class,method = "getSchoolCount")
    Map<String,Object> getSchoolCount(SchoolCondition schoolCondition);

    //查询记录列表
    @SelectProvider(type= SchoolProvider.class,method = "getSchoolList")
    List<School> getSchoolList(SchoolCondition schoolCondition);
}
