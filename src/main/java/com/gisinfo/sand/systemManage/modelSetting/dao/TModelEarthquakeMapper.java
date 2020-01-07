package com.gisinfo.sand.systemManage.modelSetting.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gisinfo.sand.systemManage.modelSetting.bean.TModelEarthquake;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Map;

@Mapper
public interface TModelEarthquakeMapper extends BaseMapper<TModelEarthquake>{

    @Insert("INSERT INTO T_MODEL_EARTHQUAKE_SETTING(FEATID,PARAM_NAME,MODEL_NAME,FORMULA_FROM,L1,L2,L3,L4,S1,S2,S3,S4,L,V,MAX_INTENSITY_CIRCULAR," +
            "MIN_INTENSITY_EFFECT,IF_LINE_SOURCE_FIELDS,IF_OFFSET,CREATE_TIME,CREATED_BY,UPDATE_TIME,UPDATED_BY,MODEL_VERSION) VALUES" +
            "(#{eqList.featid},#{eqList.paramName},#{eqList.modelName,jdbcType=VARCHAR},#{eqList.formulaFrom,jdbcType=VARCHAR}," +
            "#{eqList.l1,jdbcType=DOUBLE},#{eqList.l2,jdbcType=DOUBLE},#{eqList.l3,jdbcType=DOUBLE},#{eqList.l4,jdbcType=DOUBLE}," +
            "#{eqList.s1,jdbcType=DOUBLE},#{eqList.s2,jdbcType=DOUBLE},#{eqList.s3,jdbcType=DOUBLE},#{eqList.s4,jdbcType=DOUBLE}," +
            "#{eqList.l,jdbcType=DOUBLE},#{eqList.v,jdbcType=DOUBLE},#{eqList.maxIntensityCircular,jdbcType=VARCHAR}," +
            "#{eqList.minIntensityEffect,jdbcType=VARCHAR},#{eqList.ifLineSourceFields,jdbcType=VARCHAR},#{eqList.ifOffset,jdbcType=VARCHAR},to_date(#{eqList.createTime},'yyyy-mm-dd hh24:mi:ss')," +
            "#{eqList.createdBy},to_date(#{eqList.updateTime},'yyyy-mm-dd hh24:mi:ss'),#{eqList.updatedBy},#{eqList.modelVersion})")
    Integer addEarthquake(@Param("eqList") TModelEarthquake modelEarthquake);

    @Select("select * from  T_MODEL_EARTHQUAKE_SETTING where FEATID=#{featId,jdbcType=VARCHAR}")
    TModelEarthquake getObjectParam(String featId);

    //获取救援队伍表中当前最大的版本号
    @Select("select max(t.MODEL_VERSION) max_version from T_MODEL_EARTHQUAKE_SETTING t")
    Map<String,Object> getMaxVersion();


    //查询救援队伍模型所有参数
    @Select("select * from T_MODEL_EARTHQUAKE_SETTING t where t.model_version = #{maxVersion}")
    Map<String, Object> getEarthquakeParams(String maxVersion);
}
