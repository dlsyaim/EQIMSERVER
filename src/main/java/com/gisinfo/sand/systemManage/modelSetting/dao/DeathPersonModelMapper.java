package com.gisinfo.sand.systemManage.modelSetting.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gisinfo.sand.systemManage.modelSetting.bean.DeathPersonModel;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface DeathPersonModelMapper extends BaseMapper<DeathPersonModel>{
@Insert("INSERT INTO T_MODEL_DEATHS(FEATID,PARAM_NAME,L0,L1,L2,FORMULA,MODEL_VERSION,CREATE_TIME,CREATED_BY,UPDATE_TIME,UPDATED_BY) VALUES" +
        "(#{deathList.featId},#{deathList.paramName},#{deathList.l0},#{deathList.l1},#{deathList.l2},#{deathList.formula},#{deathList.modelVersion},to_date(#{deathList.createTime},'yyyy-mm-dd hh24:mi:ss'),#{deathList.createdBy},to_date(#{deathList.updateTime},'yyyy-mm-dd hh24:mi:ss'),#{deathList.updatedBy})")
Integer addDeath(@Param("deathList") DeathPersonModel deathPersonModel);

@Select("SELECT * FROM (SELECT t.*,rownum rn FROM(SELECT * FROM T_MODEL_DEATHS WHERE 1=1 AND rownum<=#{top})t) t WHERE t.rn >#{bottom}")
List<DeathPersonModel> getListDeathModel(DeathPersonModel deathPersonModel);

@Select("select count(1) count from T_MODEL_DEATHS where 1=1")
Map<String,Object> getCount();

@Select("SELECT * FROM T_MODEL_DEATHS WHERE FEATID=#{featId}")
DeathPersonModel getDeathFeatId(@Param("featId") String featId);

@Delete("delete from T_MODEL_DEATHS where FEATID=#{featId}")
void deleteDeath(@Param("featId") String featId);

    @Update("update T_EARTHQUAKE_DETAIL set DEATH_NUMBER = #{deathNumber} where EARTHQUAKE_FEATID = #{earthquakeFeatid} and TOWN_NAME = #{townName}")
    void updateDeathNum(@Param("deathNumber") int deathNumber,@Param("earthquakeFeatid") String earthquakeFeatid,@Param("townName") String townName);

//    @Select("select * from T_MODEL_DEATHS where DEFAULT_STATUS = 1")
//    DeathPersonModel selectDefaultModel();

    @Select("SELECT * FROM T_MODEL_DEATHS where MODEL_VERSION = (\n" +
            "\tSELECT MAX(TO_NUMBER(MODEL_VERSION)) from T_MODEL_DEATHS\n" +
            ")")
    DeathPersonModel selectMaxVersionModel();

    /**
     * ��ѯ�����ݻٻ������
     * @param earthquakeFeatId
     * @return
     */
    @Select("select TOWN_NAME townName,STRUCTURE_D count from T_EARTHQUAKE_DETAIL where EARTHQUAKE_FEATID = #{earthquakeFeatId}")
    List<Map<String,Object>> selectSDCountByEFId(@Param("earthquakeFeatId") String earthquakeFeatId);

//    @Select("select NAME townName,TOTAL_AREA totalArea from TOWN_BUILDING")
//    List<Map<String, Object>> selectTotalArea();

//    @Select("select NAME townName,TOTAL totalPopulation from TOWN_POPULATION")
//    List<Map<String, Object>> selectTotalPopulation();

}
