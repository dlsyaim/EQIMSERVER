package com.gisinfo.sand.queryGeographyInfo.geographyData.controller;

import com.gisinfo.sand.core.security.EncryptDisable;
import com.gisinfo.sand.queryGeographyInfo.geographyData.bean.Rock;
import com.gisinfo.sand.queryGeographyInfo.geographyData.condition.RockCondition;
import com.gisinfo.sand.queryGeographyInfo.geographyData.service.RockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//岩体相关控制类
@RestController
public class RockController {
    @Autowired
    private RockService rockService;

    //查询岩体相关数据列表和总记录条数
    @EncryptDisable
    @RequestMapping(value = "/getRocklistAndcount",method = RequestMethod.POST)
    public Map<String,Object> getRocklistAndcount(RockCondition rockCondition){
        if(rockCondition.getPageNo()!=null&&rockCondition.getPageSize()!=null){
            Integer pageNo=rockCondition.getPageNo();
            Integer pageSize=rockCondition.getPageSize();
            rockCondition.setBottom((pageNo - 1)*pageSize);
            rockCondition.setTop(pageNo*pageSize);
        }
        Map<String,Object> result=null;
        //查询总记录条数
        Integer count=this.rockService.getRockcount(rockCondition);
        //查询数据列表
        List<Rock> list=this.rockService.getRocklist(rockCondition);
        result=new HashMap<>();
        result.put("count",count);
        result.put("list",list);
        return  result;
    }
}
