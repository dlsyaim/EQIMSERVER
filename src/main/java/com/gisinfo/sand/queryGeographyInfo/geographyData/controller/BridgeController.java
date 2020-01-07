package com.gisinfo.sand.queryGeographyInfo.geographyData.controller;

import com.gisinfo.sand.core.security.EncryptDisable;
import com.gisinfo.sand.queryGeographyInfo.geographyData.bean.Bridge;
import com.gisinfo.sand.queryGeographyInfo.geographyData.condition.BridgeCondition;
import com.gisinfo.sand.queryGeographyInfo.geographyData.service.BridgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//桥梁控制类
@RestController
public class BridgeController {
    @Autowired
    private BridgeService bridgeService;

    //查询桥梁等级下拉列表、列表下拉列表、总记录条数、数据列表
    @EncryptDisable
    @RequestMapping(value = "/getBridgeClassListAndGradeListAndCountAndList",method = RequestMethod.POST)
    public Map<String,Object> getBridgeClassListAndGradeListAndCountAndList(BridgeCondition bridgeCondition){
        if(bridgeCondition.getPageNo()!=null&&bridgeCondition.getPageSize()!=null){
            Integer pageNo=bridgeCondition.getPageNo();
            Integer pageSize=bridgeCondition.getPageSize();
            bridgeCondition.setBottom((pageNo - 1)*pageSize);
            bridgeCondition.setTop(pageNo*pageSize);
        }
        Map<String,Object> result=null;
        //查询桥梁类别下拉列表
        List<Map<String,Object>> bridgeClassList=this.bridgeService.getBridgeClassList();
        //查询桥梁等级下拉列表
        List<Map<String,Object>> bridgeGradeList=this.bridgeService.getBridgeGradeList();
        //查询总记录数
        Integer count=this.bridgeService.getBridgeCount(bridgeCondition);
        //查询数据列表
        List<Bridge> list=this.bridgeService.getBridgeList(bridgeCondition);
        result=new HashMap<>();
        result.put("bridgeClassList",bridgeClassList);
        result.put("bridgeGradeList",bridgeGradeList);
        result.put("count",count);
        result.put("list",list);
        return result;
    }
}
