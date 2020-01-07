package com.gisinfo.sand.queryGeographyInfo.geographyData.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gisinfo.sand.queryGeographyInfo.geographyData.bean.DetachedBuilding;
import com.gisinfo.sand.queryGeographyInfo.geographyData.condition.DetachedBuildingCondition;
import com.gisinfo.sand.queryGeographyInfo.geographyData.provider.DetachedBuildingProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;
import java.util.Map;

//独立建筑执行sql接口
@Mapper
public interface DetachedBuildingMapper extends BaseMapper<DetachedBuilding> {

    //查询类别下拉列表
    @SelectProvider(type= DetachedBuildingProvider.class,method = "getDetachedBuildingTypeList")
    List<Map<String,Object>> getDetachedBuildingTypeList();

    //查询总记录数
    @SelectProvider(type= DetachedBuildingProvider.class,method = "getDetachedBuildingCount")
    Map<String,Object> getDetachedBuildingCount(DetachedBuildingCondition DetachedBuildingCondition);

    //查询记录列表
    @SelectProvider(type= DetachedBuildingProvider.class,method = "getDetachedBuildingList")
    List<DetachedBuilding> getDetachedBuildingList(DetachedBuildingCondition DetachedBuildingCondition);
}
