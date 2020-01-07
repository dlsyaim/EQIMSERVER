package com.gisinfo.sand.commonData.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gisinfo.sand.commonData.bean.EqEmergcyPlan;
import com.gisinfo.sand.commonData.provider.EqEmergcyPlanProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;
import java.util.Map;

@Mapper
public interface EqEmergcyPlanMapper extends BaseMapper<EqEmergcyPlan>{
    @SelectProvider(type = EqEmergcyPlanProvider.class, method = "getPageQuery")
    List<EqEmergcyPlan> queryPageList(@Param("emergencyPlanList") EqEmergcyPlan queryConditions);

    //获取总条数
    @SelectProvider(type = EqEmergcyPlanProvider.class, method = "getCountQuery")
    Map<String, Object> getTotalCount(@Param("emergencyPlanCount") EqEmergcyPlan queryConditions);
}
