package com.gisinfo.sand.queryGeographyInfo.geographyData.controller;

import com.gisinfo.sand.core.security.EncryptDisable;
import com.gisinfo.sand.queryGeographyInfo.geographyData.bean.Stratigraphy;
import com.gisinfo.sand.queryGeographyInfo.geographyData.condition.StratigraphyCondition;
import com.gisinfo.sand.queryGeographyInfo.geographyData.service.StratigraphyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//查询地层相关数据的控制类
@RestController
public class StratigraphyController {
    @Autowired
    private StratigraphyService stratigraphyService;

    //查询地层数据列表及总条数
    @EncryptDisable
    @RequestMapping(value = "/getStratigraphyListandCount" ,method = RequestMethod.POST)
    public Map<String,Object> getStratigraphyListandCount(StratigraphyCondition stratigraphyCondition){
        if(stratigraphyCondition.getPageNo()!=null&&stratigraphyCondition.getPageSize()!=null){
            Integer pageNo=stratigraphyCondition.getPageNo();
            Integer pageSize=stratigraphyCondition.getPageSize();
            stratigraphyCondition.setBottom((pageNo-1)*pageSize);
            stratigraphyCondition.setTop(pageNo*pageSize);
        }
        Map<String,Object> result=null;
        //查询总记录数
        Integer count=this.stratigraphyService.getStratigraphyCount(stratigraphyCondition);
        //查询记录列表
        List<Stratigraphy> list=this.stratigraphyService.getStratigraphyList(stratigraphyCondition);
        result = new HashMap<>();
        result.put("count",count);
        result.put("list",list);
        return result;
    }
}
