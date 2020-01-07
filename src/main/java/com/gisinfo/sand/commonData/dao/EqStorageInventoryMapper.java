package com.gisinfo.sand.commonData.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gisinfo.sand.commonData.bean.EqStorageInventory;
import com.gisinfo.sand.commonData.provider.EqStorageInventoryProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;
import java.util.Map;

@Mapper
public interface EqStorageInventoryMapper extends BaseMapper<EqStorageInventory>{
    @SelectProvider(type = EqStorageInventoryProvider.class, method = "getPageQuery")
    List<Map> queryPageList(@Param("storageInventoryList") EqStorageInventory queryConditions);

    //获取总条数
    @SelectProvider(type = EqStorageInventoryProvider.class, method = "getCountQuery")
    Map<String, Object> getTotalCount(@Param("storageInventoryCount") EqStorageInventory queryConditions);
}
