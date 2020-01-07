package com.gisinfo.sand.commonData.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gisinfo.sand.commonData.bean.EqEconomy;
import com.gisinfo.sand.commonData.provider.EqEconomyProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;
import java.util.Map;

@Mapper
public interface EqEconomyMapper extends BaseMapper<EqEconomy> {
    @SelectProvider(type = EqEconomyProvider.class, method = "getPageQuery")
    List<Map> queryPageList(@Param("eqEconomyList") EqEconomy queryConditions);

    //获取总条数
    @SelectProvider(type = EqEconomyProvider.class, method = "getCountQuery")
    Map<String, Object> getTotalCount(@Param("eqEconomyCount") EqEconomy queryConditions);

}
