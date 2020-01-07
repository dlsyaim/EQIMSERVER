package com.gisinfo.sand.queryGeographyInfo.geographyData.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gisinfo.sand.queryGeographyInfo.geographyData.bean.PowerStation;
import com.gisinfo.sand.queryGeographyInfo.geographyData.condition.PowerStationCondition;
import com.gisinfo.sand.queryGeographyInfo.geographyData.provider.PowerStationProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;
import java.util.Map;

//重要发电厂房信息执行sql接口
@Mapper
public interface PowerStationMapper extends BaseMapper<PowerStation> {


    //查询总记录数
    @SelectProvider(type= PowerStationProvider.class,method = "getPowerStationCount")
    Map<String,Object> getPowerStationCount(PowerStationCondition powerStationCondition);

    //查询记录列表
    @SelectProvider(type= PowerStationProvider.class,method = "getPowerStationList")
    List<PowerStation> getPowerStationList(PowerStationCondition powerStationCondition);
}
