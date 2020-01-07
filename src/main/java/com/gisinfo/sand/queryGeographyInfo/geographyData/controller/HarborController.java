package com.gisinfo.sand.queryGeographyInfo.geographyData.controller;

import com.gisinfo.sand.core.security.EncryptDisable;
import com.gisinfo.sand.queryGeographyInfo.geographyData.bean.Harbor;
import com.gisinfo.sand.queryGeographyInfo.geographyData.condition.HarborCondition;
import com.gisinfo.sand.queryGeographyInfo.geographyData.service.HarborService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//港口的控制类
@RestController
public class HarborController {
    @Autowired
    private HarborService harborService;

    //查询港口的记录总条、数据列表
    @EncryptDisable
    @RequestMapping(value = "getHarborCountAndList",method = RequestMethod.POST)
    public Map<String,Object> getHarborCountAndList(HarborCondition harborCondition){
        if(harborCondition.getPageNo()!=null&&harborCondition.getPageSize()!=null){
            Integer pageNo=harborCondition.getPageNo();
            Integer pageSize=harborCondition.getPageSize();
            harborCondition.setBottom((pageNo -1)*pageSize);
            harborCondition.setTop(pageNo*pageSize);
        }
        Map<String,Object> result=null;
        //查询总记录数
        Integer count=this.harborService.getHarborCount(harborCondition);
        //查询记录列表
        List<Harbor> list=this.harborService.getHarborList(harborCondition);
        result=new HashMap<>();
        result.put("count",count);
        result.put("list",list);
        return result;
    }
}
