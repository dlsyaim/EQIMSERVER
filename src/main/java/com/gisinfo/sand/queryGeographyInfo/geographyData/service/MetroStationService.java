package com.gisinfo.sand.queryGeographyInfo.geographyData.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gisinfo.sand.queryGeographyInfo.geographyData.bean.MetroStation;
import com.gisinfo.sand.queryGeographyInfo.geographyData.condition.MetroStationCondition;
import com.gisinfo.sand.queryGeographyInfo.geographyData.dao.MetroStationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

//地铁站服务类
@Service
public class MetroStationService extends ServiceImpl<MetroStationMapper, MetroStation> {

    @Autowired(required = false)
    private MetroStationMapper metroStationMapper;

    //查询总记录条数
    public Integer getMetroStationCount(MetroStationCondition metroStationCondition){
        Map<String,Object> data=this.metroStationMapper.getMetroStationCount(metroStationCondition);
        Integer count=Integer.parseInt(data.get("count").toString());
        return count;
    }

    //查询数据列表
    public List<MetroStation> getMetroStationList(MetroStationCondition MetroStationCondition){
        List<MetroStation> data=this.metroStationMapper.getMetroStationList(MetroStationCondition);
        return data;
    }

}
