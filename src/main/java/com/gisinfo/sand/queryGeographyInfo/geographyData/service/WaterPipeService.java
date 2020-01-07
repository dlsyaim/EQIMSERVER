package com.gisinfo.sand.queryGeographyInfo.geographyData.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gisinfo.sand.queryGeographyInfo.geographyData.bean.WaterPipe;
import com.gisinfo.sand.queryGeographyInfo.geographyData.condition.WaterPipeCondition;
import com.gisinfo.sand.queryGeographyInfo.geographyData.dao.WaterPipeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

//供水主干管网服务类
@Service
public class WaterPipeService extends ServiceImpl<WaterPipeMapper, WaterPipe> {
    @Autowired(required = false)
    private WaterPipeMapper waterPipeMapper;

    //查询类别列表
    public List<Map<String,Object>> getWaterPipeClassList(){
        List<Map<String,Object>> data=this.waterPipeMapper.getWaterPipeClassList();
        return data;
    }

    //查询材料列表
    public List<Map<String,Object>> getWaterpipeMateialList(){
        List<Map<String,Object>> data=this.waterPipeMapper.getWaterpipeMateialList();
        return data;
    }

    //查询总记录数
    public Integer getWaterPipeCount(WaterPipeCondition waterPipeCondition){
        Map<String,Object> data=this.waterPipeMapper.getWaterPipeCount(waterPipeCondition);
        Integer count=Integer.parseInt(data.get("count").toString());
        return count;
    }

    //查询数据列表
    public List<WaterPipe> getWaterPipeList(WaterPipeCondition waterPipeCondition){
        List<WaterPipe> list=this.waterPipeMapper.getWaterPipeList(waterPipeCondition);
        return list;
    }
}
