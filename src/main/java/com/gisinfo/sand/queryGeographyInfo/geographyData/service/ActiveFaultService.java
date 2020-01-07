package com.gisinfo.sand.queryGeographyInfo.geographyData.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gisinfo.sand.queryGeographyInfo.geographyData.bean.ActiveFault;
import com.gisinfo.sand.queryGeographyInfo.geographyData.condition.ActiveFaultCondition;
import com.gisinfo.sand.queryGeographyInfo.geographyData.dao.ActiveFaultMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

//活跃断层处理业务服务类
@Service
public class ActiveFaultService extends ServiceImpl<ActiveFaultMapper, ActiveFault> {
    @Autowired(required = false)
    private ActiveFaultMapper activeFaultMapper;

    //查询总记录条数
    public Integer getActiveFaultCount(ActiveFaultCondition activeFaultCondition){
        Map<String,Object> data=this.activeFaultMapper.getActiveFaultCount(activeFaultCondition);
        Integer count= Integer.parseInt(data.get("count").toString());
        return count;
    }

    //查询记录列表
    public List<ActiveFault> getActiveFaultList(ActiveFaultCondition activeFaultCondition){
        List<ActiveFault> data=this.activeFaultMapper.getActiveFaultList(activeFaultCondition);
        return data;
    }


}
