package com.gisinfo.sand.queryGeographyInfo.geographyData.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gisinfo.sand.queryGeographyInfo.geographyData.bean.DangerSource;
import com.gisinfo.sand.queryGeographyInfo.geographyData.condition.DangerSourceCondition;
import com.gisinfo.sand.queryGeographyInfo.geographyData.dao.DangerSourceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

//危险源服务类
@Service
public class DangerSourceService extends ServiceImpl<DangerSourceMapper, DangerSource> {
    @Autowired(required = false)
    private DangerSourceMapper dangerSourceMapper;

    //查询桥梁总记录数
    public Integer getDangerSourceCount(DangerSourceCondition dangerSourceCondition){
        Map<String,Object> data=this.dangerSourceMapper.getDangerSourceCount(dangerSourceCondition);
        Integer count=Integer.parseInt(data.get("count").toString());
        return count;
    }

    //查询桥梁数据列表
    public List<DangerSource> getDangerSourceList(DangerSourceCondition dangerSourceCondition){
        List<DangerSource> list=this.dangerSourceMapper.getDangerSourceList(dangerSourceCondition);
        return list;
    }


}
