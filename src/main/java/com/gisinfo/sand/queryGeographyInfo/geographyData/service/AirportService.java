package com.gisinfo.sand.queryGeographyInfo.geographyData.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gisinfo.sand.queryGeographyInfo.geographyData.bean.Airport;
import com.gisinfo.sand.queryGeographyInfo.geographyData.condition.AirportContition;
import com.gisinfo.sand.queryGeographyInfo.geographyData.dao.AirportMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

//机场服务类
@Service
public class AirportService extends ServiceImpl<AirportMapper, Airport> {
    @Autowired(required = false)
    private AirportMapper airportMapper;

    //查询总记录条数
    public Integer getAirportCount(AirportContition airportContition){
        Map<String,Object> data=this.airportMapper.getAirportCount(airportContition);
        Integer count=Integer.parseInt(data.get("count").toString());
        return count;
    }

    //查询记录总条数
    public List<Airport> getAirportList(AirportContition airportContition){
        List<Airport> data=this.airportMapper.getAirportlist(airportContition);
        return data;
    }
}
