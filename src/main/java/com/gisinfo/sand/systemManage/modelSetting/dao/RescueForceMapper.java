package com.gisinfo.sand.systemManage.modelSetting.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gisinfo.sand.systemManage.modelSetting.bean.RescueForceModel;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface RescueForceMapper extends BaseMapper<RescueForceModel> {

    //查询救援力量模型表最新版本号
    @Select("select max(t.MODEL_VERSION) max_version from T_MODEL_RESCUE_FORCE t")
    Map<String,Object> getMaxVersion();

    //查找最新版本的救援力量模型所有参数
    @Select("select t.FORCE0,t.FORCE1,t.FORCE2,t.FORCE3,t.FORCE4,t.FORCE5,t.FORCE6,\n" +
            "       t.MEDICAL_STAFF0,t.MEDICAL_STAFF1,t.MEDICAL_STAFF2,t.MEDICAL_STAFF3,\n" +
            "       t.EPIDEMIC_PREVENTION0,t.EPIDEMIC_PREVENTION1,t.EPIDEMIC_PREVENTION2,t.EPIDEMIC_PREVENTION3\n" +
            "from T_MODEL_RESCUE_FORCE t where t.MODEL_VERSION = #{modelVersion}")
    Map<String,Object> getRescueForceParams(String modelVersion);

    //添加救援力量模型修改后的参数
    @Insert("INSERT INTO T_MODEL_RESCUE_FORCE(" +
            "FEATID," +
            "PARAM_NAME," +
            "FORCE0,FORCE1," +
            "FORCE2,FORMULA," +
            "MODEL_VERSION," +
            "CREATE_TIME," +
            "CREATED_BY," +
            "UPDATE_TIME," +
            "UPDATED_BY," +
            "DEFAULT_STATUS," +
            "FORCE3," +
            "FORCE4," +
            "FORCE5," +
            "FORCE6," +
            "MEDICAL_STAFF0," +
            "MEDICAL_STAFF1," +
            "MEDICAL_STAFF2," +
            "MEDICAL_STAFF3," +
            "EPIDEMIC_PREVENTION0," +
            "EPIDEMIC_PREVENTION1," +
            "EPIDEMIC_PREVENTION2," +
            "EPIDEMIC_PREVENTION3) " +
            "VALUES (" +
            "#{rescueList.featId}," +
            "#{rescueList.paramName}," +
            "#{rescueList.force0}," +
            "#{rescueList.force1}," +
            "#{rescueList.force2}," +
            "#{rescueList.formula}," +
            "#{rescueList.modelVersion}," +
            "to_date(#{rescueList.createTime},'yyyy-mm-dd hh24:mi:ss')," +
            "#{rescueList.createdBy}," +
            "to_date(#{rescueList.updateTime},'yyyy-mm-dd hh24:mi:ss')," +
            "#{rescueList.updatedBy}," +
            "#{rescueList.defaultStatus}," +
            "#{rescueList.force3}," +
            "#{rescueList.force4}," +
            "#{rescueList.force5}," +
            "#{rescueList.force6}," +
            "#{rescueList.medicalStaff0}," +
            "#{rescueList.medicalStaff1}," +
            "#{rescueList.medicalStaff2}," +
            "#{rescueList.medicalStaff3}," +
            "#{rescueList.epidemicPrevention0}," +
            "#{rescueList.epidemicPrevention1}," +
            "#{rescueList.epidemicPrevention2}," +
            "#{rescueList.epidemicPrevention3})")
    Integer addRescueForce(@Param("rescueList") RescueForceModel rescueForceModel);

    //添加救援力量模型中的计算的医护人员需求数
    @Update("update T_EARTHQUAKE_AID_DECISION t set t.MEDICAL_STAFF_DEMAND\n" +
            "= #{medicalStaff} where t.EARTHQUAKE_FEATID =#{earthquakeFeatId} and t.TOWN_NAME = #{townName}")
    void addMedicalMember(Map<String,Object> data);




}
