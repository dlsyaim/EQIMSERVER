package com.gisinfo.sand.queryGeographyInfo.geographyData.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gisinfo.sand.queryGeographyInfo.geographyData.bean.Airport;
import com.gisinfo.sand.queryGeographyInfo.geographyData.condition.AirportContition;
import com.gisinfo.sand.queryGeographyInfo.geographyData.provider.AirportProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;
import java.util.Map;

//机场执行sql接口
@Mapper
public interface AirportMapper extends BaseMapper<Airport> {
    //查询总记录数
    @SelectProvider(type= AirportProvider.class,method = "getAirportCount")
    Map<String,Object> getAirportCount(AirportContition airportContition);

    //查询记录列表
    @SelectProvider(type=AirportProvider.class,method = "getAirportlist")
    List<Airport> getAirportlist(AirportContition airportContition);
}
