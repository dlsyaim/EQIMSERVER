package com.gisinfo.sand.queryGeographyInfo.geographyData.controller;

import com.gisinfo.sand.core.security.EncryptDisable;
import com.gisinfo.sand.queryGeographyInfo.geographyData.bean.Bridge;
import com.gisinfo.sand.queryGeographyInfo.geographyData.bean.MetroLine;
import com.gisinfo.sand.queryGeographyInfo.geographyData.condition.MetroLineCondition;
import com.gisinfo.sand.queryGeographyInfo.geographyData.service.MetroLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//地铁线路控制类
@RestController
public class MetroLineController {

    @Autowired
    private MetroLineService metroLineService;

    //查询地铁线路总记录数、数据列表
    @EncryptDisable
    @RequestMapping(value="/getMetroLineCountAndList")
    public Map<String,Object> getMetroLineCountAndList(MetroLineCondition metroLineCondition){
        if(metroLineCondition.getPageNo()!=null&&metroLineCondition.getPageSize()!=null){
            Integer pageNo=metroLineCondition.getPageNo();
            Integer pageSize=metroLineCondition.getPageSize();
            metroLineCondition.setBottom((pageNo - 1)*pageSize);
            metroLineCondition.setTop(pageNo*pageSize);
        }
        Map<String,Object> result=null;
        //查询总记录数
        Integer count=this.metroLineService.getMetroLineCount(metroLineCondition);
        //查询记录列表
        List<MetroLine> list=this.metroLineService.getMetroLineList(metroLineCondition);
        result=new HashMap<>();
        result.put("count",count);
//        result.put("selectList",selectList);
        result.put("list",list);
        return result;
    }
}
