package com.gisinfo.sand.systemManage.modelSetting.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gisinfo.sand.systemManage.modelSetting.bean.ConstructionPHB;
import com.gisinfo.sand.systemManage.modelSetting.bean.TEarthquakeInfo;
import com.gisinfo.sand.systemManage.modelSetting.provider.CalcModelProvider;
import org.apache.ibatis.annotations.*;

import javax.naming.event.ObjectChangeListener;
import java.util.List;
import java.util.Map;

@Mapper
public interface CalcModelMapper extends BaseMapper<ConstructionPHB>{
    //根据地震叠加分析数据类型
    @SelectProvider(type= CalcModelProvider.class,method = "getDataType")
    Map<String,String> getDataType(String earthquakeId);
    //根据数据类型查询叠加分析的结果数据
    @SelectProvider(type=CalcModelProvider.class,method = "getAnalysisData")
    List<Map<String,Object>> getAnalysisData(Map<String,Object> params);
    //-------建筑矩阵模型
    //获取当前版本数
    @Select("select  max(T.MODEL_VERSION) as model_version from T_MODEL_BUILDING t")
    Map<String,Object> getCurrentBuildingModelVersion();

    //根据建筑类型和地震烈度查询建筑易损性建筑
    @Select("SELECT t.J as jbwh,t.Q as qdph,t.Z as zdph,t.Y yzph,t.D as hh from T_MODEL_BUILDING t where t.BUILDING_TYPE =#{buildingType} and t.MODEL_TYPE = '易损性矩阵' and t.I=#{ld}" +
            " and t.MODEL_VERSION=#{modelVersion}")
    Map<String,Object> getJZYSdataBy(@Param("buildingType") String buildingType,@Param("ld") Integer ld,@Param("modelVersion") String modelVersion);

    //根据建筑类型获取建筑破坏比数据
    @Select("SELECT t.J as jbwh,t.Q as qdph,t.Z as zdph,t.Y yzph,t.D as hh from T_MODEL_BUILDING t where t.BUILDING_TYPE =#{buildingType} and t.MODEL_TYPE = '建筑破坏比'" +
            " and t.MODEL_VERSION=#{modelVersion}")
    Map<String,Object> getJZPHBdataBy(@Param("buildingType") String buildingType,@Param("modelVersion") String modelVersion);

    //添加建筑破坏比数据
    @Insert("insert into T_EARTHQUAKE_DETAIL t(t.FEATID,t.EARTHQUAKE_FEATID,t.TOWN_NAME,t.STRUCTURE_J,t.STRUCTURE_Q,t.STRUCTURE_Z,t.STRUCTURE_Y,t.STRUCTURE_D)" +
            "values (#{featId},#{earthquakeFeatId},#{townName},#{jbwh},#{qdph},#{zdph},#{yzph},#{hh})")
    void addJZPHBdata(Map<String,Object> data);
    //查询建筑经济损失比
    @Select("select  t.J as jbwh,t.Q as qdph,t.Z as zdph,t.Y yzph,t.D as hh from T_MODEL_BUILDING t where t.MODEL_TYPE ='建筑经济损失比'" +
            " and t.MODEL_VERSION=#{modelVersion}")
    Map<String,Object> getJZJJSSB(@Param("modelVersion") String modelVersion);

    //获取死亡人员模型中震害预测的值
    @Select("select sum(t.D) as zhyc from T_MODEL_BUILDING t where MODEL_TYPE ='建筑破坏比' and t.MODEL_VERSION = #{modelVersion}")
    Map<String,Object> getZHYC(@Param("modelVersion") String modelVersion);
    //将计算出的建筑破坏比数据添加到地震事件详情表
    //@Insert("")

    //----------受伤人员模型
    //获取当前版本数
    @Select("select  max(T.MODEL_VERSION) as model_version from T_MODEL_INJURED t\n")
    Map<String,Object> getCurrentInjuredModelVersion();
    //获取参数L0
    @Select("select DISTINCT t.L0 from T_MODEL_INJURED t where t.MODEL_VERSION = #{modelVersion}")
    Map<String,Object> getL0(@Param("modelVersion") Integer modelVersion);

    //根据地震震级获取受伤人员参数
    @Select("select t.PERCENT_INJURED from T_MODEL_INJURED t\n" +
            "where t.FORMULA ='按震级' and t.SCALE=#{dzzj} and t.MODEL_VERSION = #{modelVersion}")
    Map<String,Object> getSSRYAZJ(@Param("dzzj") Integer dzzj,@Param("modelVersion") Integer modelVersion);

    //根据地震烈度获取受伤人员参数
    @Select("select t.PERCENT_INJURED from T_MODEL_INJURED t\n" +
            "where t.FORMULA ='按烈度' and t.SCALE=#{dzld} and t.MODEL_VERSION = #{modelVersion}")
    Map<String,Object> getSSRYALD(@Param("dzld") String dzld,@Param("modelVersion") Integer modelVersion);

    //--------无家可归人员模型
    //获取无家可归人员模型当前参数版本号
    @Select("SELECT max(t.MODEL_VERSION) as MODEL_VERSION from T_MODEL_HOMELESS t")
    public Map<String,Object> getCurrentHomelessModelVersion();
    //计算无家可归模型，无家可归人数,
    @Select("SELECT t.PROPORTION_LOW from T_MODEL_HOMELESS t where t.I=#{dzld} and t.FORMULA='需紧急安置' and t.MODEL_VERSION=#{modelVersion}")
    Map<String,Object> getProportionLow( @Param("dzld") String dzld,@Param("modelVersion") String modelVersion);


    //-------经济损失模型
    //获取经济损失模型当前参数版本
    @Select("SELECT max(t.MODEL_VERSION) as MODEL_VERSION from T_MODEL_ECONOMIC_LOSSES t")
    Map<String,Object> getCurrentEconomicLossesModelVersion();
    //获取经济损失模型数据
    @Select("SELECT t.ECONOMIC_LOSSES,i from T_MODEL_ECONOMIC_LOSSES t where t.I =#{dzld} and t.FORMULA='经济损失-按烈度' and t.MODEL_VERSION=#{modelVersion}")
    Map<String,Object> getEconomicLosses(@Param("dzld") String dzld,@Param("modelVersion") String modelVersion);

    //根据地震获取详情街道名称、无家可归人数、受伤人数、死亡人数
    @Select("select t.TOWN_NAME,t.DEATH_NUMBER,t.INJURED_NUMBER,t.EMERGENCY_REHOUSING_NUMBER\n" +
            "as homeless_number from T_EARTHQUAKE_DETAIL t\n" +
            "where t.EARTHQUAKE_FEATID =#{earthquakeId}")
    List<Map<String,Object>> getTownNameAndhomelessAndInjuredAndDeath(String earthquakeId);

    @Select("select TOWN_NAME,nvl(AFFECTED_AREA,0) AFFECTED_AREA,INTENSITY from T_ANALYSIS_TOWN where EARTHQUAKE_FEATID = #{earthquakeFeatid}")
    List<Map<String,Object>> getTownEffectedArea(String earthquakeFeatid);

    @Select("select * from T_EARTHQUAKE_INFO where FEATID = #{earthquakeFeatid}")
    TEarthquakeInfo getTEarthquakeInfoByFeatid(String earthquakeFeatid);
}
