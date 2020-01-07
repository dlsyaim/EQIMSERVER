package com.gisinfo.sand.queryGeographyInfo.geographyData.controller;


import com.gisinfo.sand.core.security.EncryptDisable;
import com.gisinfo.sand.queryGeographyInfo.geographyData.bean.TEarthquakeInfo;
import com.gisinfo.sand.queryGeographyInfo.geographyData.condition.TEarthquakeInfoCondition;
import com.gisinfo.sand.queryGeographyInfo.geographyData.service.TEarthquakeInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//地震触发列表控制类
@RestController
public class TEarthquakeInfoController {

    @Autowired
    private TEarthquakeInfoService tEarthquakeInfoService;

    //查询总记录数、数据列表
    @EncryptDisable
    @RequestMapping(value="/getTEarthquakeInfoCountAndList",method = RequestMethod.POST)
    public Map<String,Object> getTEarthquakeInfoCountAndList(TEarthquakeInfoCondition tEarthquakeInfoCondition){
//        if(tEarthquakeInfoCondition.getPageNo()!=null&&tEarthquakeInfoCondition.getPageSize()!=null){
//            Integer pageNo=tEarthquakeInfoCondition.getPageNo();
//            Integer pageSize=tEarthquakeInfoCondition.getPageSize();
//            tEarthquakeInfoCondition.setBottom((pageNo - 1)*pageSize);
//            tEarthquakeInfoCondition.setTop(pageNo*pageSize);
//        }
        Map<String,Object> result=null;
        //查询总记录数
        Integer count=this.tEarthquakeInfoService.getTEarthquakeInfoCount(tEarthquakeInfoCondition);
        //查询记录列表
        List<TEarthquakeInfo> list=this.tEarthquakeInfoService.getTEarthquakeInfoList(tEarthquakeInfoCondition);
        result=new HashMap<>();
        result.put("count",count);
        result.put("list",list);
        return result;
    }

    //查询总记录数、数据列表
    @EncryptDisable
    @RequestMapping(value="/getTEarthquakeId",method = RequestMethod.POST)
    public Map<String,Object> getTEarthquakeId(TEarthquakeInfoCondition tEarthquakeInfoCondition){
        Map<String,Object> result=null;
        //查询记录列表
        List<Map> list=this.tEarthquakeInfoService.getTEarthquakeId(tEarthquakeInfoCondition);
        result=new HashMap<>();
        result.put("list",list);
        return result;
    }

}
