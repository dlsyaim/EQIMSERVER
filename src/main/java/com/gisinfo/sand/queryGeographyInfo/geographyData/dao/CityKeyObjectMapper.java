package com.gisinfo.sand.queryGeographyInfo.geographyData.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gisinfo.sand.queryGeographyInfo.geographyData.bean.CityKeyObject;
import com.gisinfo.sand.queryGeographyInfo.geographyData.condition.CityKeyObjectCondition;
import com.gisinfo.sand.queryGeographyInfo.geographyData.provider.CityKeyObjectProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;
import java.util.Map;

//城市主要目标执行sql接口
@Mapper
public interface CityKeyObjectMapper extends BaseMapper<CityKeyObject> {

    //查询桥梁类别下拉列表
    @SelectProvider(type= CityKeyObjectProvider.class,method = "getCityKeyObjectClassList")
    List<Map<String,Object>> getCityKeyObjectClassList();

    //查询桥梁总记录数
    @SelectProvider(type= CityKeyObjectProvider.class,method = "getCityKeyObjectCount")
    Map<String,Object> getCityKeyObjectCount(CityKeyObjectCondition cityKeyObjectCondition);

    //查询记录下拉列表
    @SelectProvider(type= CityKeyObjectProvider.class,method = "getCityKeyObjectList")
    List<CityKeyObject> getCityKeyObjectList(CityKeyObjectCondition cityKeyObjectCondition);

}
