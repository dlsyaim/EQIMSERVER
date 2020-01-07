package com.gisinfo.sand.systemManage.modelSetting.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gisinfo.sand.systemManage.modelSetting.bean.TEarthquakeDetail;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface TEarthquakeDetailMapper extends BaseMapper<TEarthquakeDetail> {

    @Select("select FEATID,EARTHQUAKE_FEATID,TOWN_NAME,STRUCTURE_J,STRUCTURE_Q," +
            "STRUCTURE_Z,STRUCTURE_Y,STRUCTURE_D from T_EARTHQUAKE_DETAIL where EARTHQUAKE_FEATID = #{0}")
    List<TEarthquakeDetail> selectDetailByQuakeFeatid(String earthquakeFeatid);

    @Select("select d.*,b.TOTAL_AREA TOWN_TOTAL_AREA,p.TOTAL TOWN_POPULATION from T_EARTHQUAKE_DETAIL d\n" +
            "LEFT JOIN TOWN_BUILDING b on d.TOWN_NAME = b.NAME\n" +
            "LEFT JOIN TOWN_POPULATION p on d.TOWN_NAME = p.NAME\n" +
            "where EARTHQUAKE_FEATID = #{0}")
    List<TEarthquakeDetail> selectEqDetailByFeatid(String earthquakeFeatid);

    @Update("update T_EARTHQUAKE_DETAIL set EMERGENCY_REHOUSING_NUMBER = #{emergencyRehousingNumber} where EARTHQUAKE_FEATID = #{earthquakeFeatid} and TOWN_NAME = #{townName}")
    void updateEmergencyRehousingNumber(TEarthquakeDetail earthquakeDetail);


    @Update("update T_EARTHQUAKE_DETAIL set EMERGENCY_LEVEL = #{emergencyLevel} where EARTHQUAKE_FEATID = #{earthquakeFeatid} and TOWN_NAME = #{townName}")
    void updateEmergencyLevel(TEarthquakeDetail earthquakeDetail);
}
