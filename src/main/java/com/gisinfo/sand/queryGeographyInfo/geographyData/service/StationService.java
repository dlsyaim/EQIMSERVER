package com.gisinfo.sand.queryGeographyInfo.geographyData.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gisinfo.sand.queryGeographyInfo.geographyData.bean.Station;
import com.gisinfo.sand.queryGeographyInfo.geographyData.condition.StationCondition;
import com.gisinfo.sand.queryGeographyInfo.geographyData.dao.StationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

//台站服务类
@Service
public class StationService extends ServiceImpl<StationMapper, Station> {

    @Autowired(required = false)
    private StationMapper stationMapper;

    //查询总记录数
    public Integer getStationCount(StationCondition stationCondition){
        Map<String,Object> data=this.stationMapper.getStationCount(stationCondition);
        Integer count=Integer.parseInt(data.get("count").toString());
        return count;
    }

    //查询数据列表
    public List<Station> getStationList(StationCondition stationCondition){
        List<Station> list=this.stationMapper.getStationList(stationCondition);
        return list;
    }
    
}
