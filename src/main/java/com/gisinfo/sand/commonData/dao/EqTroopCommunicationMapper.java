package com.gisinfo.sand.commonData.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gisinfo.sand.commonData.bean.EqTroopCommunication;
import com.gisinfo.sand.commonData.provider.EqTroopCommunicationProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;
import java.util.Map;

@Mapper
public interface EqTroopCommunicationMapper extends BaseMapper<EqTroopCommunication>{
    @SelectProvider(type = EqTroopCommunicationProvider.class, method = "getPageQuery")
    List<Map> queryPageList(@Param("troopCommunicationList") EqTroopCommunication queryConditions);

    //获取总条数
    @SelectProvider(type = EqTroopCommunicationProvider.class, method = "getCountQuery")
    Map<String, Object> getTotalCount(@Param("troopCommunicationCount") EqTroopCommunication queryConditions);
}
