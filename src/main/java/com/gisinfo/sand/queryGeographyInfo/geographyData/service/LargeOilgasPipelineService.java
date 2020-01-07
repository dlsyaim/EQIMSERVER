package com.gisinfo.sand.queryGeographyInfo.geographyData.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gisinfo.sand.queryGeographyInfo.geographyData.bean.LargeOilgasPipeline;
import com.gisinfo.sand.queryGeographyInfo.geographyData.condition.LargeOilgasPipelineCondition;
import com.gisinfo.sand.queryGeographyInfo.geographyData.dao.LargeOilgasPipelineMapper;
import com.gisinfo.sand.queryGeographyInfo.geographyData.dao.LargeOilgasPipelineMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

//大型油气管线服务类
@Service
public class LargeOilgasPipelineService extends ServiceImpl<LargeOilgasPipelineMapper, LargeOilgasPipeline> {

    @Autowired(required = false)
    private LargeOilgasPipelineMapper largeOilgasPipelineMapper;

    //查询等级列表
    public List<Map<String,Object>> getLargeOilgasPipelineClassList(){
        List<Map<String,Object>> data=this.largeOilgasPipelineMapper.getLargeOilgasPipelineClassList();
        return data;
    }

    //查询总记录数
    public Integer getLargeOilgasPipelineCount(LargeOilgasPipelineCondition largeOilgasPipelineCondition){
        Map<String,Object> data=this.largeOilgasPipelineMapper.getLargeOilgasPipelineCount(largeOilgasPipelineCondition);
        Integer count=Integer.parseInt(data.get("count").toString());
        return count;
    }

    //查询数据列表
    public List<LargeOilgasPipeline> getLargeOilgasPipelineList(LargeOilgasPipelineCondition largeOilgasPipelineCondition){
        List<LargeOilgasPipeline> list=this.largeOilgasPipelineMapper.getLargeOilgasPipelineList(largeOilgasPipelineCondition);
        return list;
    }

}
