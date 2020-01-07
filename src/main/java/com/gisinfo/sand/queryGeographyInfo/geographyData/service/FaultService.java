package com.gisinfo.sand.queryGeographyInfo.geographyData.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gisinfo.sand.queryGeographyInfo.geographyData.bean.Fault;
import com.gisinfo.sand.queryGeographyInfo.geographyData.condition.FaultCondition;
import com.gisinfo.sand.queryGeographyInfo.geographyData.dao.FaultMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

//处理断层相关业务服务类
@Service
public class FaultService extends ServiceImpl<FaultMapper, Fault> {
    @Autowired(required = false)
    private FaultMapper faultMapper;

    //查询断层记录总条数
    public Integer getFaultcount(FaultCondition faultCondition){
        Map<String,Object> data=this.faultMapper.getFaultcount(faultCondition);
        Integer count=Integer.parseInt(data.get("count").toString());
        return count;
    }

    //查询断层记录列表
    public List<Fault> getFaultlist(FaultCondition faultCondition){
        List<Fault> data=this.faultMapper.getFaultlist(faultCondition);
        return data;
    }

}
