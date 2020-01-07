package com.gisinfo.sand.systemManage.modelSetting.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gisinfo.sand.systemManage.modelSetting.bean.BuriedACSBL;
import com.gisinfo.sand.systemManage.modelSetting.bean.BuriedAJZBL;
import com.gisinfo.sand.systemManage.modelSetting.condition.UpdateBuriedACSBLcondition;
import com.gisinfo.sand.systemManage.modelSetting.condition.UpdateBuriedAJZBLcondition;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface BuriedMemberMapper extends BaseMapper<BuriedAJZBL>{
    //查询最新参数版本号
    @Select("SELECT MAX(T.MODEL_VERSION) model_version FROM T_MODEL_BURIED T")
    Map<String,Object> getNewestmodelVersion();

    //根据版本号查询最新建筑比例数据
    @Select("SELECT * from T_MODEL_BURIED t where t.MODEL_VERSION =#{modelVersion} and t.FORMULA = '按建筑比例'")
    List<BuriedAJZBL> getBuriedAZJBL(String modelVersion);

    //根据版本号查询最新城市比例数据
    @Select("SELECT * from T_MODEL_BURIED t where t.MODEL_VERSION =#{modelVersion} and t.FORMULA = '按城市比例'")
    List<BuriedACSBL> getBuriedACSBL(String modelVersion);

    //更新压埋人员按建筑比例模型数据
    @Insert("INSERT INTO T_MODEL_BURIED t(t.FEATID,t.PARAM_NAME,t.CATEGORY,t.PERCENT_BURIED,\n" +
            "t.FORMULA,t.MODEL_VERSION,t.CREATE_TIME,t.CREATED_BY,t.UPDATE_TIME,t.UPDATED_BY)\n" +
            "VALUES (#{featId},#{paramName},#{category},#{percentBuried},#{formula},#{modelVersion},to_date(#{createTime},'yyyy-MM-dd HH24:mi:ss'),\n" +
            "#{createdBy},to_date(#{updateTime},'yyyy-MM-dd HH24:mi:ss'),#{updatedBy})")
    void updateBuriedAJZBL(UpdateBuriedAJZBLcondition updateBuriedAJZBLcondition);

    //更新压埋人员按城市比例模型数据
    @Insert("INSERT INTO T_MODEL_BURIED t(t.FEATID,t.PARAM_NAME,t.CATEGORY,t.PERCENT_BURIED,\n" +
            "t.FORMULA,t.MODEL_VERSION,t.CREATE_TIME,t.CREATED_BY,t.UPDATE_TIME,t.UPDATED_BY)\n" +
            "VALUES (#{featId},#{paramName},#{category},#{percentBuried},#{formula},#{modelVersion},to_date(#{createTime},'yyyy-MM-dd HH24:mi:ss'),\n" +
            "#{createdBy},to_date(#{updateTime},'yyyy-MM-dd HH24:mi:ss'),#{updatedBy})")
    void updateBuriedACSBL(UpdateBuriedACSBLcondition updateBuriedACSBLcondition);

}
