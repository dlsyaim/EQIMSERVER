package com.gisinfo.sand.queryGeographyInfo.geographyData.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gisinfo.sand.queryGeographyInfo.geographyData.bean.Railway;
import com.gisinfo.sand.queryGeographyInfo.geographyData.condition.RailwayCondition;
import com.gisinfo.sand.queryGeographyInfo.geographyData.provider.RailwayProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;
import java.util.Map;

//铁路执行sql接口
@Mapper
public interface RailwayMapper extends BaseMapper<Railway> {
    //查询铁路类别下拉列表
    @SelectProvider(type= RailwayProvider.class,method = "getRailwayClassList")
    List<Map<String,Object>> getRailwayClassList();

    //查询总记录数
    @SelectProvider(type= RailwayProvider.class,method = "getRailwayCount")
    Map<String,Object> getRailwayCount(RailwayCondition railwayCondition);

    //查询记录列表
    @SelectProvider(type= RailwayProvider.class,method = "getRailwayList")
    List<Railway> getRailwayList(RailwayCondition railwayCondition);
}
