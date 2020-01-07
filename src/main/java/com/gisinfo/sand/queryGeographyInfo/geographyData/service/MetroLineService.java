package com.gisinfo.sand.queryGeographyInfo.geographyData.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gisinfo.sand.queryGeographyInfo.geographyData.bean.MetroLine;
import com.gisinfo.sand.queryGeographyInfo.geographyData.condition.MetroLineCondition;
import com.gisinfo.sand.queryGeographyInfo.geographyData.dao.MetroLineMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

//地铁线路服务类
@Service
public class MetroLineService extends ServiceImpl<MetroLineMapper, MetroLine> {

    @Autowired(required = false)
    private MetroLineMapper metroLineMapper;

    //查询总记录条数
    public Integer getMetroLineCount(MetroLineCondition metroLineCondition){
        Map<String,Object> data=this.metroLineMapper.getMetroLineCount(metroLineCondition);
        Integer count=Integer.parseInt(data.get("count").toString());
        return count;
    }

    //查询数据列表
    public List<MetroLine> getMetroLineList(MetroLineCondition metroLineCondition){
        List<MetroLine> data=this.metroLineMapper.getMetroLineList(metroLineCondition);
        return data;
    }

}
