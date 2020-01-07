package com.gisinfo.sand.queryGeographyInfo.geographyData.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gisinfo.sand.queryGeographyInfo.geographyData.bean.MetroStation;
import com.gisinfo.sand.queryGeographyInfo.geographyData.condition.MetroStationCondition;
import com.gisinfo.sand.queryGeographyInfo.geographyData.provider.MetroStationProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;
import java.util.Map;

//地铁站执行sql接口
@Mapper
public interface MetroStationMapper extends BaseMapper<MetroStation> {

    //查询总记录条数
    @SelectProvider(type= MetroStationProvider.class,method = "getMetroStationCount")
    Map<String,Object> getMetroStationCount(MetroStationCondition metroStationCondition);

    //查询数据列表
    @SelectProvider(type= MetroStationProvider.class,method = "getMetroStationList")
    List<MetroStation> getMetroStationList(MetroStationCondition metroStationCondition);

}
