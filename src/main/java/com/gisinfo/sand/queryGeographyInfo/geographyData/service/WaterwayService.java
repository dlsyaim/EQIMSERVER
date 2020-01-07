package com.gisinfo.sand.queryGeographyInfo.geographyData.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gisinfo.sand.queryGeographyInfo.geographyData.bean.WaterWay;
import com.gisinfo.sand.queryGeographyInfo.geographyData.condition.WaterwayCondition;
import com.gisinfo.sand.queryGeographyInfo.geographyData.dao.WaterwayMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

//水道服务类
@Service
public class WaterwayService extends ServiceImpl<WaterwayMapper, WaterWay> {
    @Autowired(required = false)
    private WaterwayMapper waterwayMapper;

    //查询水道类别下拉列表
    public List<Map<String,Object>> getWaterwayClassList(){
        List<Map<String,Object>> data=this.waterwayMapper.getWaterwayClassList();
        return data;
    }

    //查询总记录条数
    public Integer getWaterwayCount(WaterwayCondition waterwayCondition){
        Map<String,Object> data=this.waterwayMapper.getWaterwayCount(waterwayCondition);
        Integer count=Integer.parseInt(data.get("count").toString());
        return count;
    }

    //查询数据列表
    public List<WaterWay> getWaterwayList(WaterwayCondition waterwayCondition){
        List<WaterWay> data=this.waterwayMapper.getWaterwayList(waterwayCondition);
        return data;
    }
}
