package com.gisinfo.sand.queryGeographyInfo.geographyData.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gisinfo.sand.queryGeographyInfo.geographyData.bean.UrbanRefuge;
import com.gisinfo.sand.queryGeographyInfo.geographyData.condition.UrbanRefugeCondition;
import com.gisinfo.sand.queryGeographyInfo.geographyData.dao.UrbanRefugeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
//城市避难所服务类
@Service
public class UrbanRefugeService extends ServiceImpl<UrbanRefugeMapper, UrbanRefuge> {
    @Autowired(required = false)
    private UrbanRefugeMapper urbanRefugeMapper;

    //查询类别列表
    public List<Map<String,Object>> getUrbanRefugeTypeList(){
        List<Map<String,Object>> data=this.urbanRefugeMapper.getUrbanRefugeTypeList();
        return data;
    }

    //查询等级列表
    public List<Map<String,Object>> getUrbanRefugeCitList(){
        List<Map<String,Object>> data=this.urbanRefugeMapper.getUrbanRefugeCitList();
        return data;
    }

    //查询总记录数
    public Integer getUrbanRefugeCount(UrbanRefugeCondition urbanRefugeCondition){
        Map<String,Object> data=this.urbanRefugeMapper.getUrbanRefugeCount(urbanRefugeCondition);
        Integer count=Integer.parseInt(data.get("count").toString());
        return count;
    }

    //查询数据列表
    public List<UrbanRefuge> getUrbanRefugeList(UrbanRefugeCondition urbanRefugeCondition){
        List<UrbanRefuge> list=this.urbanRefugeMapper.getUrbanRefugeList(urbanRefugeCondition);
        return list;
    }
}
