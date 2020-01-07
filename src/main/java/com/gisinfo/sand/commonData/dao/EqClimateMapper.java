package com.gisinfo.sand.commonData.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gisinfo.sand.commonData.bean.EqClimate;
import com.gisinfo.sand.commonData.provider.EqClimateProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;
import java.util.Map;

@Mapper
public interface EqClimateMapper extends BaseMapper<EqClimate>{
    @SelectProvider(type = EqClimateProvider.class, method = "getPageQuery")
    List<Map> queryPageList(@Param("climateList") EqClimate queryConditions);

    //获取总条数
    @SelectProvider(type = EqClimateProvider.class, method = "getCountQuery")
    Map<String, Object> getTotalCount(@Param("climateCount") EqClimate queryConditions);
}
