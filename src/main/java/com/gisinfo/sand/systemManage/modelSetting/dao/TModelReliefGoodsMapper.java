package com.gisinfo.sand.systemManage.modelSetting.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gisinfo.sand.systemManage.modelSetting.bean.TModelReliefGoods;
import com.gisinfo.sand.systemManage.modelSetting.provider.RelieGoodsProvider;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface TModelReliefGoodsMapper extends BaseMapper<TModelReliefGoods>{

    //获取救援物资模型最新版本号
    @Select("select max(t.MODEL_VERSION) max_version from T_MODEL_FOOD t")
    Map<String,Object> getMaxVersion();

    //添加救援物资模型参数
    @SelectProvider(type= RelieGoodsProvider.class,method = "addRelieGoodParams")
    void addRelieGoodParams(Map<String,Object> data);

    //查询最新版本的救援物资模型所有参数
    @Select("select * from T_MODEL_FOOD t where t.MODEL_VERSION = #{maxVersion}")
    List<Map<String,Object>> getRelieGoodsParams(String maxVersion);

    //获取最新的帐篷模型参数
    @SelectProvider(type= RelieGoodsProvider.class,method = "getModelParamsByType")
    Map<String,Object> getModelParamsByType(Map<String,Object> params);

    //添加计算帐篷模型所得帐篷数
    @Update("update T_EARTHQUAKE_AID_DECISION t set t.TENT_DEMAND\n" +
            "= #{tentDemand} where t.EARTHQUAKE_FEATID =#{earthquakeFeatId} and t.TOWN_NAME = #{townName}")
    void addTentDemand(Map<String,Object> data);

    //添加计算灾后粮食补助模型所得粮食数
    @Update("update T_EARTHQUAKE_AID_DECISION t set t.FOOD_SUBSIDY\n" +
            "= #{foodSubsidy} where t.EARTHQUAKE_FEATID =#{earthquakeFeatId} and t.TOWN_NAME = #{townName}")
    void addFoodSubsidy(Map<String,Object> data);

    //添加计算棉被模型所得棉被数
    @Update("update T_EARTHQUAKE_AID_DECISION t set t.QUILT_DEMAND\n" +
            "= #{quiltDemand} where t.EARTHQUAKE_FEATID =#{earthquakeFeatId} and t.TOWN_NAME = #{townName}")
    void addQuiltDemand(Map<String,Object> data);

    //添加计算应急清洁饮水模型所得water数
    @Update("update T_EARTHQUAKE_AID_DECISION t set t.EMERGENCY_WATER_DEMAND\n" +
            "= #{emergencyWater} where t.EARTHQUAKE_FEATID =#{earthquakeFeatId} and t.TOWN_NAME = #{townName}")
    void addWaterDemand(Map<String,Object> data);

    //添加计算衣服模型所得衣服数
    @Update("update T_EARTHQUAKE_AID_DECISION t set t.CLOTHING_DEMAND\n" +
            "= #{clothingDemand} where t.EARTHQUAKE_FEATID =#{earthquakeFeatId} and t.TOWN_NAME = #{townName}")
    void addClothingDemand(Map<String,Object> data);

    //添加计算毛毯模型所得毛毯数
    @Update("update T_EARTHQUAKE_AID_DECISION t set t.BLANKET_DEMAND\n" +
            "= #{blanketDemand} where t.EARTHQUAKE_FEATID =#{earthquakeFeatId} and t.TOWN_NAME = #{townName}")
    void addBlanketDemand(Map<String,Object> data);

    //添加计算担架模型所得担架数
    @Update("update T_EARTHQUAKE_AID_DECISION t set t.STRETCHER_DEMAND\n" +
            "= #{stretcherDemand} where t.EARTHQUAKE_FEATID =#{earthquakeFeatId} and t.TOWN_NAME = #{townName}")
    void addstretcherDemand(Map<String,Object> data);

    //添加计算临时厕所模型所得厕所数
    @Update("update T_EARTHQUAKE_AID_DECISION t set t.TEMPORARY_TOILET_DEMAND\n" +
            "= #{temporaryToilet} where t.EARTHQUAKE_FEATID =#{earthquakeFeatId} and t.TOWN_NAME = #{townName}")
    void addTemporaryToiletDemand(Map<String,Object> data);
}
