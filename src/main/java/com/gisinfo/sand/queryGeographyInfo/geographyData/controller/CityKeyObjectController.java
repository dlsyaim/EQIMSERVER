package com.gisinfo.sand.queryGeographyInfo.geographyData.controller;

import com.gisinfo.sand.core.security.EncryptDisable;
import com.gisinfo.sand.queryGeographyInfo.geographyData.bean.CityKeyObject;
import com.gisinfo.sand.queryGeographyInfo.geographyData.condition.CityKeyObjectCondition;
import com.gisinfo.sand.queryGeographyInfo.geographyData.service.CityKeyObjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//城市主要目标控制类
@RestController
public class CityKeyObjectController {

    @Autowired
    private CityKeyObjectService cityKeyObjectService;

    //查询桥梁等级下拉列表、列表下拉列表、总记录条数、数据列表
    @EncryptDisable
    @RequestMapping(value = "/getCityKeyObjectClassListAndAndCountAndList",method = RequestMethod.POST)
    public Map<String,Object> getCityKeyObjectClassListAndAndCountAndList(CityKeyObjectCondition cityKeyObjectCondition){
        if(cityKeyObjectCondition.getPageNo()!=null&&cityKeyObjectCondition.getPageSize()!=null){
            Integer pageNo=cityKeyObjectCondition.getPageNo();
            Integer pageSize=cityKeyObjectCondition.getPageSize();
            cityKeyObjectCondition.setBottom((pageNo - 1)*pageSize);
            cityKeyObjectCondition.setTop(pageNo*pageSize);
        }
        Map<String,Object> result=null;
        //查询桥梁类别下拉列表
        List<Map<String,Object>> CityKeyObjectClassList=this.cityKeyObjectService.getCityKeyObjectClassList();
        //查询总记录数
        Integer count=this.cityKeyObjectService.getCityKeyObjectCount(cityKeyObjectCondition);
        //查询数据列表
        List<CityKeyObject> list=this.cityKeyObjectService.getCityKeyObjectList(cityKeyObjectCondition);
        result=new HashMap<>();
        result.put("CityKeyObjectClassList",CityKeyObjectClassList);
        result.put("count",count);
        result.put("list",list);
        return result;
    }
    
}
