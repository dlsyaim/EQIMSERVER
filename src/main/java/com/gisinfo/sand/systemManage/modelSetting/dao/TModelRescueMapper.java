package com.gisinfo.sand.systemManage.modelSetting.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gisinfo.sand.systemManage.modelSetting.bean.TModelRescue;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Map;

@Mapper
public interface TModelRescueMapper extends BaseMapper<TModelRescue> {
    //获取救援队伍表中当前最大的版本号
    @Select("select max(t.MODEL_VERSION) max_version from T_MODEL_RESCUE t")
    Map<String,Object> getMaxVersion();


    //查询救援队伍模型所有参数
    @Select("select t.L0,t.L1,t.L2 from t_model_rescue t where t.model_version = #{maxVersion}")
    Map<String, Object> getRescueParams(String maxVersion);

    //添加救援队伍模型修改后的参数
    @Insert("INSERT INTO T_MODEL_RESCUE(FEATID,PARAM_NAME,L0,L1,L2,FORMULA,MODEL_VERSION,CREATE_TIME,CREATED_BY,UPDATE_TIME,UPDATED_BY) VALUES" +
            "(#{rescueList.featid},#{rescueList.paramName},#{rescueList.l0,jdbcType=DOUBLE},#{rescueList.l1,jdbcType=DOUBLE}," +
            "#{rescueList.l2,jdbcType=DOUBLE},#{rescueList.formula},#{rescueList.modelVersion},to_date(#{rescueList.createTime},'yyyy-mm-dd hh24:mi:ss')," +
            "#{rescueList.createdBy},to_date(#{rescueList.updateTime},'yyyy-mm-dd hh24:mi:ss'),#{rescueList.updatedBy})")
    Integer addRescue(@Param("rescueList") TModelRescue tModelRescue);

    //添加计算后的救援队伍人数
    @Insert("insert into T_EARTHQUAKE_AID_DECISION t(\n"+
            "      t.FEATID,t.EARTHQUAKE_FEATID,t.TOWN_NAME,t.RESCUE_STAFF_DEMAND\n"+
            ") values (#{featId},#{earthquakeFeatId},#{townName},#{rescueStaff})")
    void addRescueNumber(Map<String,Object> data);


    @Select("SELECT * FROM T_MODEL_RESCUE WHERE FEATID=#{featid}")
    TModelRescue getRescueFeatId(@Param("featid") String featId);

}
