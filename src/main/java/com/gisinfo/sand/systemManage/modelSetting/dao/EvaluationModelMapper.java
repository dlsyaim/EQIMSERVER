package com.gisinfo.sand.systemManage.modelSetting.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gisinfo.sand.systemManage.modelSetting.bean.EconomicLosses;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface EvaluationModelMapper extends BaseMapper<EconomicLosses> {

    //查询评估模型Mapping数据
    @Select("select * from T_MODEL_MAPPING t")
    List<Map<String,String>> getModelMappingData();

    //获取模型默认参数最大版本号
    @Select("select max(t.MODEL_VERSION) as max_version from T_MODEL_SETTING t")
    Map<String,String> getModelSettingMaxVersion();

    //添加模型默认参数
    @Insert("insert into T_MODEL_SETTING t(t.FEATID,t.DESCRIPTION,t.MODEL_OPTION,t.MODEL_VERSION,t.CREATE_TIME,\n" +
            "                              t.CREATED_BY,t.UPDATE_TIME,t.UPDATED_BY)\n" +
            "                              values (#{featId},#{description},#{modelOption}," +
            "#{modelVersion},to_date(#{createTime},'yyyy-mm-dd HH24:mi:ss'),\n" +
            "                                      #{createdBy},to_date(#{updateTime},'yyyy-mm-dd HH24:mi:ss'),\n" +
            "                                      #{updatedBy})")
    void addModelSettingData(Map<String,String> data);

    /**
     * 查询默认模型参数
     * @param modelVersion
     * @return
     */
    @Select("select t.DESCRIPTION,t.MODEL_OPTION from T_MODEL_SETTING t\n" +
            "where t.MODEL_VERSION = #{modelVersion}")
    List<Map<String,String>> getDefautModel(String modelVersion);
}
