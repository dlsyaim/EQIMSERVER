package com.gisinfo.sand.commonData.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gisinfo.sand.commonData.bean.EqTownPopulation;
import com.gisinfo.sand.commonData.dao.EqTownPopulationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class EqTownPopulationService extends ServiceImpl<EqTownPopulationMapper,EqTownPopulation>{
    @Autowired(required = false)
    private EqTownPopulationMapper townPopulationMapper;


    public List<Map> getListPage(EqTownPopulation queryConditions) {
        List<Map> list = townPopulationMapper.queryPageList(queryConditions);
        return list;
    }

    public Map<String, Object> getCount(EqTownPopulation queryConditions) {
        return this.townPopulationMapper.getTotalCount(queryConditions);
    }
}
