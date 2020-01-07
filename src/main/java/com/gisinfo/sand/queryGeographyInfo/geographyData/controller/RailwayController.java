package com.gisinfo.sand.queryGeographyInfo.geographyData.controller;

import com.gisinfo.sand.core.security.EncryptDisable;
import com.gisinfo.sand.queryGeographyInfo.geographyData.bean.Railway;
import com.gisinfo.sand.queryGeographyInfo.geographyData.condition.RailwayCondition;
import com.gisinfo.sand.queryGeographyInfo.geographyData.service.RailwayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//铁路控制类
@RestController
public class RailwayController {
    @Autowired
    private RailwayService railwayService;

    //获取铁路数据列表、总记录数、铁路类别下拉列表
    @EncryptDisable
    @RequestMapping(value = "/getRailwayListAndCountAndClassList",method = RequestMethod.POST)
    public Map<String,Object> getRailwayListAndCountAndClassList(RailwayCondition railwayCondition){
        if(railwayCondition.getPageNo()!=null&&railwayCondition.getPageSize()!=null){
            Integer pageNo=railwayCondition.getPageNo();
            Integer pageSize=railwayCondition.getPageSize();
            railwayCondition.setBottom((pageNo - 1)*pageSize);
            railwayCondition.setTop(pageNo*pageSize);
        }
        Map<String,Object> result=new HashMap<String,Object>();
        //查询数据列表
        List<Railway> list=this.railwayService.getRailwayList(railwayCondition);
        //查询总记录数
        Integer count=this.railwayService.getRailwayCount(railwayCondition);
        //查询类别列表
        List<Map<String,Object>> selectList=this.railwayService.getRailwayClassList();
        result=new HashMap<>();
        result.put("count",count);
        result.put("list",list);
        result.put("selectList",selectList);
        return result;
    }

}
