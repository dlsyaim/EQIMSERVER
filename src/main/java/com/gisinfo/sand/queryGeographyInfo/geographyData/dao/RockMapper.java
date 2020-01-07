package com.gisinfo.sand.queryGeographyInfo.geographyData.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gisinfo.sand.queryGeographyInfo.geographyData.bean.Rock;
import com.gisinfo.sand.queryGeographyInfo.geographyData.condition.RockCondition;
import com.gisinfo.sand.queryGeographyInfo.geographyData.provider.RockProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;
import java.util.Map;

//执行查询岩体相关数据的sql
@Mapper
public interface RockMapper extends BaseMapper<Rock> {
    //查询总记录数
    @SelectProvider(type= RockProvider.class,method = "getRockcount")
    Map<String,Object> getRockcount(RockCondition rockCondition);

    //查询数据
    @SelectProvider(type=RockProvider.class,method = "getRocklist")
    List<Rock> getRocklist(RockCondition rockCondition);
}
