package com.gisinfo.sand.queryGeographyInfo.geographyData.controller;

import com.gisinfo.sand.core.security.EncryptDisable;
import com.gisinfo.sand.queryGeographyInfo.geographyData.bean.WaterWay;
import com.gisinfo.sand.queryGeographyInfo.geographyData.condition.WaterwayCondition;
import com.gisinfo.sand.queryGeographyInfo.geographyData.service.WaterwayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//水道控制类
@RestController
public class WaterwayController {
    @Autowired
    private WaterwayService waterwayService;

    //查询水道类别列表、总记录数、数据列表
    @EncryptDisable
    @RequestMapping(value="/getWaterwayClassListAndCountAndList")
    public Map<String,Object> getWaterwayClassListAndCountAndList(WaterwayCondition waterwayCondition){
        if(waterwayCondition.getPageNo()!=null&&waterwayCondition.getPageSize()!=null){
            Integer pageNo=waterwayCondition.getPageNo();
            Integer pageSize=waterwayCondition.getPageSize();
            waterwayCondition.setBottom((pageNo - 1)*pageSize);
            waterwayCondition.setTop(pageNo*pageSize);
        }
        Map<String,Object> result=null;
        //查询水道类别下拉列表
        List<Map<String,Object>> selectList=this.waterwayService.getWaterwayClassList();
        //查询总记录数
        Integer count=this.waterwayService.getWaterwayCount(waterwayCondition);
        //查询记录列表
        List<WaterWay> list=this.waterwayService.getWaterwayList(waterwayCondition);
        result=new HashMap<>();
        result.put("count",count);
        result.put("selectList",selectList);
        result.put("list",list);
        return result;
    }
}
