package com.gisinfo.sand.queryGeographyInfo.geographyData.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gisinfo.sand.queryGeographyInfo.geographyData.bean.Bridge;
import com.gisinfo.sand.queryGeographyInfo.geographyData.condition.BridgeCondition;
import com.gisinfo.sand.queryGeographyInfo.geographyData.provider.BridgeProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;
import java.util.Map;

//桥梁执行sql接口
@Mapper
public interface BridgeMapper extends BaseMapper<Bridge> {

    //查询桥梁类别下拉列表
    @SelectProvider(type= BridgeProvider.class,method = "getBridgeClassList")
    List<Map<String,Object>> getBridgeClassList();

    //查询桥梁等级列表
    @SelectProvider(type= BridgeProvider.class,method = "getBridgeGradeList")
    List<Map<String,Object>> getBridgeGradeList();

    //查询桥梁总记录数
    @SelectProvider(type= BridgeProvider.class,method = "getBridgeCount")
    Map<String,Object> getBridgeCount(BridgeCondition bridgeCondition);

    //查询记录下拉列表
    @SelectProvider(type= BridgeProvider.class,method = "getBridgeList")
    List<Bridge> getBridgeList(BridgeCondition bridgeCondition);
}
