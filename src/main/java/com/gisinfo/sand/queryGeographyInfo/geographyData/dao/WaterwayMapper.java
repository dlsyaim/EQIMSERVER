package com.gisinfo.sand.queryGeographyInfo.geographyData.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gisinfo.sand.queryGeographyInfo.geographyData.bean.WaterWay;
import com.gisinfo.sand.queryGeographyInfo.geographyData.condition.WaterwayCondition;
import com.gisinfo.sand.queryGeographyInfo.geographyData.provider.WaterwayProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;
import java.util.Map;

//水道执行sql接口
@Mapper
public interface WaterwayMapper extends BaseMapper<WaterWay> {

    //查询水道类别列表
    @SelectProvider(type= WaterwayProvider.class,method = "getWaterwayClassList")
    List<Map<String,Object>> getWaterwayClassList();

    //查询总记录条数
    @SelectProvider(type= WaterwayProvider.class,method = "getWaterwayCount")
    Map<String,Object> getWaterwayCount(WaterwayCondition waterwayCondition);

    //查询数据列表
    @SelectProvider(type= WaterwayProvider.class,method = "getWaterwayList")
    List<WaterWay> getWaterwayList(WaterwayCondition waterwayCondition);
}
