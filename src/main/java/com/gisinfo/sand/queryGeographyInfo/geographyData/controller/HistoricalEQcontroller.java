package com.gisinfo.sand.queryGeographyInfo.geographyData.controller;

import com.gisinfo.sand.core.security.EncryptDisable;
import com.gisinfo.sand.queryGeographyInfo.geographyData.bean.HistoricalEQ;
import com.gisinfo.sand.queryGeographyInfo.geographyData.condition.HistoricalEQcondition;
import com.gisinfo.sand.queryGeographyInfo.geographyData.service.HistoricalEQservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class HistoricalEQcontroller {
    @Autowired
    private HistoricalEQservice historicalEQservice;
    //查询历史强震数据列表及总条数
    @EncryptDisable
    @RequestMapping(value = "/getHistoricalEQlist" ,method = RequestMethod.POST)
    public Map<String, Object> getHistoricalEQlist(HistoricalEQcondition historicalEQcondition,Integer pageNo, Integer pageSize){
        Map<String,Object> result=null;
        if(pageNo!=null&&pageSize!=null){
            historicalEQcondition.setBottom((pageNo-1)*pageSize);
            historicalEQcondition.setTop(pageNo*pageSize);
        }
        List<HistoricalEQ> list=this.historicalEQservice.getHistoricalEQlist(historicalEQcondition);
        Integer count=this.historicalEQservice.getHistoricalEQCount(historicalEQcondition);

        result=new HashMap<String,Object>();
        result.put("list",list);
        result.put("count",count);
        return result;
    }
}
