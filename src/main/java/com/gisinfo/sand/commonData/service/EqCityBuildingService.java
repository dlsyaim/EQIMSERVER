package com.gisinfo.sand.commonData.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gisinfo.sand.commonData.bean.EqCityBuilding;
import com.gisinfo.sand.commonData.dao.EqCityBuildingMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class EqCityBuildingService extends ServiceImpl<EqCityBuildingMapper,EqCityBuilding>{
    @Autowired(required = false)
    private EqCityBuildingMapper cityBuildingMapper;


    public List<Map> getListPage(EqCityBuilding queryConditions) {
        List<Map> list = cityBuildingMapper.queryPageList(queryConditions);
        return list;
    }

    public Map<String, Object> getCount(EqCityBuilding queryConditions) {
        return this.cityBuildingMapper.getTotalCount(queryConditions);
    }
}
