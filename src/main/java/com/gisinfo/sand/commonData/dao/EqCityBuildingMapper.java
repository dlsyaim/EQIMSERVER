package com.gisinfo.sand.commonData.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gisinfo.sand.commonData.bean.EqCityBuilding;
import com.gisinfo.sand.commonData.provider.EqCityBuildingProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;
import java.util.Map;

@Mapper
public interface EqCityBuildingMapper extends BaseMapper<EqCityBuilding>{
    @SelectProvider(type = EqCityBuildingProvider.class, method = "getPageQuery")
    List<Map> queryPageList(@Param("cityBuildingList") EqCityBuilding queryConditions);

    //获取总条数
    @SelectProvider(type = EqCityBuildingProvider.class, method = "getCountQuery")
    Map<String, Object> getTotalCount(@Param("cityBuildingCount") EqCityBuilding queryConditions);
}
