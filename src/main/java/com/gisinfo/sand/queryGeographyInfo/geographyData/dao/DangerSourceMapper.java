package com.gisinfo.sand.queryGeographyInfo.geographyData.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gisinfo.sand.queryGeographyInfo.geographyData.bean.DangerSource;
import com.gisinfo.sand.queryGeographyInfo.geographyData.condition.DangerSourceCondition;
import com.gisinfo.sand.queryGeographyInfo.geographyData.provider.DangerSourceProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;
import java.util.Map;

//危险源执行sql接口
@Mapper
public interface DangerSourceMapper extends BaseMapper<DangerSource> {

    //查询总记录数
    @SelectProvider(type= DangerSourceProvider.class,method = "getDangerSourceCount")
    Map<String,Object> getDangerSourceCount(DangerSourceCondition dangerSourceCondition);

    //查询记录列表
    @SelectProvider(type= DangerSourceProvider.class,method = "getDangerSourceList")
    List<DangerSource> getDangerSourceList(DangerSourceCondition DangerSourceCondition);
}
