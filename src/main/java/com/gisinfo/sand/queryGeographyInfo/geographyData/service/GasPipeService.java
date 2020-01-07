package com.gisinfo.sand.queryGeographyInfo.geographyData.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gisinfo.sand.queryGeographyInfo.geographyData.bean.GasPipe;
import com.gisinfo.sand.queryGeographyInfo.geographyData.condition.GasPipeCondition;
import com.gisinfo.sand.queryGeographyInfo.geographyData.dao.GasPipeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

//燃气管网服务类
@Service
public class GasPipeService extends ServiceImpl<GasPipeMapper, GasPipe> {

    @Autowired(required = false)
    private GasPipeMapper gasPipeMapper;

    //查询桥梁类别列表
    public List<Map<String,Object>> getGaspipeMaterialList(){
        List<Map<String,Object>> data=this.gasPipeMapper.getGaspipeMaterialList();
        return data;
    }

    //查询桥梁总记录数
    public Integer getGasPipeCount(GasPipeCondition gasPipeCondition){
        Map<String,Object> data=this.gasPipeMapper.getGasPipeCount(gasPipeCondition);
        Integer count=Integer.parseInt(data.get("count").toString());
        return count;
    }

    //查询桥梁数据列表
    public List<GasPipe> getGasPipeList(GasPipeCondition gasPipeCondition){
        List<GasPipe> list=this.gasPipeMapper.getGasPipeList(gasPipeCondition);
        return list;
    }
    
}
