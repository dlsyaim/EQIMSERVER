package com.gisinfo.sand.commonData.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gisinfo.sand.commonData.bean.EqMedical;
import com.gisinfo.sand.commonData.provider.EqMedicalProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;
import java.util.Map;

@Mapper
public interface EqMedicalMapper extends BaseMapper<EqMedical>{
    @SelectProvider(type = EqMedicalProvider.class, method = "getPageQuery")
    List<Map> queryPageList(@Param("medicalList") EqMedical queryConditions);

    //获取总条数
    @SelectProvider(type = EqMedicalProvider.class, method = "getCountQuery")
    Map<String, Object> getTotalCount(@Param("medicalCount") EqMedical queryConditions);
}
