package com.gisinfo.sand.commonData.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gisinfo.sand.commonData.bean.EqCountyPopulation;
import com.gisinfo.sand.commonData.provider.EqCountyPopulationProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;
import java.util.Map;

@Mapper
public interface EqCountyPopulationMapper extends BaseMapper<EqCountyPopulation>{
    @SelectProvider(type = EqCountyPopulationProvider.class, method = "getPageQuery")
    List<Map> queryPageList(@Param("countyPopulation") EqCountyPopulation queryConditions);

    //获取总条数
    @SelectProvider(type = EqCountyPopulationProvider.class, method = "getCountQuery")
    Map<String, Object> getTotalCount(@Param("countyPopulationCount") EqCountyPopulation queryConditions);
}
