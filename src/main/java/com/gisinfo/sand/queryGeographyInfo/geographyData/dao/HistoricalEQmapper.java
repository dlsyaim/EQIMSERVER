package com.gisinfo.sand.queryGeographyInfo.geographyData.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gisinfo.sand.queryGeographyInfo.geographyData.bean.HistoricalEQ;
import com.gisinfo.sand.queryGeographyInfo.geographyData.condition.HistoricalEQcondition;
import com.gisinfo.sand.queryGeographyInfo.geographyData.provider.HistoricalProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;
import java.util.Map;

//历史强震
@Mapper
public interface HistoricalEQmapper extends BaseMapper<HistoricalEQ>{

    //查询总记录数
    @SelectProvider(type= HistoricalProvider.class,method = "getHistoricalEQCount")
    Map<String,Object> getHistoricalEQCount( HistoricalEQcondition historicalEQcondition);

    //查询数据
    @SelectProvider(type=HistoricalProvider.class,method = "getHistoricalEQlist")
    List<HistoricalEQ> getHistoricalEQlist(HistoricalEQcondition historicalEQcondition);


}
