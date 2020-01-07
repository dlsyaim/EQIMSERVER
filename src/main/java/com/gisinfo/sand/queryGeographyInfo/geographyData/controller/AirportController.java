package com.gisinfo.sand.queryGeographyInfo.geographyData.controller;

import com.gisinfo.sand.core.security.EncryptDisable;
import com.gisinfo.sand.queryGeographyInfo.geographyData.bean.Airport;
import com.gisinfo.sand.queryGeographyInfo.geographyData.condition.AirportContition;
import com.gisinfo.sand.queryGeographyInfo.geographyData.service.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//机场控制类
@RestController
public class AirportController {
    @Autowired
    private AirportService airportService;

    //查询机场数据列表和总记录数
    @EncryptDisable
    @RequestMapping(value = "/getAirportListAndCount",method = RequestMethod.POST)
    public Map<String,Object> getAirportListAndCount(AirportContition airportContition){
        if(airportContition.getPageNo()!=null&&airportContition.getPageSize()!=null){
            Integer pageNo=airportContition.getPageNo();
            Integer pageSize=airportContition.getPageSize();
            airportContition.setBottom((pageNo - 1)*pageSize);
            airportContition.setTop(pageNo*pageSize);
        }
        Map<String,Object> result=null;
        //查询总记录数
        Integer count=this.airportService.getAirportCount(airportContition);
        //查询数据列表
        List<Airport> list=this.airportService.getAirportList(airportContition);
        result=new HashMap<>();
        result.put("count",count);
        result.put("list",list);
        return result;
    }
}
