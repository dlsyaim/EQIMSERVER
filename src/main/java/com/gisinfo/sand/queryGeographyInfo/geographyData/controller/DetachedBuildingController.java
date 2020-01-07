package com.gisinfo.sand.queryGeographyInfo.geographyData.controller;

import com.gisinfo.sand.core.security.EncryptDisable;
import com.gisinfo.sand.queryGeographyInfo.geographyData.bean.DetachedBuilding;
import com.gisinfo.sand.queryGeographyInfo.geographyData.condition.DetachedBuildingCondition;
import com.gisinfo.sand.queryGeographyInfo.geographyData.service.DetachedBuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//独立建筑控制类
@RestController
public class DetachedBuildingController {

    @Autowired
    private DetachedBuildingService detachedBuildingService;

    //查询桥梁等级下拉列表、列表下拉列表、总记录条数、数据列表
    @EncryptDisable
    @RequestMapping(value = "/getDetachedBuildingClassListAndGradeListAndCountAndList",method = RequestMethod.POST)
    public Map<String,Object> getDetachedBuildingClassListAndGradeListAndCountAndList(DetachedBuildingCondition detachedBuildingCondition){
        if(detachedBuildingCondition.getPageNo()!=null&&detachedBuildingCondition.getPageSize()!=null){
            Integer pageNo=detachedBuildingCondition.getPageNo();
            Integer pageSize=detachedBuildingCondition.getPageSize();
            detachedBuildingCondition.setBottom((pageNo - 1)*pageSize);
            detachedBuildingCondition.setTop(pageNo*pageSize);
        }
        Map<String,Object> result=null;
        //查询桥梁类别下拉列表
        List<Map<String,Object>> DetachedBuildingTypeList=this.detachedBuildingService.getDetachedBuildingTypeList();
        //查询总记录数
        Integer count=this.detachedBuildingService.getDetachedBuildingCount(detachedBuildingCondition);
        //查询数据列表
        List<DetachedBuilding> list=this.detachedBuildingService.getDetachedBuildingList(detachedBuildingCondition);
        result=new HashMap<>();
        result.put("DetachedBuildingTypeList",DetachedBuildingTypeList);
        result.put("count",count);
        result.put("list",list);
        return result;
    }
    
}
