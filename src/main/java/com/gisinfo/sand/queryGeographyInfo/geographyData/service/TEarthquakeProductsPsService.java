package com.gisinfo.sand.queryGeographyInfo.geographyData.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gisinfo.sand.queryGeographyInfo.geographyData.bean.TEarthquakeProductsPs;
import com.gisinfo.sand.queryGeographyInfo.geographyData.condition.TEarthquakeProductsPsCondition;
import com.gisinfo.sand.queryGeographyInfo.geographyData.dao.TEarthquakeProductsPsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
//地震触发列表服务类
@Service
public class TEarthquakeProductsPsService extends ServiceImpl<TEarthquakeProductsPsMapper, TEarthquakeProductsPs> {


    @Autowired(required = false)
    private TEarthquakeProductsPsMapper tEarthquakeProductsPsMapper;


    //查询DOX总记录条数
    public Integer getTEarthquakeProductsPsDOXCount(TEarthquakeProductsPsCondition tEarthquakeProductsPsCondition){
        Map<String,Object> data=this.tEarthquakeProductsPsMapper.getTEarthquakeProductsPsDOXCount(tEarthquakeProductsPsCondition);
        Integer count=Integer.parseInt(data.get("count").toString());
        return count;
    }

    //查询DOX数据列表
    public List<TEarthquakeProductsPs> getTEarthquakeProductsPsDOXList(TEarthquakeProductsPsCondition tEarthquakeProductsPsCondition){
        List<TEarthquakeProductsPs> data=this.tEarthquakeProductsPsMapper.getTEarthquakeProductsPsDOXList(tEarthquakeProductsPsCondition);
        return data;
    }

    //查询JPG总记录条数
    public Integer getTEarthquakeProductsPsJPGCount(TEarthquakeProductsPsCondition tEarthquakeProductsPsCondition){
        Map<String,Object> data=this.tEarthquakeProductsPsMapper.getTEarthquakeProductsPsJPGCount(tEarthquakeProductsPsCondition);
        Integer count=Integer.parseInt(data.get("count").toString());
        return count;
    }

    //查询JPG数据列表
    public List<TEarthquakeProductsPs> getTEarthquakeProductsPsJPGList(TEarthquakeProductsPsCondition tEarthquakeProductsPsCondition){
        List<TEarthquakeProductsPs> data=this.tEarthquakeProductsPsMapper.getTEarthquakeProductsPsJPGList(tEarthquakeProductsPsCondition);
        return data;
    }

}
