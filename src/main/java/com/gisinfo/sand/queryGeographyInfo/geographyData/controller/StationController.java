package com.gisinfo.sand.queryGeographyInfo.geographyData.controller;

import com.gisinfo.sand.core.security.EncryptDisable;
import com.gisinfo.sand.queryGeographyInfo.geographyData.bean.Station;
import com.gisinfo.sand.queryGeographyInfo.geographyData.condition.StationCondition;
import com.gisinfo.sand.queryGeographyInfo.geographyData.service.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//台站控制类
@RestController
public class StationController {

    @Autowired
    private StationService stationService;

    //查询桥梁等级下拉列表、列表下拉列表、总记录条数、数据列表
    @EncryptDisable
    @RequestMapping(value = "/getStationClassListAndGradeListAndCountAndList",method = RequestMethod.POST)
    public Map<String,Object> getStationClassListAndGradeListAndCountAndList(StationCondition stationCondition){
        if(stationCondition.getPageNo()!=null&&stationCondition.getPageSize()!=null){
            Integer pageNo=stationCondition.getPageNo();
            Integer pageSize=stationCondition.getPageSize();
            stationCondition.setBottom((pageNo - 1)*pageSize);
            stationCondition.setTop(pageNo*pageSize);
        }
        Map<String,Object> result=null;
        //查询总记录数
        Integer count=this.stationService.getStationCount(stationCondition);
        //查询数据列表
        List<Station> list=this.stationService.getStationList(stationCondition);
        result=new HashMap<>();
        result.put("count",count);
        result.put("list",list);
        return result;
    }
    
}
