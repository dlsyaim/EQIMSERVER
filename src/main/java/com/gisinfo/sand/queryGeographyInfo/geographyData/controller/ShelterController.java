package com.gisinfo.sand.queryGeographyInfo.geographyData.controller;

import com.gisinfo.sand.core.security.EncryptDisable;
import com.gisinfo.sand.queryGeographyInfo.geographyData.bean.Shelter;
import com.gisinfo.sand.queryGeographyInfo.geographyData.condition.ShelterCondition;
import com.gisinfo.sand.queryGeographyInfo.geographyData.service.ShelterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//避难所控制类
@RestController
public class ShelterController {

    @Autowired
    private ShelterService shelterService;

    //查询桥梁等级下拉列表、列表下拉列表、总记录条数、数据列表
    @EncryptDisable
    @RequestMapping(value = "/getShelterClassListAndAndCountAndList",method = RequestMethod.POST)
    public Map<String,Object> getShelterClassListAndAndCountAndList(ShelterCondition ShelterCondition){
        if(ShelterCondition.getPageNo()!=null&&ShelterCondition.getPageSize()!=null){
            Integer pageNo=ShelterCondition.getPageNo();
            Integer pageSize=ShelterCondition.getPageSize();
            ShelterCondition.setBottom((pageNo - 1)*pageSize);
            ShelterCondition.setTop(pageNo*pageSize);
        }
        Map<String,Object> result=null;
        //查询桥梁类别下拉列表
        List<Map<String,Object>> ShelterClassList=this.shelterService.getShelterClassList();
        //查询总记录数
        Integer count=this.shelterService.getShelterCount(ShelterCondition);
        //查询数据列表
        List<Shelter> list=this.shelterService.getShelterList(ShelterCondition);
        result=new HashMap<>();
        result.put("ShelterClassList",ShelterClassList);
        result.put("count",count);
        result.put("list",list);
        return result;
    }
    
}
