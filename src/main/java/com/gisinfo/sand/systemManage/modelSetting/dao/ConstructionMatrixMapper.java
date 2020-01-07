package com.gisinfo.sand.systemManage.modelSetting.dao;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gisinfo.sand.commonData.bean.EqTownBuilding;
import com.gisinfo.sand.systemManage.modelSetting.bean.*;
import com.gisinfo.sand.systemManage.modelSetting.condition.UpdateJZJJSSBcondition;
import com.gisinfo.sand.systemManage.modelSetting.condition.UpdateJZPHBcondition;
import com.gisinfo.sand.systemManage.modelSetting.condition.UpdateYScondition;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface ConstructionMatrixMapper extends BaseMapper<ConstructionYS>{

    //---------------建筑矩阵模型--------------------
    //获取建筑物类别下拉框
    @Select("select DISTINCT t.BUILDING_TYPE from T_MODEL_BUILDING t where t.BUILDING_TYPE is NOT NULL")
    List<Map<String,Object>> getBuildingTypeList();

    //根据建筑类型获取建筑易损性矩阵相关数据
    @Select("SELECT t.I,t.J,t.Q,t.Z,t.Y,t.D from T_MODEL_BUILDING t where t.BUILDING_TYPE =#{buildingType} and t.MODEL_TYPE = '易损性矩阵'" +
            " and  t.MODEL_VERSION =#{modelVersion}")
    List<ConstructionYS> getConstructionYSByBuildingType(@Param("buildingType") String buildingType,@Param("modelVersion") String modelVersion);

    //获取建筑破坏比数据
    @Select("select t.BUILDING_TYPE,t.J,t.Q,t.Z,t.Y,t.D from T_MODEL_BUILDING t where t.MODEL_TYPE ='建筑破坏比'" +
            "and  t.MODEL_VERSION =#{modelVersion}")
    List<ConstructionPHB> getConstructionPHB(@Param("modelVersion") String modelVersion);

    //获取建筑经济损失比数据
    @Select("SELECT t.J,t.Q,t.Z,t.Y,t.D from T_MODEL_BUILDING t where t.MODEL_TYPE = '建筑经济损失比'" +
            "and  t.MODEL_VERSION =#{modelVersion}")
    ConstructionJJSSB getConstructionJJSSB(@Param("modelVersion") String modelVersion);

    //获取数据当前版本数
    @Select("select  max(T.MODEL_VERSION) as model_version from T_MODEL_BUILDING t")
    Map<String,Object> getCurrentModelVersion();
    //更新建筑易损性矩阵数据
    @Insert("INSERT INTO T_MODEL_BUILDING t(t.FEATID,t.MODEL_NAME,t.BUILDING_TYPE,t.I,t.J,t.Q,\n" +
            "t.Z,t.Y,t.D,t.MODEL_TYPE,t.MODEL_VERSION,t.CREATE_TIME,t.CREATED_BY,t.UPDATE_TIME\n" +
            ",t.UPDATED_BY) VALUES (#{updateYScondition.featId},#{updateYScondition.modelName},#{updateYScondition.buildingType},#{updateYScondition.i}," +
            "#{updateYScondition.j},#{updateYScondition.q},#{updateYScondition.z},#{updateYScondition.y},#{updateYScondition.d}," +
            "#{updateYScondition.modelType},#{updateYScondition.modelVersion},\n" +
            "to_date(#{updateYScondition.createTime},'yyyy-MM-dd HH24:mi:ss'),#{updateYScondition.createdBy},\n" +
            "to_date(#{updateYScondition.updateTime},'yyyy-MM-dd HH24:mi:ss'),#{updateYScondition.updatedBy})")
    void updateJZYSdata(@Param("updateYScondition") UpdateYScondition updateYScondition);

    //更新建筑破坏比数据
    @Insert("INSERT INTO T_MODEL_BUILDING t(t.FEATID,t.MODEL_NAME,t.BUILDING_TYPE,t.J,t.Q," +
            "t.Z,t.Y,t.D,t.MODEL_TYPE,t.MODEL_VERSION,t.CREATE_TIME,t.CREATED_BY,t.UPDATE_TIME" +
            ",t.UPDATED_BY) VALUES (#{updateJZPHBcondition.featId},#{updateJZPHBcondition.modelName},#{updateJZPHBcondition.buildingType},\n" +
            "#{updateJZPHBcondition.j},#{updateJZPHBcondition.q},#{updateJZPHBcondition.z},#{updateJZPHBcondition.y},#{updateJZPHBcondition.d},\n" +
            "#{updateJZPHBcondition.modelType},#{updateJZPHBcondition.modelVersion}," +
            "to_date(#{updateJZPHBcondition.createTime},'yyyy-MM-dd HH24:mi:ss'),#{updateJZPHBcondition.createdBy}," +
            "to_date(#{updateJZPHBcondition.updateTime},'yyyy-MM-dd HH24:mi:ss'),#{updateJZPHBcondition.updatedBy})")
    void updateJZPHBdata(@Param("updateJZPHBcondition") UpdateJZPHBcondition updateJZPHBcondition);

    //更新建筑经济损失比数据
    @Insert("INSERT INTO T_MODEL_BUILDING t(t.FEATID,t.MODEL_NAME,t.J,t.Q,\n" +
            "t.Z,t.Y,t.D,t.MODEL_TYPE,t.MODEL_VERSION,t.CREATE_TIME,t.CREATED_BY,t.UPDATE_TIME\n" +
            ",t.UPDATED_BY) VALUES (#{updateJZJJSSBcondition.featId},#{updateJZJJSSBcondition.modelName},#{updateJZJJSSBcondition.jbwh},#{updateJZJJSSBcondition.qdph}," +
            "#{updateJZJJSSBcondition.zdph},#{updateJZJJSSBcondition.yzph},#{updateJZJJSSBcondition.hh},#{updateJZJJSSBcondition.modelType},#{updateJZJJSSBcondition.modelVersion},\n" +
            "to_date(#{updateJZJJSSBcondition.createTime},'yyyy-MM-dd HH24:mi:ss'),#{updateJZJJSSBcondition.createdBy},\n" +
            "to_date(#{updateJZJJSSBcondition.updateTime},'yyyy-MM-dd HH24:mi:ss'),#{updateJZJJSSBcondition.updatedBy})")
    void updateJZJJSSBdata(@Param("updateJZJJSSBcondition") UpdateJZJJSSBcondition updateJZJJSSBcondition);

    @Select("select COUNTYNAME county,NAME town from TOWN_BUILDING")
    List<Map<String, Object>> selectCountyTown();



    @Select("select NAME,BRICK_STRUCTURE,OTHER_STRUCTURE,HIGH_RISE,RCFRAME,SINGLE_AREA,TOTAL_AREA from TOWN_BUILDING")
    List<EqTownBuilding> selectTownBuilding();

    /**
     * 查询默认易损性矩阵
     *
     * @return
     */
//    @Select("select * from T_MODEL_BUILDING where DEFAULT_STATUS = 1 and MODEL_TYPE = '易损性矩阵'")
//    List<TModelBuilding> selectDefaultYSXJZ();
    @Select("select * from T_MODEL_BUILDING where MODEL_TYPE = '易损性矩阵' and MODEL_VERSION = (\n" +
            "SELECT MAX(TO_NUMBER(MODEL_VERSION)) FROM T_MODEL_BUILDING WHERE MODEL_TYPE = '易损性矩阵')")
    List<TModelBuilding> selectMaxVersionYSXJZ();

    /**
     * 查询默认建筑破坏比
     * @return
     */
//    @Select("select * from T_MODEL_BUILDING where DEFAULT_STATUS = 1 and MODEL_TYPE = '建筑破坏比'")
//    List<TModelBuilding> selectDefaultJZPHB();
    @Select("select * from T_MODEL_BUILDING where MODEL_TYPE = '建筑破坏比' and MODEL_VERSION = (\n" +
            "SELECT MAX(TO_NUMBER(MODEL_VERSION)) FROM T_MODEL_BUILDING WHERE MODEL_TYPE = '建筑破坏比')")
    List<TModelBuilding> selectMaxVersionJZPHB();

    @Select("select * from T_MODEL_BUILDING")
    List<TModelBuilding> selectTModelBuildings();
}
