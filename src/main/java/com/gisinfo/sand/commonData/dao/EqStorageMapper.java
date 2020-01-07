package com.gisinfo.sand.commonData.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gisinfo.sand.commonData.bean.EqStorage;
import com.gisinfo.sand.commonData.provider.EqStorageProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;
import java.util.Map;

@Mapper
public interface EqStorageMapper extends BaseMapper<EqStorage>{
    @SelectProvider(type = EqStorageProvider.class, method = "getPageQuery")
    List<EqStorage> queryPageList(@Param("storageList") EqStorage queryConditions);

    //获取总条数
    @SelectProvider(type = EqStorageProvider.class, method = "getCountQuery")
    Map<String, Object> getTotalCount(@Param("storageCount") EqStorage queryConditions);
}
