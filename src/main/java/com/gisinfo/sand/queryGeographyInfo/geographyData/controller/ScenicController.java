package com.gisinfo.sand.queryGeographyInfo.geographyData.controller;

import com.gisinfo.sand.core.security.EncryptDisable;
import com.gisinfo.sand.queryGeographyInfo.geographyData.bean.Scenic;
import com.gisinfo.sand.queryGeographyInfo.geographyData.condition.ScenicCondition;
import com.gisinfo.sand.queryGeographyInfo.geographyData.service.ScenicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//旅游景区控制类
@RestController
public class ScenicController {

    @Autowired
    private ScenicService scenicService;

    //查询桥梁等级下拉列表、列表下拉列表、总记录条数、数据列表
    @EncryptDisable
    @RequestMapping(value = "/getScenicTypeListAndCountAndList",method = RequestMethod.POST)
    public Map<String,Object> getScenicTypeListAndCountAndList(ScenicCondition scenicCondition){
        if(scenicCondition.getPageNo()!=null&&scenicCondition.getPageSize()!=null){
            Integer pageNo=scenicCondition.getPageNo();
            Integer pageSize=scenicCondition.getPageSize();
            scenicCondition.setBottom((pageNo - 1)*pageSize);
            scenicCondition.setTop(pageNo*pageSize);
        }
        Map<String,Object> result=null;
        //查询桥梁类别下拉列表
        List<Map<String,Object>> ScenicTypeList=this.scenicService.getScenicTypeList();
        //查询总记录数
        Integer count=this.scenicService.getScenicCount(scenicCondition);
        //查询数据列表
        List<Scenic> list=this.scenicService.getScenicList(scenicCondition);
        result=new HashMap<>();
        result.put("ScenicTypeList",ScenicTypeList);
        result.put("count",count);
        result.put("list",list);
        return result;
    }
    
}
