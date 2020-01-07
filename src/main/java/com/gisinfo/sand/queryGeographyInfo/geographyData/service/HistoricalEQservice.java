package com.gisinfo.sand.queryGeographyInfo.geographyData.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gisinfo.sand.queryGeographyInfo.geographyData.bean.HistoricalEQ;
import com.gisinfo.sand.queryGeographyInfo.geographyData.condition.HistoricalEQcondition;
import com.gisinfo.sand.queryGeographyInfo.geographyData.dao.HistoricalEQmapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class HistoricalEQservice extends ServiceImpl<HistoricalEQmapper,HistoricalEQ>{
    @Autowired(required = false)
    private HistoricalEQmapper historicalEQmapper;

    //查询总记录数
    public Integer getHistoricalEQCount(HistoricalEQcondition historicalEQcondition){
        Map<String,Object> data=this.historicalEQmapper.getHistoricalEQCount(historicalEQcondition);
        Integer count =Integer.parseInt(data.get("count").toString());
        return count;
    }

    //查询数据列表
    public List<HistoricalEQ> getHistoricalEQlist(HistoricalEQcondition historicalEQcondition){
        List<HistoricalEQ> data=this.historicalEQmapper.getHistoricalEQlist(historicalEQcondition);
        return  data;
    }
}
