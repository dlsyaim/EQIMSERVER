package com.gisinfo.sand.queryGeographyInfo.geographyData.controller;

import com.gisinfo.sand.core.security.EncryptDisable;
import com.gisinfo.sand.queryGeographyInfo.geographyData.bean.WaterPipe;
import com.gisinfo.sand.queryGeographyInfo.geographyData.condition.WaterPipeCondition;
import com.gisinfo.sand.queryGeographyInfo.geographyData.service.WaterPipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//供水主干管网控制类
@RestController
public class WaterPipeController {
    @Autowired
    private WaterPipeService waterPipeService;

    //查询列表下拉列表、总记录条数、数据列表
    @EncryptDisable
    @RequestMapping(value = "/getWaterPipeClassListAndMateialListAndCountAndList",method = RequestMethod.POST)
    public Map<String,Object> getWaterPipeClassListAndMateialListAndCountAndList(WaterPipeCondition waterPipeCondition){
        if(waterPipeCondition.getPageNo()!=null&&waterPipeCondition.getPageSize()!=null){
            Integer pageNo=waterPipeCondition.getPageNo();
            Integer pageSize=waterPipeCondition.getPageSize();
            waterPipeCondition.setBottom((pageNo - 1)*pageSize);
            waterPipeCondition.setTop(pageNo*pageSize);
        }
        Map<String,Object> result=null;
        //查询类别下拉列表
        List<Map<String,Object>> WaterPipeClassList=this.waterPipeService.getWaterPipeClassList();
        //查询材料下拉列表
        List<Map<String,Object>> WaterPipeMateialList=this.waterPipeService.getWaterpipeMateialList();
        //查询总记录数
        Integer count=this.waterPipeService.getWaterPipeCount(waterPipeCondition);
        //查询数据列表
        List<WaterPipe> list=this.waterPipeService.getWaterPipeList(waterPipeCondition);
        result=new HashMap<>();
        result.put("WaterPipeClassList",WaterPipeClassList);
        result.put("WaterPipeMateialList",WaterPipeMateialList);
        result.put("count",count);
        result.put("list",list);
        return result;
    }
    
    
}
