package com.gisinfo.sand.queryGeographyInfo.geographyData.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gisinfo.sand.queryGeographyInfo.geographyData.bean.Stratigraphy;
import com.gisinfo.sand.queryGeographyInfo.geographyData.condition.StratigraphyCondition;
import com.gisinfo.sand.queryGeographyInfo.geographyData.dao.StratigraphyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

//处理查询地层相关数据的服务类
@Service
public class StratigraphyService extends ServiceImpl<StratigraphyMapper, Stratigraphy> {
    @Autowired(required = false)
    private StratigraphyMapper stratigraphyMapper;


    //查询总记录数
    public Integer getStratigraphyCount(StratigraphyCondition stratigraphyCondition){
        Map<String,Object> data=this.stratigraphyMapper.getHistoricalEQCount(stratigraphyCondition);
        Integer count=Integer.parseInt(data.get("count").toString());
        return count;
    }


    //查询数据列表
    public List<Stratigraphy> getStratigraphyList(StratigraphyCondition stratigraphyCondition){
        List<Stratigraphy> data=this.stratigraphyMapper.getHistoricalEQlist(stratigraphyCondition);
        return data;
    }
}
