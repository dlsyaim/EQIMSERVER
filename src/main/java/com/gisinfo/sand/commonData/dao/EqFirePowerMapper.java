package com.gisinfo.sand.commonData.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gisinfo.sand.commonData.bean.EqFirePower;
import com.gisinfo.sand.commonData.provider.EqFirePowerProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;
import java.util.Map;

@Mapper
public interface EqFirePowerMapper extends BaseMapper<EqFirePower>{
    @SelectProvider(type = EqFirePowerProvider.class, method = "getPageQuery")
    List<Map> queryPageList(@Param("firePowerList") EqFirePower queryConditions);

    //获取总条数
    @SelectProvider(type = EqFirePowerProvider.class, method = "getCountQuery")
    Map<String, Object> getTotalCount(@Param("firePowerCount") EqFirePower queryConditions);
}
