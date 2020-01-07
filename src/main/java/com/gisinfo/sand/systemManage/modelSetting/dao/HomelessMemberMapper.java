package com.gisinfo.sand.systemManage.modelSetting.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gisinfo.sand.systemManage.modelSetting.bean.HomelessMember;
import com.gisinfo.sand.systemManage.modelSetting.bean.TModelHomeless;
import com.gisinfo.sand.systemManage.modelSetting.bean.TModelInjured;
import com.gisinfo.sand.systemManage.modelSetting.condition.UpdateHomelessMemberCondition;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

@Mapper
public interface HomelessMemberMapper extends BaseMapper<HomelessMember>{
    //查询最新版本号
    @Select("SELECT max(t.MODEL_VERSION) as model_version from T_MODEL_HOMELESS t")
    Map<String,Object> getNewestModelVersion();

    //查询最新无家可归人员模型数据
    @Select("SELECT * from T_MODEL_HOMELESS t where t.MODEL_VERSION =#{modelVersion}")
    List<HomelessMember> getHomelessMember(String modelVersion);

    //更新无家可归人员模型数据
    @Update("INSERT INTO T_MODEL_HOMELESS t(t.FEATID,t.PARAM_NAME,t.I,t.PROPORTION_LOW,\n" +
            "t.PROPORTION_MEDIUM,t.PROPORTION_HIGH,t.FORMULA,t.MODEL_VERSION,t.CREATE_TIME,\n" +
            "t.CREATED_BY,t.UPDATE_TIME,t.UPDATED_BY) VALUES (#{featId},#{paramName},#{i},#{proportionLow},#{proportionMedium},#{proportionHigh},\n" +
            "#{formula},#{modelVersion},to_date(#{createTime},'yyyy-MM-dd HH24:mi:ss'),#{createdBy},\n" +
            "to_date(#{updateTime},'yyyy-MM-dd HH24:mi:ss'),#{updatedBy})")
    void updateHomelessMember(UpdateHomelessMemberCondition updateHomelessMemberCondition);

//    @Select("select PROPORTION_LOW from T_MODEL_HOMELESS where FORMULA = #{FORMULA} and I = #{scale} and DEFAULT_STATUS = 1")
//    Double selectProportionLow(@Param("FORMULA") String formula, @Param("scale") String scale);


    @Select("SELECT * FROM T_MODEL_HOMELESS WHERE MODEL_VERSION = (\n" +
            "SELECT MAX(TO_NUMBER(MODEL_VERSION)) FROM T_MODEL_HOMELESS)")
    List<TModelHomeless> selectMaxVersionModel();
}
