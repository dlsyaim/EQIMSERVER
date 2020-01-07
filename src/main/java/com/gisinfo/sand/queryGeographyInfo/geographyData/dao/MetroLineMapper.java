package com.gisinfo.sand.queryGeographyInfo.geographyData.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gisinfo.sand.queryGeographyInfo.geographyData.bean.MetroLine;
import com.gisinfo.sand.queryGeographyInfo.geographyData.bean.WaterWay;
import com.gisinfo.sand.queryGeographyInfo.geographyData.condition.MetroLineCondition;
import com.gisinfo.sand.queryGeographyInfo.geographyData.condition.WaterwayCondition;
import com.gisinfo.sand.queryGeographyInfo.geographyData.provider.MetroLineProvider;
import com.gisinfo.sand.queryGeographyInfo.geographyData.provider.WaterwayProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;
import java.util.Map;

//地铁线路执行sql接口
@Mapper
public interface MetroLineMapper extends BaseMapper<MetroLine> {

    //查询总记录条数
    @SelectProvider(type= MetroLineProvider.class,method = "getMetroLineCount")
    Map<String,Object> getMetroLineCount(MetroLineCondition metroLineCondition);

    //查询数据列表
    @SelectProvider(type= MetroLineProvider.class,method = "getMetroLineList")
    List<MetroLine> getMetroLineList(MetroLineCondition metroLineCondition);
}
