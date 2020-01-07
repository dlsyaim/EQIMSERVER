package com.gisinfo.sand.commonData.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gisinfo.sand.commonData.bean.EqTownBuilding;
import com.gisinfo.sand.commonData.dao.EqTownBuildingMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
@Service
public class EqTownBuildingService extends ServiceImpl<EqTownBuildingMapper,EqTownBuilding>{
    @Autowired(required = false)
    private EqTownBuildingMapper townBuildingMapper;


    public List<EqTownBuilding> getListPage(EqTownBuilding queryConditions) {
        List<EqTownBuilding> list = townBuildingMapper.queryPageList(queryConditions);
        return list;
    }

    public Map<String, Object> getCount(EqTownBuilding queryConditions) {
        return this.townBuildingMapper.getTotalCount(queryConditions);
    }
}
