package com.gisinfo.sand.queryGeographyInfo.geographyData.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gisinfo.sand.queryGeographyInfo.geographyData.bean.LargeOilgasPipeline;
import com.gisinfo.sand.queryGeographyInfo.geographyData.condition.LargeOilgasPipelineCondition;
import com.gisinfo.sand.queryGeographyInfo.geographyData.provider.LargeOilgasPipelineProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;
import java.util.Map;

//大型油气管线执行sql接口
@Mapper
public interface LargeOilgasPipelineMapper extends BaseMapper<LargeOilgasPipeline> {

    //查询桥梁等级列表
    @SelectProvider(type= LargeOilgasPipelineProvider.class,method = "getLargeOilgasPipelineClassList")
    List<Map<String,Object>> getLargeOilgasPipelineClassList();

    //查询桥梁总记录数
    @SelectProvider(type= LargeOilgasPipelineProvider.class,method = "getLargeOilgasPipelineCount")
    Map<String,Object> getLargeOilgasPipelineCount(LargeOilgasPipelineCondition largeOilgasPipelineCondition);

    //查询记录下拉列表
    @SelectProvider(type= LargeOilgasPipelineProvider.class,method = "getLargeOilgasPipelineList")
    List<LargeOilgasPipeline> getLargeOilgasPipelineList(LargeOilgasPipelineCondition largeOilgasPipelineCondition);

}
