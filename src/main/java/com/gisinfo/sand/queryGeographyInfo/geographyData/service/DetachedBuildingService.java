package com.gisinfo.sand.queryGeographyInfo.geographyData.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gisinfo.sand.queryGeographyInfo.geographyData.bean.DetachedBuilding;
import com.gisinfo.sand.queryGeographyInfo.geographyData.condition.DetachedBuildingCondition;
import com.gisinfo.sand.queryGeographyInfo.geographyData.dao.DetachedBuildingMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

//独立建筑服务类
@Service
public class DetachedBuildingService extends ServiceImpl<DetachedBuildingMapper, DetachedBuilding> {

    @Autowired(required = false)
    private DetachedBuildingMapper detachedBuildingMapper;

    //查询桥梁类别列表
    public List<Map<String,Object>> getDetachedBuildingTypeList(){
        List<Map<String,Object>> data=this.detachedBuildingMapper.getDetachedBuildingTypeList();
        return data;
    }



    //查询桥梁总记录数
    public Integer getDetachedBuildingCount(DetachedBuildingCondition DetachedBuildingCondition){
        Map<String,Object> data=this.detachedBuildingMapper.getDetachedBuildingCount(DetachedBuildingCondition);
        Integer count=Integer.parseInt(data.get("count").toString());
        return count;
    }

    //查询桥梁数据列表
    public List<DetachedBuilding> getDetachedBuildingList(DetachedBuildingCondition DetachedBuildingCondition){
        List<DetachedBuilding> list=this.detachedBuildingMapper.getDetachedBuildingList(DetachedBuildingCondition);
        return list;
    }
    
}
