package com.gisinfo.sand.queryGeographyInfo.geographyData.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gisinfo.sand.queryGeographyInfo.geographyData.bean.From1970ToCurrentEQ;
import com.gisinfo.sand.queryGeographyInfo.geographyData.condition.From1970ToCurrentEQcondition;
import com.gisinfo.sand.queryGeographyInfo.geographyData.provider.From1970ToCurrentEQprovider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;
import java.util.Map;

//执行查询1970以来小震相关数据sql对象
@Mapper
public interface From1970ToCurrentEQmapper extends BaseMapper<From1970ToCurrentEQ> {
    //查询总记录数
    @SelectProvider(type= From1970ToCurrentEQprovider.class,method = "getFrom1970ToCurrentEQcount")
    Map<String,Object> getFrom1970ToCurrentEQcount(From1970ToCurrentEQcondition from1970ToCurrentEQcondition);

    //查询数据
    @SelectProvider(type=From1970ToCurrentEQprovider.class,method = "getFrom1970ToCurrentEQlist")
    List<From1970ToCurrentEQ> getFrom1970ToCurrentEQlist(From1970ToCurrentEQcondition from1970ToCurrentEQcondition);
}
