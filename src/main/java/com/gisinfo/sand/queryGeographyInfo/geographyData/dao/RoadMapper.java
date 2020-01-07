package com.gisinfo.sand.queryGeographyInfo.geographyData.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gisinfo.sand.queryGeographyInfo.geographyData.bean.Road;
import com.gisinfo.sand.queryGeographyInfo.geographyData.condition.RoadCondition;
import com.gisinfo.sand.queryGeographyInfo.geographyData.provider.RoadProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;
import java.util.Map;

//道路执行sql类
@Mapper
public interface RoadMapper extends BaseMapper<Road> {

    //获取道路等级下拉列表
    @SelectProvider(type= RoadProvider.class,method = "getRoadClassList")
    List<Map<String,Object>> getRoadClassList();

    //查询总记录条数
    @SelectProvider(type= RoadProvider.class,method = "getRoadCount")
    Map<String,Object> getRoadCount(RoadCondition roadCondition);

    //查询记录列表
    @SelectProvider(type= RoadProvider.class,method = "getRoadList")
    List<Road> getRoadList(RoadCondition roadCondition);
}
