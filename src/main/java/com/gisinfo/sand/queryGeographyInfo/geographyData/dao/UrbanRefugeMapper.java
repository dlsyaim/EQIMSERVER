package com.gisinfo.sand.queryGeographyInfo.geographyData.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gisinfo.sand.queryGeographyInfo.geographyData.bean.UrbanRefuge;
import com.gisinfo.sand.queryGeographyInfo.geographyData.condition.UrbanRefugeCondition;
import com.gisinfo.sand.queryGeographyInfo.geographyData.provider.UrbanRefugeProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;
import java.util.Map;

//城市避难所执行sql接口
@Mapper
public interface UrbanRefugeMapper extends BaseMapper<UrbanRefuge> {

    //查询类别下拉列表
    @SelectProvider(type= UrbanRefugeProvider.class,method = "getUrbanRefugeTypeList")
    List<Map<String,Object>> getUrbanRefugeTypeList();

    //查询等级列表
    @SelectProvider(type= UrbanRefugeProvider.class,method = "getUrbanRefugeCitList")
    List<Map<String,Object>> getUrbanRefugeCitList();

    //查询总记录数
    @SelectProvider(type= UrbanRefugeProvider.class,method = "getUrbanRefugeCount")
    Map<String,Object> getUrbanRefugeCount(UrbanRefugeCondition urbanRefugeCondition);

    //查询记录列表
    @SelectProvider(type= UrbanRefugeProvider.class,method = "getUrbanRefugeList")
    List<UrbanRefuge> getUrbanRefugeList(UrbanRefugeCondition urbanRefugeCondition);
}