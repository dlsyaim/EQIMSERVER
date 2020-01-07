package com.gisinfo.sand.queryGeographyInfo.geographyData.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gisinfo.sand.queryGeographyInfo.geographyData.bean.GasPipe;
import com.gisinfo.sand.queryGeographyInfo.geographyData.condition.GasPipeCondition;
import com.gisinfo.sand.queryGeographyInfo.geographyData.provider.GasPipeProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;
import java.util.Map;

//燃气管网执行sql接口
@Mapper
public interface GasPipeMapper extends BaseMapper<GasPipe> {

    //查询桥梁等级列表
    @SelectProvider(type= GasPipeProvider.class,method = "getGaspipeMaterialList")
    List<Map<String,Object>> getGaspipeMaterialList();

    //查询桥梁总记录数
    @SelectProvider(type= GasPipeProvider.class,method = "getGasPipeCount")
    Map<String,Object> getGasPipeCount(GasPipeCondition gasPipeCondition);

    //查询记录下拉列表
    @SelectProvider(type= GasPipeProvider.class,method = "getGasPipeList")
    List<GasPipe> getGasPipeList(GasPipeCondition gasPipeCondition);
    
}
