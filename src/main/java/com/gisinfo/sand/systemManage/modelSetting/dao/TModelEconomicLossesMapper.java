package com.gisinfo.sand.systemManage.modelSetting.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gisinfo.sand.systemManage.modelSetting.bean.TModelEconomicLosses;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * 经济损失模型参数表 Mapper 接口
 * </p>
 *
 * @since 2020-01-03
 */
@Mapper
public interface TModelEconomicLossesMapper extends BaseMapper<TModelEconomicLosses> {

    @Select("SELECT * FROM T_MODEL_ECONOMIC_LOSSES WHERE MODEL_VERSION = (\n" +
            "SELECT MAX(TO_NUMBER(MODEL_VERSION)) FROM T_MODEL_ECONOMIC_LOSSES)")
    List<TModelEconomicLosses> selectMaxVersionModel();
}
