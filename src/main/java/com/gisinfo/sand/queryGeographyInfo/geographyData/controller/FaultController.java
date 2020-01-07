package com.gisinfo.sand.queryGeographyInfo.geographyData.controller;

import com.gisinfo.sand.core.security.EncryptDisable;
import com.gisinfo.sand.queryGeographyInfo.geographyData.bean.Fault;
import com.gisinfo.sand.queryGeographyInfo.geographyData.condition.FaultCondition;
import com.gisinfo.sand.queryGeographyInfo.geographyData.service.FaultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//断裂相关控制层
@RestController
public class FaultController {
    @Autowired
    private FaultService faultService;

    //查询断裂记录列表和总计录数
    @EncryptDisable
    @RequestMapping(value = "/getFaultlistAndcount",method = RequestMethod.POST)
    public Map<String,Object> getFaultlistAndcount(FaultCondition faultCondition){
        if(faultCondition.getPageNo()!=null&&faultCondition.getPageSize()!=null){
            Integer pageNo=faultCondition.getPageNo();
            Integer pageSize=faultCondition.getPageSize();
            faultCondition.setBottom((pageNo - 1)*pageSize);
            faultCondition.setTop(pageNo*pageSize);
        }
        Map<String,Object> result=null;
        //查询记录总条数
        Integer count=this.faultService.getFaultcount(faultCondition);
        //查询记录列表
        List<Fault> list=this.faultService.getFaultlist(faultCondition);
        result =new HashMap<>();
        result.put("count",count);
        result.put("list",list);
        return result;
    }
}
