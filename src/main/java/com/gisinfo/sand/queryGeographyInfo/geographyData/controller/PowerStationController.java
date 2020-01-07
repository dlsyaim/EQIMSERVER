package com.gisinfo.sand.queryGeographyInfo.geographyData.controller;

import com.gisinfo.sand.core.security.EncryptDisable;
import com.gisinfo.sand.queryGeographyInfo.geographyData.bean.PowerStation;
import com.gisinfo.sand.queryGeographyInfo.geographyData.condition.PowerStationCondition;
import com.gisinfo.sand.queryGeographyInfo.geographyData.service.PowerStationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//重要发电厂房信息控制类
@RestController
public class PowerStationController {

    @Autowired
    private PowerStationService powerStationService;

    //查询桥梁等级下拉列表、列表下拉列表、总记录条数、数据列表
    @EncryptDisable
    @RequestMapping(value = "/getPowerStationClassListAndGradeListAndCountAndList",method = RequestMethod.POST)
    public Map<String,Object> getPowerStationClassListAndGradeListAndCountAndList(PowerStationCondition powerStationCondition){
        if(powerStationCondition.getPageNo()!=null&&powerStationCondition.getPageSize()!=null){
            Integer pageNo=powerStationCondition.getPageNo();
            Integer pageSize=powerStationCondition.getPageSize();
            powerStationCondition.setBottom((pageNo - 1)*pageSize);
            powerStationCondition.setTop(pageNo*pageSize);
        }
        Map<String,Object> result=null;
        //查询总记录数
        Integer count=this.powerStationService.getPowerStationCount(powerStationCondition);
        //查询数据列表
        List<PowerStation> list=this.powerStationService.getPowerStationList(powerStationCondition);
        result=new HashMap<>();
        result.put("count",count);
        result.put("list",list);
        return result;
    }
    
}
