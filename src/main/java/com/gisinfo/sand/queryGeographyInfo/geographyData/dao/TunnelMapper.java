package com.gisinfo.sand.queryGeographyInfo.geographyData.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gisinfo.sand.queryGeographyInfo.geographyData.bean.Tunnel;
import com.gisinfo.sand.queryGeographyInfo.geographyData.condition.TunnelCondition;
import com.gisinfo.sand.queryGeographyInfo.geographyData.provider.TunnelProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;
import java.util.Map;

//隧道执行sql接口
@Mapper
public interface TunnelMapper extends BaseMapper<Tunnel> {

    //查询隧道类别下拉列表
    @SelectProvider(type= TunnelProvider.class,method = "getTunnelClassList")
    List<Map<String,Object>> getTunnelClassList();

    //查询隧道等级下拉列表
    @SelectProvider(type= TunnelProvider.class,method = "getTunnelGradeList")
    List<Map<String,Object>> getTunnelGradeList();

    //查询隧道总记录条数
    @SelectProvider(type= TunnelProvider.class,method = "getTunnelCount")
    Map<String,Object> getTunnelCount(TunnelCondition tunnelCondition);

    //查询隧道数据列表
    @SelectProvider(type= TunnelProvider.class,method = "getTunnelList")
    List<Tunnel> getTunnelList(TunnelCondition tunnelCondition);
}
