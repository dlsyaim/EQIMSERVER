package com.gisinfo.sand.queryGeographyInfo.geographyData.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gisinfo.sand.queryGeographyInfo.geographyData.bean.PowerStation;
import com.gisinfo.sand.queryGeographyInfo.geographyData.condition.PowerStationCondition;
import com.gisinfo.sand.queryGeographyInfo.geographyData.dao.PowerStationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

//重要发电厂房信息服务类
@Service
public class PowerStationService extends ServiceImpl<PowerStationMapper, PowerStation> {

    @Autowired(required = false)
    private PowerStationMapper powerStationMapper;

    //查询总记录数
    public Integer getPowerStationCount(PowerStationCondition powerStationCondition){
        Map<String,Object> data=this.powerStationMapper.getPowerStationCount(powerStationCondition);
        Integer count=Integer.parseInt(data.get("count").toString());
        return count;
    }

    //查询数据列表
    public List<PowerStation> getPowerStationList(PowerStationCondition powerStationCondition){
        List<PowerStation> list=this.powerStationMapper.getPowerStationList(powerStationCondition);
        return list;
    }
}
