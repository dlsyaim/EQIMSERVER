package com.gisinfo.sand.queryGeographyInfo.geographyData.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gisinfo.sand.queryGeographyInfo.geographyData.bean.TEarthquakeProductsPs;
import com.gisinfo.sand.queryGeographyInfo.geographyData.condition.TEarthquakeProductsPsCondition;
import com.gisinfo.sand.queryGeographyInfo.geographyData.provider.TEarthquakeProductsPsProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;
import java.util.Map;

//地震触发列表执行sql接口
@Mapper
public interface TEarthquakeProductsPsMapper extends BaseMapper<TEarthquakeProductsPs> {

    //查询DOX总记录条数
    @SelectProvider(type= TEarthquakeProductsPsProvider.class,method = "getTEarthquakeProductsPsDOXCount")
    Map<String,Object> getTEarthquakeProductsPsDOXCount(TEarthquakeProductsPsCondition tEarthquakeProductsPsCondition);

    //查询DOX数据列表
    @SelectProvider(type= TEarthquakeProductsPsProvider.class,method = "getTEarthquakeProductsPsDOXList")
    List<TEarthquakeProductsPs> getTEarthquakeProductsPsDOXList(TEarthquakeProductsPsCondition tEarthquakeProductsPsCondition);

    //查询JPG总记录条数
    @SelectProvider(type= TEarthquakeProductsPsProvider.class,method = "getTEarthquakeProductsPsJPGCount")
    Map<String,Object> getTEarthquakeProductsPsJPGCount(TEarthquakeProductsPsCondition tEarthquakeProductsPsCondition);

    //查询JPG数据列表
    @SelectProvider(type= TEarthquakeProductsPsProvider.class,method = "getTEarthquakeProductsPsJPGList")
    List<TEarthquakeProductsPs> getTEarthquakeProductsPsJPGList(TEarthquakeProductsPsCondition tEarthquakeProductsPsCondition);

}
