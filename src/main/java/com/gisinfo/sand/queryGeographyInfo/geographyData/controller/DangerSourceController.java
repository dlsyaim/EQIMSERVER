package com.gisinfo.sand.queryGeographyInfo.geographyData.controller;

import com.gisinfo.sand.core.security.EncryptDisable;
import com.gisinfo.sand.queryGeographyInfo.geographyData.bean.DangerSource;
import com.gisinfo.sand.queryGeographyInfo.geographyData.condition.DangerSourceCondition;
import com.gisinfo.sand.queryGeographyInfo.geographyData.service.DangerSourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//危险源控制类
@RestController
public class DangerSourceController {

    @Autowired
    private DangerSourceService DangerSourceService;

    //查询桥梁等级下拉列表、列表下拉列表、总记录条数、数据列表
    @EncryptDisable
    @RequestMapping(value = "/getDangerSourceClassListAndGradeListAndCountAndList",method = RequestMethod.POST)
    public Map<String,Object> getDangerSourceClassListAndGradeListAndCountAndList(DangerSourceCondition dangerSourceCondition){
        if(dangerSourceCondition.getPageNo()!=null&&dangerSourceCondition.getPageSize()!=null){
            Integer pageNo=dangerSourceCondition.getPageNo();
            Integer pageSize=dangerSourceCondition.getPageSize();
            dangerSourceCondition.setBottom((pageNo - 1)*pageSize);
            dangerSourceCondition.setTop(pageNo*pageSize);
        }
        Map<String,Object> result=null;
        //查询总记录数
        Integer count=this.DangerSourceService.getDangerSourceCount(dangerSourceCondition);
        //查询数据列表
        List<DangerSource> list=this.DangerSourceService.getDangerSourceList(dangerSourceCondition);
        result=new HashMap<>();
        result.put("count",count);
        result.put("list",list);
        return result;
    }
}
