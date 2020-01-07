package com.gisinfo.sand.queryGeographyInfo.geographyData.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gisinfo.sand.queryGeographyInfo.geographyData.bean.Railway;
import com.gisinfo.sand.queryGeographyInfo.geographyData.condition.RailwayCondition;
import com.gisinfo.sand.queryGeographyInfo.geographyData.dao.RailwayMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

//铁路服务类
@Service
public class RailwayService extends ServiceImpl<RailwayMapper, Railway> {
    @Autowired(required = false)
    private RailwayMapper railwayMapper;

    //获取铁路类别下拉列表
    public List<Map<String,Object>> getRailwayClassList(){
        List<Map<String,Object>> data=this.railwayMapper.getRailwayClassList();
        return data;
    }

    //获取铁路总记录数
    public Integer getRailwayCount(RailwayCondition railwayCondition){
        Map<String,Object> data=this.railwayMapper.getRailwayCount(railwayCondition);
        Integer count=Integer.parseInt(data.get("count").toString());
        return count;
    }

    //获取数据列表
    public List<Railway> getRailwayList(RailwayCondition railwayCondition){
        List<Railway> data=this.railwayMapper.getRailwayList(railwayCondition);
        return data;
    }
}
