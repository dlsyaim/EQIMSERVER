package com.gisinfo.sand.commonData.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gisinfo.sand.commonData.bean.EqClimate;
import com.gisinfo.sand.commonData.dao.EqClimateMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class EqClimateService extends ServiceImpl<EqClimateMapper,EqClimate>{
    @Autowired(required = false)
    private EqClimateMapper climateMapper;


    public List<Map> getListPage(EqClimate queryConditions) {
        List<Map> list = climateMapper.queryPageList(queryConditions);
        return list;
    }

    public Map<String, Object> getCount(EqClimate queryConditions) {
        return this.climateMapper.getTotalCount(queryConditions);
    }
}
