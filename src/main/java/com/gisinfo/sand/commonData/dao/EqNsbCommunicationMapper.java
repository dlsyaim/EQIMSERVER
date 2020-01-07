package com.gisinfo.sand.commonData.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gisinfo.sand.commonData.bean.EqNsbCommunication;
import com.gisinfo.sand.commonData.provider.EqNsbCommunicationProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;
import java.util.Map;

@Mapper
public interface EqNsbCommunicationMapper extends BaseMapper<EqNsbCommunication>{
    @SelectProvider(type = EqNsbCommunicationProvider.class, method = "getPageQuery")
    List<Map> queryPageList(@Param("nsbCommunicationList") EqNsbCommunication queryConditions);

    //获取总条数
    @SelectProvider(type = EqNsbCommunicationProvider.class, method = "getCountQuery")
    Map<String, Object> getTotalCount(@Param("nsbCommunicationCount") EqNsbCommunication queryConditions);
}
