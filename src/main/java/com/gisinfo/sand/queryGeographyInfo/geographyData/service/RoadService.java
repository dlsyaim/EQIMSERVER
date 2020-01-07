package com.gisinfo.sand.queryGeographyInfo.geographyData.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gisinfo.sand.queryGeographyInfo.geographyData.bean.Road;
import com.gisinfo.sand.queryGeographyInfo.geographyData.condition.RoadCondition;
import com.gisinfo.sand.queryGeographyInfo.geographyData.dao.RoadMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

//道路服务类
@Service
public class RoadService extends ServiceImpl<RoadMapper, Road> {
    @Autowired(required = false)
    private RoadMapper roadMapper;

    //查询道路等级下拉列表
    public List<Map<String,Object>> getRoadClassList(){
        List<Map<String,Object>> data=this.roadMapper.getRoadClassList();
        return  data;
    }

    //查询道路总记录数
    public Integer getRoadCount(RoadCondition roadCondition){
        Map<String,Object> data=this.roadMapper.getRoadCount(roadCondition);
        Integer count=Integer.parseInt(data.get("count").toString());
        return count;
    }

    //查询道路数据列表
    public List<Road> getRoadList(RoadCondition roadCondition){
        List<Road> data=this.roadMapper.getRoadList(roadCondition);
        return data;
    }

}
