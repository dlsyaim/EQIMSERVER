package com.gisinfo.sand.queryGeographyInfo.geographyData.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gisinfo.sand.queryGeographyInfo.geographyData.bean.Scenic;
import com.gisinfo.sand.queryGeographyInfo.geographyData.condition.ScenicCondition;
import com.gisinfo.sand.queryGeographyInfo.geographyData.provider.ScenicProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;
import java.util.Map;

//旅游景区执行sql接口
@Mapper
public interface ScenicMapper extends BaseMapper<Scenic> {

    //查询类别下拉列表
    @SelectProvider(type= ScenicProvider.class,method = "getScenicTypeList")
    List<Map<String,Object>> getScenicTypeList();

    //查询总记录数
    @SelectProvider(type= ScenicProvider.class,method = "getScenicCount")
    Map<String,Object> getScenicCount(ScenicCondition ScenicCondition);

    //查询记录下拉列表
    @SelectProvider(type= ScenicProvider.class,method = "getScenicList")
    List<Scenic> getScenicList(ScenicCondition ScenicCondition);

}
