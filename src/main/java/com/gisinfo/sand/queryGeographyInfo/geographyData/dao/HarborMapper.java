package com.gisinfo.sand.queryGeographyInfo.geographyData.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gisinfo.sand.queryGeographyInfo.geographyData.bean.Harbor;
import com.gisinfo.sand.queryGeographyInfo.geographyData.condition.HarborCondition;
import com.gisinfo.sand.queryGeographyInfo.geographyData.provider.HarborProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;
import java.util.Map;

//港口执行sql类
@Mapper
public interface HarborMapper extends BaseMapper<Harbor> {

    //查询总记录数
    @SelectProvider(type= HarborProvider.class,method = "getHarborCount")
    Map<String,Object> getHarborCount(HarborCondition harborCondition);

    //查询数据列表
    @SelectProvider(type= HarborProvider.class,method = "getHarborList")
    List<Harbor> getHarborList(HarborCondition harborCondition);

}
