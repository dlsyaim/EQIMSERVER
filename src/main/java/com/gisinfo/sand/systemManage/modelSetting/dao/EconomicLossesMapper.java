package com.gisinfo.sand.systemManage.modelSetting.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gisinfo.sand.systemManage.modelSetting.bean.EconomicLosses;
import com.gisinfo.sand.systemManage.modelSetting.bean.TEarthquakeDetail;
import com.gisinfo.sand.systemManage.modelSetting.condition.UpdateEconomicLossesCondition;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface EconomicLossesMapper extends BaseMapper<EconomicLosses>{
    //获取最新模型版本号
    @Select("SELECT max(t.MODEL_VERSION) as model_version from T_MODEL_ECONOMIC_LOSSES t")
    Map<String,Object> getNewestModelVersion();

    //获取最新的经济损失数据
    @Select("SELECT * from  T_MODEL_ECONOMIC_LOSSES t where t.FORMULA ='经济损失-按烈度' and t.MODEL_VERSION = #{modelVersion}")
    List<EconomicLosses> getEconomicLosses(String modelVersion);

    //更新经济损失数据
    @Insert("INSERT INTO T_MODEL_ECONOMIC_LOSSES t(t.FEATID,t.PARAM_NAME,t.I,t.ECONOMIC_LOSSES,\n" +
            "t.FORMULA,t.MODEL_VERSION,t.CREATE_TIME,t.CREATED_BY,t.UPDATE_TIME,t.UPDATED_BY)\n" +
            "VALUES (#{featId},#{paramName},#{i},#{economicLosses},#{formula},#{modelVersion},to_date(#{createTime},'yyyy-MM-dd HH24:mi:ss'),\n" +
            "#{updatedBy},to_date(#{updateTime},'yyyy-MM-dd HH24:mi:ss'),#{updatedBy})")
    void updateEconomicLosses(UpdateEconomicLossesCondition updateEconomicLossesCondition);

    @Select("select ECONOMIC_LOSSES from T_MODEL_ECONOMIC_LOSSES where I = #{I} and FORMULA = #{formula} and DEFAULT_STATUS = 1")
    double selectParam(@Param("I") String I, @Param("formula") String formula);

    @Update("update T_EARTHQUAKE_DETAIL set DIRECT_ECONOMIC_LOSS = #{economicLosses} where EARTHQUAKE_FEATID = #{earthquakeFeatid} and TOWN_NAME = #{townName}")
    void updateEconomicLoss(TEarthquakeDetail detail);

}
