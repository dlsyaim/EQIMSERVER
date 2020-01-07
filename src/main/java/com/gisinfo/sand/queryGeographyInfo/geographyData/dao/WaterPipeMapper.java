package com.gisinfo.sand.queryGeographyInfo.geographyData.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gisinfo.sand.queryGeographyInfo.geographyData.bean.WaterPipe;
import com.gisinfo.sand.queryGeographyInfo.geographyData.condition.WaterPipeCondition;
import com.gisinfo.sand.queryGeographyInfo.geographyData.provider.WaterPipeProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;
import java.util.Map;

//供水主干管网执行sql接口
@Mapper
public interface WaterPipeMapper extends BaseMapper<WaterPipe> {

    //查询类别下拉列表
    @SelectProvider(type= WaterPipeProvider.class,method = "getWaterPipeClassList")
    List<Map<String,Object>> getWaterPipeClassList();

    //查询材料列表
    @SelectProvider(type= WaterPipeProvider.class,method = "getWaterpipeMateialList")
    List<Map<String,Object>> getWaterpipeMateialList();

    //查询总记录数
    @SelectProvider(type= WaterPipeProvider.class,method = "getWaterPipeCount")
    Map<String,Object> getWaterPipeCount(WaterPipeCondition waterPipeCondition);

    //查询记录下拉列表
    @SelectProvider(type= WaterPipeProvider.class,method = "getWaterPipeList")
    List<WaterPipe> getWaterPipeList(WaterPipeCondition waterPipeCondition);
}
