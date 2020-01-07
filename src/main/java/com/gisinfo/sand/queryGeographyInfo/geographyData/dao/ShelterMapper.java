package com.gisinfo.sand.queryGeographyInfo.geographyData.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gisinfo.sand.queryGeographyInfo.geographyData.bean.Shelter;
import com.gisinfo.sand.queryGeographyInfo.geographyData.condition.ShelterCondition;
import com.gisinfo.sand.queryGeographyInfo.geographyData.provider.ShelterProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;
import java.util.Map;

//避难所执行sql接口
@Mapper
public interface ShelterMapper extends BaseMapper<Shelter> {

    //查询类别下拉列表
    @SelectProvider(type= ShelterProvider.class,method = "getShelterClassList")
    List<Map<String,Object>> getShelterClassList();

    //查询总记录数
    @SelectProvider(type= ShelterProvider.class,method = "getShelterCount")
    Map<String,Object> getShelterCount(ShelterCondition shelterCondition);

    //查询记录下拉列表
    @SelectProvider(type= ShelterProvider.class,method = "getShelterList")
    List<Shelter> getShelterList(ShelterCondition shelterCondition);
    
}
