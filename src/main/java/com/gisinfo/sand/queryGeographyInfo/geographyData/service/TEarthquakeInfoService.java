package com.gisinfo.sand.queryGeographyInfo.geographyData.service;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gisinfo.sand.queryGeographyInfo.geographyData.bean.TEarthquakeInfo;
import com.gisinfo.sand.queryGeographyInfo.geographyData.condition.TEarthquakeInfoCondition;
import com.gisinfo.sand.queryGeographyInfo.geographyData.dao.TEarthquakeInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

//地震触发列表服务类
@Service
public class TEarthquakeInfoService extends ServiceImpl<TEarthquakeInfoMapper, TEarthquakeInfo> {

    @Autowired(required = false)
    private TEarthquakeInfoMapper tEarthquakeInfoMapper;


    //查询总记录条数
    public Integer getTEarthquakeInfoCount(TEarthquakeInfoCondition tEarthquakeInfoCondition){
        Map<String,Object> data=this.tEarthquakeInfoMapper.getTEarthquakeInfoCount(tEarthquakeInfoCondition);
        Integer count=Integer.parseInt(data.get("count").toString());
        return count;
    }

    //查询数据列表
    public List<TEarthquakeInfo> getTEarthquakeInfoList(TEarthquakeInfoCondition tEarthquakeInfoCondition){
        List<TEarthquakeInfo> data=this.tEarthquakeInfoMapper.getTEarthquakeInfoList(tEarthquakeInfoCondition);
        return data;
    }

    //查询数据列表
    public List<Map> getTEarthquakeId(TEarthquakeInfoCondition tEarthquakeInfoCondition){
        List<Map> data=this.tEarthquakeInfoMapper.getTEarthquakeId(tEarthquakeInfoCondition);
        return data;
    }

}
