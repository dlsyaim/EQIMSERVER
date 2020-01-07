package com.gisinfo.sand.dataManage.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gisinfo.sand.dataManage.bean.FocusTarget;
import com.gisinfo.sand.dataManage.provider.EarthquakeProvider;
import com.gisinfo.sand.dataManage.condition.SelectQueryCondition;
import com.gisinfo.sand.dataManage.bean.EarthquakeAidDecision;
import com.gisinfo.sand.dataManage.bean.EarthquakeDetail;
import com.gisinfo.sand.dataManage.bean.EarthquakeInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;
@Mapper
public interface EarthquakeInfoMapper extends BaseMapper<EarthquakeInfo>{
    /**
     * 分页查询
     * @param page
     * @param earthquakeInfo
     * @return
     */
    @SelectProvider(type=EarthquakeProvider.class,method = "getPageByQuery")
    List<EarthquakeInfo> queryPageList(@Param("earthquakeInfo") EarthquakeInfo queryConditions);
    //获取总条数
    @SelectProvider(type=EarthquakeProvider.class, method = "getEqInfoCountByQuery")
    Map<String,Object> getTotalCount(@Param("earthquakeInfo") EarthquakeInfo queryConditions);
    //查询地震级别下拉列表
    @Select("select DISTINCT  t.EARTHQUAKE_LEVEL  earthquakeLevel from T_EARTHQUAKE_INFO t")
    List<SelectQueryCondition> getEarthquakeLevelList();
    //查询地震深度下拉列表
    @Select("select DISTINCT  t.FOCAL_DEPTH  focalDepth from T_EARTHQUAKE_INFO t")
    List<SelectQueryCondition> getFocalDepthList();
    //查询断层名称下拉列表
    @Select("select DISTINCT  t.FAULT_NAME faultName from T_EARTHQUAKE_INFO t")
    List<SelectQueryCondition> getFaultNameList();
    //查询数据来源下拉列表
    @Select("select DISTINCT  t.DATA_SOURCE dataSource from T_EARTHQUAKE_INFO t")
    List<SelectQueryCondition> getDataSourceList();
    //根据feadId查询地震信息表信息
    @Select("select * from T_EARTHQUAKE_INFO T WHERE FEATID =#{featId,jdbcType=VARCHAR}")
    EarthquakeInfo getEarthquakeInfoById(@Param("featId") String featId);

    //根据地震时间featId查询地震详情详情列表
    @Select("select * from(select t.*,rownum rn from (select * from T_EARTHQUAKE_DETAIL t where t.EARTHQUAKE_FEATID =#{earthquakeFeatId} and rownum<=#{top})t) t where t.rn >#{bottom}")
    List<EarthquakeDetail> getDetailByEqInfoId(@Param("earthquakeFeatId") String earthquakeFeatId, @Param("bottom") Integer bottom, @Param("top") Integer top);

    //根据地震事件Featid查询地震详情总记录数
    @Select("select count(1) count  from T_EARTHQUAKE_DETAIL t where t.EARTHQUAKE_FEATID = #{earthquakeFeatId}")
    Map<String,Object> selectDetailCountByEqId(@Param("earthquakeFeatId") String earthquakeFeatId);

    //根据地震事件FeatId查询地震辅助决策总记录数
    @Select("select count(1) count from T_EARTHQUAKE_AID_DECISION t where t.EARTHQUAKE_FEATID =#{earthquakeFeatId}")
    Map<String,Object> getAidDecisionCountByEqId(String earthquakeFeatId);

    //根据地震事件FeatId查询地震辅助决策列表
    @Select("select * from(select t.*,rownum rn from (select * from T_EARTHQUAKE_AID_DECISION t where t.EARTHQUAKE_FEATID =#{earthquakeFeatId,jdbcType=VARCHAR} and rownum<=#{top})t) t where t.rn >#{bottom}")
    List<EarthquakeAidDecision> getAidDecisionByEqId(@Param("earthquakeFeatId") String earthquakeFeatId, @Param("bottom") Integer bottom, @Param("top") Integer top);

    @Select("select * from T_EARTHQUAKE_AID_DECISION t where t.EARTHQUAKE_FEATID =#{earthquakeFeatId,jdbcType=VARCHAR}")
    EarthquakeAidDecision getAidDetail(@Param("earthquakeFeatId") String earthquakeFeatId);

    //根据地震事件featId查询重点目标列表
    @Select("SELECT * from (SELECT t.*,ROWNUM rn from(SELECT * from T_EARTHQUAKE_FOCUS_SCHOOL t where t.EARTHQUAKE_FEATID =#{earthquakeFeatId} and ROWNUM<=#{top}) t ) t where t.rn > #{bottom}")
    List<FocusTarget> getFocusTargetByEqId(@Param("earthquakeFeatId") String earthquakeFeatId,@Param("bottom") Integer bottom,@Param("top") Integer top);

    //根据地震事件featId查询重点目标总记录数
    @Select("SELECT count(1) count from T_EARTHQUAKE_FOCUS_SCHOOL t where t.EARTHQUAKE_FEATID = #{earthquakeFeatId}")
    Map<String,Object> getFocusTargetCountByEqId(String earthquakeFeatId);

    @Insert("INSERT INTO T_EARTHQUAKE_INFO(FEATID,DATA_SOURCE,EARTHQUAKE_NAME,EARTHQUAKE_TIME,EARTHQUAKE_LEVEL,EARTHQUAKE_LOCATION,LONGITUDE," +
            "LATITUDE,FOCAL_DEPTH,FAULT_NAME,REPTURE_DIRECTION,ANALYSIS_DATA,MODEL_ID,BATCH_NUMBER,PROVINCE,CITY,COUNTY,TOWN) VALUES" +
            "(#{eqInfoList.featid,jdbcType=VARCHAR},#{eqInfoList.dataSource,jdbcType=VARCHAR},#{eqInfoList.earthquakeName,jdbcType=VARCHAR},#{eqInfoList.earthquakeTime,jdbcType=DATE}," +
            "#{eqInfoList.earthquakeLevel,jdbcType=DOUBLE},#{eqInfoList.earthquakeLocation,jdbcType=VARCHAR},#{eqInfoList.longitude,jdbcType=DOUBLE},#{eqInfoList.latitude,jdbcType=DOUBLE}," +
            "#{eqInfoList.focalDepth,jdbcType=DOUBLE},#{eqInfoList.faultName,jdbcType=VARCHAR},#{eqInfoList.reptureDirection,jdbcType=VARCHAR},#{eqInfoList.analysisData,jdbcType=VARCHAR}," +
            "#{eqInfoList.modelId,jdbcType=VARCHAR},#{eqInfoList.batchNumber,jdbcType=INTEGER},#{eqInfoList.province,jdbcType=VARCHAR},#{eqInfoList.city,jdbcType=VARCHAR},#{eqInfoList.county,jdbcType=VARCHAR}," +
            "#{eqInfoList.town,jdbcType=VARCHAR})")
    Integer addEqInfo(@Param("eqInfoList")EarthquakeInfo earthquakeInfo);

}
