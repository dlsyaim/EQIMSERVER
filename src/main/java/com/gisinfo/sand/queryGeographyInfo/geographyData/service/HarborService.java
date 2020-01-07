package com.gisinfo.sand.queryGeographyInfo.geographyData.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gisinfo.sand.queryGeographyInfo.geographyData.bean.Harbor;
import com.gisinfo.sand.queryGeographyInfo.geographyData.condition.HarborCondition;
import com.gisinfo.sand.queryGeographyInfo.geographyData.dao.HarborMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

//港口服务类
@Service
public class HarborService extends ServiceImpl<HarborMapper, Harbor> {
    @Autowired(required = false)
    private HarborMapper harborMapper;

    //查询总记录
    public Integer getHarborCount(HarborCondition harborCondition){
        Map<String,Object> data=this.harborMapper.getHarborCount(harborCondition);
        Integer count=Integer.parseInt(data.get("count").toString());
        return count;
    }

    //查询数据列表
    public List<Harbor> getHarborList(HarborCondition harborCondition){
        List<Harbor> data=this.harborMapper.getHarborList(harborCondition);
        return data;
    }
}
