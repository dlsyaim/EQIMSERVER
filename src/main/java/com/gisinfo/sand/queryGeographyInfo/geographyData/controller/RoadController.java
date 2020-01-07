package com.gisinfo.sand.queryGeographyInfo.geographyData.controller;

import com.gisinfo.sand.core.security.EncryptDisable;
import com.gisinfo.sand.queryGeographyInfo.geographyData.bean.Road;
import com.gisinfo.sand.queryGeographyInfo.geographyData.condition.RoadCondition;
import com.gisinfo.sand.queryGeographyInfo.geographyData.service.RoadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

//道路控制类
@RestController
public class RoadController {
    @Autowired
    private RoadService roadService;

    //查询道路数据列表、总记录数、道路等级下拉列表
    @EncryptDisable
    @RequestMapping(value="/getRoadCountAndListAndClass")
    public Map<String,Object> getRoadCountAndListAndClass(RoadCondition roadCondition){
        if(roadCondition.getPageNo()!=null&&roadCondition.getPageSize()!=null){
            Integer pageNo=roadCondition.getPageNo();
            Integer pageSize=roadCondition.getPageSize();
            roadCondition.setBottom((pageNo - 1)*pageSize);
            roadCondition.setTop(pageNo*pageSize);
        }
        Map<String,Object> result=null;
        //查询道路等级下拉列表
        List<Map<String,Object>> selectList=this.roadService.getRoadClassList();
        //查询总记录条数
        Integer count=this.roadService.getRoadCount(roadCondition);
        //查询记录列表
        List<Road> list=this.roadService.getRoadList(roadCondition);
        result =new HashMap<>();
        result.put("selectList",selectList);
        result.put("count",count);
        result.put("list",list);
        return result;
    }
}
