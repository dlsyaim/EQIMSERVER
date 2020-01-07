package com.gisinfo.sand.queryGeographyInfo.geographyData.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gisinfo.sand.queryGeographyInfo.geographyData.bean.ActiveFault;
import com.gisinfo.sand.queryGeographyInfo.geographyData.condition.ActiveFaultCondition;
import com.gisinfo.sand.queryGeographyInfo.geographyData.provider.ActiveFaultProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;
import java.util.Map;

//活跃断层执行sql获得数据类
@Mapper
public interface ActiveFaultMapper extends BaseMapper<ActiveFault> {
    //查询总记录条数
    @SelectProvider(type= ActiveFaultProvider.class,method = "getActiveFaultCount")
    Map<String,Object> getActiveFaultCount(ActiveFaultCondition activeFaultCondition);

    //查询记录列表
    @SelectProvider(type=ActiveFaultProvider.class,method = "getActiveFaultList")
    List<ActiveFault> getActiveFaultList(ActiveFaultCondition activeFaultCondition);
}
