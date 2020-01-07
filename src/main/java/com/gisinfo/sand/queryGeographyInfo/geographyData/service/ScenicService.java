package com.gisinfo.sand.queryGeographyInfo.geographyData.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gisinfo.sand.queryGeographyInfo.geographyData.bean.Scenic;
import com.gisinfo.sand.queryGeographyInfo.geographyData.condition.ScenicCondition;
import com.gisinfo.sand.queryGeographyInfo.geographyData.dao.ScenicMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

//旅游景区服务类
@Service
public class ScenicService extends ServiceImpl<ScenicMapper, Scenic> {
    @Autowired(required = false)
    private ScenicMapper scenicMapper;

    //查询类别列表
    public List<Map<String,Object>> getScenicTypeList(){
        List<Map<String,Object>> data=this.scenicMapper.getScenicTypeList();
        return data;
    }

    //查询总记录数
    public Integer getScenicCount(ScenicCondition scenicCondition){
        Map<String,Object> data=this.scenicMapper.getScenicCount(scenicCondition);
        Integer count=Integer.parseInt(data.get("count").toString());
        return count;
    }

    //查询数据列表
    public List<Scenic> getScenicList(ScenicCondition scenicCondition){
        List<Scenic> list=this.scenicMapper.getScenicList(scenicCondition);
        return list;
    }
}
