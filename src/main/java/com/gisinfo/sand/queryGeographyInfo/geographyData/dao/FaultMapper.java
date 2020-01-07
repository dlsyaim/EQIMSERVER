package com.gisinfo.sand.queryGeographyInfo.geographyData.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gisinfo.sand.queryGeographyInfo.geographyData.bean.Fault;
import com.gisinfo.sand.queryGeographyInfo.geographyData.condition.FaultCondition;
import com.gisinfo.sand.queryGeographyInfo.geographyData.provider.FaultProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;
import java.util.Map;

//执行断裂相关sql
@Mapper
public interface FaultMapper extends BaseMapper<Fault> {
    //查询总记录数
    @SelectProvider(type= FaultProvider.class,method = "getFaultcount")
    Map<String,Object> getFaultcount(FaultCondition faultCondition);

    //查询数据
    @SelectProvider(type=FaultProvider.class,method = "getFaultlist")
    List<Fault> getFaultlist(FaultCondition faultCondition);
}
