package com.gisinfo.sand.queryGeographyInfo.geographyData.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gisinfo.sand.queryGeographyInfo.geographyData.bean.Rock;
import com.gisinfo.sand.queryGeographyInfo.geographyData.condition.RockCondition;
import com.gisinfo.sand.queryGeographyInfo.geographyData.dao.RockMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

//处理查询岩体相关数据的服务类
@Service
public class RockService extends ServiceImpl<RockMapper, Rock> {
    @Autowired
    private RockMapper rockMapper;

    //查询总记录条数
    public Integer getRockcount(RockCondition rockCondition){
        Map<String,Object> data=this.rockMapper.getRockcount(rockCondition);
        Integer count=Integer.parseInt(data.get("count").toString());
        return count;
    }

    //查询数据列表
    public List<Rock> getRocklist(RockCondition rockCondition){
        List<Rock> data=this.rockMapper.getRocklist(rockCondition);
        return data;
    }
}
