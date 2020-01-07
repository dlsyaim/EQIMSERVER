package com.gisinfo.sand.systemManage.modelSetting.dao;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface TModelSettingMapper {

//    @Select("select FORMULA from T_MODEL_SETTING where MODEL_TABLE_NAME = #{modelTableName}")
//    String selectFORMULAByMN(@Param("modelTableName")String modelTableName);
}
