package com.gisinfo.sand.commonData.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gisinfo.sand.commonData.bean.EqLocalGovCommunication;
import com.gisinfo.sand.commonData.provider.EqLocalGovCommunicationProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;
import java.util.Map;

@Mapper
public interface EqLocalGovCommunicationMapper extends BaseMapper<EqLocalGovCommunication>{
    @SelectProvider(type = EqLocalGovCommunicationProvider.class, method = "getPageQuery")
    List<Map> queryPageList(@Param("govCommunicationList") EqLocalGovCommunication queryConditions);

    //获取总条数
    @SelectProvider(type = EqLocalGovCommunicationProvider.class, method = "getCountQuery")
    Map<String, Object> getTotalCount(@Param("govCommunicationCount") EqLocalGovCommunication queryConditions);
}
