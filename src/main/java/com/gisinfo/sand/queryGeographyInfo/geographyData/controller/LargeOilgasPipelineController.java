package com.gisinfo.sand.queryGeographyInfo.geographyData.controller;

import com.gisinfo.sand.core.security.EncryptDisable;
import com.gisinfo.sand.queryGeographyInfo.geographyData.bean.LargeOilgasPipeline;
import com.gisinfo.sand.queryGeographyInfo.geographyData.condition.LargeOilgasPipelineCondition;
import com.gisinfo.sand.queryGeographyInfo.geographyData.service.LargeOilgasPipelineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//桥梁控制类
@RestController
public class LargeOilgasPipelineController {

    @Autowired
    private LargeOilgasPipelineService largeOilgasPipelineService;

    //查询桥梁等级下拉列表、列表下拉列表、总记录条数、数据列表
    @EncryptDisable
    @RequestMapping(value = "/getLargeOilgasPipelineClassListAndCountAndList",method = RequestMethod.POST)
    public Map<String,Object> getLargeOilgasPipelineClassListAndCountAndList(LargeOilgasPipelineCondition LargeOilgasPipelineCondition){
        if(LargeOilgasPipelineCondition.getPageNo()!=null&&LargeOilgasPipelineCondition.getPageSize()!=null){
            Integer pageNo=LargeOilgasPipelineCondition.getPageNo();
            Integer pageSize=LargeOilgasPipelineCondition.getPageSize();
            LargeOilgasPipelineCondition.setBottom((pageNo - 1)*pageSize);
            LargeOilgasPipelineCondition.setTop(pageNo*pageSize);
        }
        Map<String,Object> result=null;
        //查询桥梁等级下拉列表
        List<Map<String,Object>> LargeOilgasPipelineClassList=this.largeOilgasPipelineService.getLargeOilgasPipelineClassList();
        //查询总记录数
        Integer count=this.largeOilgasPipelineService.getLargeOilgasPipelineCount(LargeOilgasPipelineCondition);
        //查询数据列表
        List<LargeOilgasPipeline> list=this.largeOilgasPipelineService.getLargeOilgasPipelineList(LargeOilgasPipelineCondition);
        result=new HashMap<>();
//        result.put("LargeOilgasPipelineClassList",LargeOilgasPipelineClassList);
        result.put("LargeOilgasPipelineClassList",LargeOilgasPipelineClassList);
        result.put("count",count);
        result.put("list",list);
        return result;
    }
}
