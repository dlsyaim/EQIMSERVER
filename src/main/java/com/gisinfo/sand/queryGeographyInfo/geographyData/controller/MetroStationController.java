package com.gisinfo.sand.queryGeographyInfo.geographyData.controller;

import com.gisinfo.sand.core.security.EncryptDisable;
import com.gisinfo.sand.queryGeographyInfo.geographyData.bean.MetroStation;
import com.gisinfo.sand.queryGeographyInfo.geographyData.service.MetroStationService;
import com.gisinfo.sand.queryGeographyInfo.geographyData.condition.MetroStationCondition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//地铁站控制类
@RestController
public class MetroStationController {

    @Autowired
    private MetroStationService metroStationService;

    //查询地铁站总记录数、数据列表
    @EncryptDisable
    @RequestMapping(value="/getMetroStationCountAndList")
    public Map<String,Object> getMetroStationCountAndList(MetroStationCondition metroStationCondition){
        if(metroStationCondition.getPageNo()!=null&&metroStationCondition.getPageSize()!=null){
            Integer pageNo=metroStationCondition.getPageNo();
            Integer pageSize=metroStationCondition.getPageSize();
            metroStationCondition.setBottom((pageNo - 1)*pageSize);
            metroStationCondition.setTop(pageNo*pageSize);
        }
        Map<String,Object> result=null;
        //查询总记录数
        Integer count=this.metroStationService.getMetroStationCount(metroStationCondition);
        //查询记录列表
        List<MetroStation> list=this.metroStationService.getMetroStationList(metroStationCondition);
        result=new HashMap<>();
        result.put("count",count);
//        result.put("selectList",selectList);
        result.put("list",list);
        return result;
    }

}
