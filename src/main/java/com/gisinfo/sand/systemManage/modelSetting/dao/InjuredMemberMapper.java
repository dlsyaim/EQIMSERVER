package com.gisinfo.sand.systemManage.modelSetting.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gisinfo.sand.systemManage.modelSetting.bean.InjuredALD;
import com.gisinfo.sand.systemManage.modelSetting.bean.InjuredAZJ;
import com.gisinfo.sand.systemManage.modelSetting.bean.TEarthquakeDetail;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Mapper
public interface InjuredMemberMapper extends BaseMapper<InjuredALD> {
    //---------------受伤人员模型------------------
    //查询当前版本数
    @Select("select  max(to_number(t.MODEL_VERSION)) as model_version from T_MODEL_INJURED t")
    Map<String,Object> getInjuredNewestVersion();
    //查询受伤人员按震级数据
    @Select("select * from T_MODEL_INJURED t where t.FORMULA ='按震级' and t.MODEL_VERSION =#{modelVersion}")
    List<InjuredAZJ> getInjuredAZJ(@Param("modelVersion") Integer modelVersion);

    //查询受伤人员按烈度
    @Select("select * from T_MODEL_INJURED t where t.FORMULA ='按烈度' and t.MODEL_VERSION =#{modelVersion}")
    List<InjuredALD> getInjuredALD(@Param("modelVersion") Integer modelVersion);

    //更新受伤人员按震级数据和L0
    @Update("INSERT into T_MODEL_INJURED t(t.FEATID,t.PARAM_NAME,t.L0,t.SCALE,t.PERCENT_INJURED,t.FORMULA,t.MODEL_VERSION,t.CREATE_TIME,\n" +
            "t.CREATED_BY,t.UPDATE_TIME,t.UPDATED_BY) VALUES (#{injuredAZJ.featId},#{injuredAZJ.paramName},#{injuredAZJ.l0},#{injuredAZJ.scale},#{injuredAZJ.percentInjured},#{injuredAZJ.formula},#{injuredAZJ.modelVersion},to_date(#{injuredAZJ.createTime},'yyyy-MM-dd HH24:mi:ss'),\n" +
            "#{injuredAZJ.createdBy},to_date(#{injuredAZJ.updateTime},'yyyy-MM-dd HH24:mi:ss'),#{injuredAZJ.updatedBy})")
    void updateInjuredAZJ(@Param("injuredAZJ") InjuredAZJ injuredAZJ);

    //更新受伤人员按烈度数据和L0
    @Update("INSERT into T_MODEL_INJURED t(t.FEATID,t.PARAM_NAME,t.L0,t.SCALE,t.PERCENT_INJURED,t.FORMULA,t.MODEL_VERSION,t.CREATE_TIME,\n" +
            "t.CREATED_BY,t.UPDATE_TIME,t.UPDATED_BY) VALUES (#{injuredALD.featId},#{injuredALD.paramName},#{injuredALD.l0},#{injuredALD.scale},#{injuredALD.percentInjured},#{injuredALD.formula},#{injuredALD.modelVersion},to_date(#{injuredALD.createTime},'yyyy-MM-dd HH24:mi:ss'),\n" +
            "#{injuredALD.createdBy},to_date(#{injuredALD.updateTime},'yyyy-MM-dd HH24:mi:ss'),#{injuredALD.updatedBy})")
    void updateInjuredALD(@Param("injuredALD") InjuredALD injuredALD);

//    @Select("select FORMULA from T_MODEL_SETTING where MODEL_TABLE_NAME = 'T_MODEL_INJURED'")
//    String selectInjuredFormula();

    @Select("select PERCENT_INJURED percentInjured,L0 from T_MODEL_INJURED where FORMULA =  #{formula} and SCALE = #{scale} and DEFAULT_STATUS = 1")
    Map<String, BigDecimal> selectpercentInjured(@Param("formula") String formula, @Param("scale") String scale);


//    @Select("select SCALE, PERCENT_INJURED from T_MODEL_INJURED where FORMULA =  #{formula} and DEFAULT_STATUS = 1")
//    List<Map<String, Object>> selectScaleInjured(@Param("formula") String formula);

    @Select("SELECT SCALE,PERCENT_INJURED FROM T_MODEL_INJURED WHERE FORMULA = #{formula} \n" +
            "\tAND MODEL_VERSION = (SELECT MAX(TO_NUMBER(MODEL_VERSION)) FROM T_MODEL_INJURED WHERE FORMULA = #{formula})")
    List<Map<String, Object>> selectInjuredModelMaxVersion(@Param("formula") String formula);

    @Update("update T_EARTHQUAKE_DETAIL set INJURED_NUMBER = #{injuredNumber} where EARTHQUAKE_FEATID = #{earthquakeFeatid} and TOWN_NAME = #{townName}")
    void updateInjuredNum(TEarthquakeDetail detail);

}
