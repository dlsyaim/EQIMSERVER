package com.gisinfo.sand.commonData.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gisinfo.sand.commonData.bean.EqTownBuilding;
import com.gisinfo.sand.commonData.provider.EqTownBuildingProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;
import java.util.Map;

@Mapper
public interface EqTownBuildingMapper extends BaseMapper<EqTownBuilding>{
    @SelectProvider(type = EqTownBuildingProvider.class, method = "getPageQuery")
    List<EqTownBuilding> queryPageList(@Param("townBuildingList") EqTownBuilding queryConditions);

    //获取总条数
    @SelectProvider(type = EqTownBuildingProvider.class, method = "getCountQuery")
    Map<String, Object> getTotalCount(@Param("townBuildingCount") EqTownBuilding queryConditions);
}
