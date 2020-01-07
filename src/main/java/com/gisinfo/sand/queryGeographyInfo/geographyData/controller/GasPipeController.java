package com.gisinfo.sand.queryGeographyInfo.geographyData.controller;

import com.gisinfo.sand.core.security.EncryptDisable;
import com.gisinfo.sand.queryGeographyInfo.geographyData.bean.GasPipe;
import com.gisinfo.sand.queryGeographyInfo.geographyData.condition.GasPipeCondition;
import com.gisinfo.sand.queryGeographyInfo.geographyData.service.GasPipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//桥梁控制类
@RestController
public class GasPipeController {
    @Autowired
    private GasPipeService gasPipeService;

    //查询桥梁等级下拉列表、列表下拉列表、总记录条数、数据列表
    @EncryptDisable
    @RequestMapping(value = "/getGaspipeMaterialListAndCountAndList",method = RequestMethod.POST)
    public Map<String,Object> getGaspipeMaterialListAndCountAndList(GasPipeCondition gasPipeCondition){
        if(gasPipeCondition.getPageNo()!=null&&gasPipeCondition.getPageSize()!=null){
            Integer pageNo=gasPipeCondition.getPageNo();
            Integer pageSize=gasPipeCondition.getPageSize();
            gasPipeCondition.setBottom((pageNo - 1)*pageSize);
            gasPipeCondition.setTop(pageNo*pageSize);
        }
        Map<String,Object> result=null;
        //查询条件下拉列表
        List<Map<String,Object>> GasPipeGradeList=this.gasPipeService.getGaspipeMaterialList();
        //查询总记录数
        Integer count=this.gasPipeService.getGasPipeCount(gasPipeCondition);
        //查询数据列表
        List<GasPipe> list=this.gasPipeService.getGasPipeList(gasPipeCondition);
        result=new HashMap<>();
        result.put("GasPipeGradeList",GasPipeGradeList);
        result.put("count",count);
        result.put("list",list);
        return result;
    }
}
