package com.gisinfo.sand.queryGeographyInfo.geographyData.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gisinfo.sand.queryGeographyInfo.geographyData.bean.Station;
import com.gisinfo.sand.queryGeographyInfo.geographyData.condition.StationCondition;
import com.gisinfo.sand.queryGeographyInfo.geographyData.provider.StationProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;
import java.util.Map;

//台站执行sql接口
@Mapper
public interface StationMapper extends BaseMapper<Station> {


    //查询总记录数
    @SelectProvider(type= StationProvider.class,method = "getStationCount")
    Map<String,Object> getStationCount(StationCondition stationCondition);

    //查询记录列表
    @SelectProvider(type= StationProvider.class,method = "getStationList")
    List<Station> getStationList(StationCondition stationCondition);
}
