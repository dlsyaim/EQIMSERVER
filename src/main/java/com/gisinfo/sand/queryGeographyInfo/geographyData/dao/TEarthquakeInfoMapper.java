package com.gisinfo.sand.queryGeographyInfo.geographyData.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gisinfo.sand.queryGeographyInfo.geographyData.bean.TEarthquakeInfo;
import com.gisinfo.sand.queryGeographyInfo.geographyData.condition.TEarthquakeInfoCondition;
import com.gisinfo.sand.queryGeographyInfo.geographyData.provider.TEarthquakeInfoProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;
import java.util.Map;

//地震触发列表执行sql接口
@Mapper
public interface TEarthquakeInfoMapper extends BaseMapper<TEarthquakeInfo> {

    //查询总记录条数
    @SelectProvider(type= TEarthquakeInfoProvider.class,method = "getTEarthquakeInfoCount")
    Map<String,Object> getTEarthquakeInfoCount(TEarthquakeInfoCondition tEarthquakeInfoCondition);

    //查询数据列表
    @SelectProvider(type= TEarthquakeInfoProvider.class,method = "getTEarthquakeInfoList")
    List<TEarthquakeInfo> getTEarthquakeInfoList(TEarthquakeInfoCondition tEarthquakeInfoCondition);

    //查询数据列表
    @SelectProvider(type= TEarthquakeInfoProvider.class,method = "getTEarthquakeId")
    List<Map> getTEarthquakeId(TEarthquakeInfoCondition tEarthquakeInfoCondition);

}
