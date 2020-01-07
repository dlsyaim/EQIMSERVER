package com.gisinfo.sand.queryGeographyInfo.geographyData.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gisinfo.sand.queryGeographyInfo.geographyData.bean.Stratigraphy;
import com.gisinfo.sand.queryGeographyInfo.geographyData.condition.HistoricalEQcondition;
import com.gisinfo.sand.queryGeographyInfo.geographyData.condition.StratigraphyCondition;
import com.gisinfo.sand.queryGeographyInfo.geographyData.provider.StratigraphyProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;
import java.util.Map;

//执行查询地层相关数据的sql对象
@Mapper
public interface StratigraphyMapper extends BaseMapper<Stratigraphy> {
    //查询总记录数
    @SelectProvider(type= StratigraphyProvider.class,method = "getStratigraphycount")
    Map<String,Object> getHistoricalEQCount(StratigraphyCondition stratigraphyCondition);

    //查询数据
    @SelectProvider(type=StratigraphyProvider.class,method = "getStratigraphyList")
    List<Stratigraphy> getHistoricalEQlist(StratigraphyCondition stratigraphyCondition);
}
