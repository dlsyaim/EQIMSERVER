package com.gisinfo.sand.commonData.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gisinfo.sand.commonData.bean.EqCountyPopulation;
import com.gisinfo.sand.commonData.dao.EqCountyPopulationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class EqCountyPopulationService extends ServiceImpl<EqCountyPopulationMapper, EqCountyPopulation> {

    @Autowired(required = false)
    private EqCountyPopulationMapper populationMapper;


    public List<Map> getListPage(EqCountyPopulation queryConditions) {
        List<Map> list = populationMapper.queryPageList(queryConditions);
        return list;
    }

    public Map<String, Object> getCount(EqCountyPopulation queryConditions) {
        return this.populationMapper.getTotalCount(queryConditions);
    }

}
