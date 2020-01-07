package com.gisinfo.sand.commonData.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gisinfo.sand.commonData.bean.EqTownPopulation;
import com.gisinfo.sand.commonData.provider.EqTownPopulationProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;
import java.util.Map;

@Mapper
public interface EqTownPopulationMapper extends BaseMapper<EqTownPopulation>{
    @SelectProvider(type = EqTownPopulationProvider.class, method = "getPageQuery")
    List<Map> queryPageList(@Param("townPopulation") EqTownPopulation queryConditions);

    //获取总条数
    @SelectProvider(type = EqTownPopulationProvider.class, method = "getCountQuery")
    Map<String, Object> getTotalCount(@Param("townPopulationCount") EqTownPopulation queryConditions);
}
