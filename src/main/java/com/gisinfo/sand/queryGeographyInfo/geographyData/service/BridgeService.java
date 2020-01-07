package com.gisinfo.sand.queryGeographyInfo.geographyData.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gisinfo.sand.queryGeographyInfo.geographyData.bean.Bridge;
import com.gisinfo.sand.queryGeographyInfo.geographyData.condition.BridgeCondition;
import com.gisinfo.sand.queryGeographyInfo.geographyData.dao.BridgeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

//桥梁服务类
@Service
public class BridgeService extends ServiceImpl<BridgeMapper, Bridge> {
    @Autowired(required = false)
    private BridgeMapper bridgeMapper;

    //查询桥梁类别列表
    public List<Map<String,Object>> getBridgeClassList(){
        List<Map<String,Object>> data=this.bridgeMapper.getBridgeClassList();
        return data;
    }

    //查询桥梁等级列表
    public List<Map<String,Object>> getBridgeGradeList(){
        List<Map<String,Object>> data=this.bridgeMapper.getBridgeGradeList();
        return data;
    }

    //查询桥梁总记录数
    public Integer getBridgeCount(BridgeCondition bridgeCondition){
        Map<String,Object> data=this.bridgeMapper.getBridgeCount(bridgeCondition);
        Integer count=Integer.parseInt(data.get("count").toString());
        return count;
    }

    //查询桥梁数据列表
    public List<Bridge> getBridgeList(BridgeCondition bridgeCondition){
        List<Bridge> list=this.bridgeMapper.getBridgeList(bridgeCondition);
        return list;
    }


}
