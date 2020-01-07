package com.gisinfo.sand.queryGeographyInfo.geographyData.controller;

import com.gisinfo.sand.core.security.EncryptDisable;
import com.gisinfo.sand.queryGeographyInfo.geographyData.bean.UrbanRefuge;
import com.gisinfo.sand.queryGeographyInfo.geographyData.condition.UrbanRefugeCondition;
import com.gisinfo.sand.queryGeographyInfo.geographyData.service.UrbanRefugeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//城市避难所控制类
@RestController
public class UrbanRefugeController {

    @Autowired
    private UrbanRefugeService urbanRefugeService;

    //查询桥梁等级下拉列表、列表下拉列表、总记录条数、数据列表
    @EncryptDisable
    @RequestMapping(value = "/getUrbanRefugeTypeListAndCitListAndCountAndList",method = RequestMethod.POST)
    public Map<String,Object> getUrbanRefugeTypeListAndCitListAndCountAndList(UrbanRefugeCondition urbanRefugeCondition){
        if(urbanRefugeCondition.getPageNo()!=null&&urbanRefugeCondition.getPageSize()!=null){
            Integer pageNo=urbanRefugeCondition.getPageNo();
            Integer pageSize=urbanRefugeCondition.getPageSize();
            urbanRefugeCondition.setBottom((pageNo - 1)*pageSize);
            urbanRefugeCondition.setTop(pageNo*pageSize);
        }
        Map<String,Object> result=null;
        //查询类别下拉列表
        List<Map<String,Object>> UrbanRefugeTypeList=this.urbanRefugeService.getUrbanRefugeTypeList();
        //查询等级下拉列表
        List<Map<String,Object>> UrbanRefugeCitList=this.urbanRefugeService.getUrbanRefugeCitList();
        //查询总记录数
        Integer count=this.urbanRefugeService.getUrbanRefugeCount(urbanRefugeCondition);
        //查询数据列表
        List<UrbanRefuge> list=this.urbanRefugeService.getUrbanRefugeList(urbanRefugeCondition);
        result=new HashMap<>();
        result.put("UrbanRefugeTypeList",UrbanRefugeTypeList);
        result.put("UrbanRefugeCitList",UrbanRefugeCitList);
        result.put("count",count);
        result.put("list",list);
        return result;
    }

}
