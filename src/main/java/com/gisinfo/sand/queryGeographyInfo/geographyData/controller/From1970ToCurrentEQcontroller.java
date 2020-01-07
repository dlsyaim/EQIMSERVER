package com.gisinfo.sand.queryGeographyInfo.geographyData.controller;

import com.gisinfo.sand.core.security.EncryptDisable;
import com.gisinfo.sand.queryGeographyInfo.geographyData.bean.From1970ToCurrentEQ;
import com.gisinfo.sand.queryGeographyInfo.geographyData.condition.From1970ToCurrentEQcondition;
import com.gisinfo.sand.queryGeographyInfo.geographyData.service.From1970ToCurrentEQservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//1970以来小震控制层
@RestController
public class From1970ToCurrentEQcontroller {
    @Autowired
    private From1970ToCurrentEQservice from1970ToCurrentEQservice;

    //查询1970以来小震数据列表及总条数
    @EncryptDisable
    @RequestMapping(value = "/getFrom1970ToCurrentEQlistAndCount" ,method = RequestMethod.POST)
    public Map<String,Object> getFrom1970ToCurrentEQlistAndCount(From1970ToCurrentEQcondition from1970ToCurrentEQcondition){
       if(from1970ToCurrentEQcondition.getPageNo()!=null&&from1970ToCurrentEQcondition.getPageSize()!=null){
           Integer pageNo=from1970ToCurrentEQcondition.getPageNo();
           Integer pageSize=from1970ToCurrentEQcondition.getPageSize();
           from1970ToCurrentEQcondition.setBottom((pageNo-1)*pageSize);
           from1970ToCurrentEQcondition.setTop(pageNo*pageSize);
       }
        Map<String,Object> result=null;
        //总记录数
        Integer count=this.from1970ToCurrentEQservice.getFrom1970ToCurrentEQcount(from1970ToCurrentEQcondition);
        //数据列表
        List<From1970ToCurrentEQ> list=this.from1970ToCurrentEQservice.getFrom1970ToCurrentEQlist(from1970ToCurrentEQcondition);
        result=new HashMap<String,Object>();
        result.put("count",count);
        result.put("list",list);
        return result;
    }
}
