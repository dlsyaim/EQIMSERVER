package com.gisinfo.sand.commonData.controller;

import com.gisinfo.sand.commonData.bean.EqCountyPopulation;
import com.gisinfo.sand.commonData.service.EqCountyPopulationService;
import com.gisinfo.sand.core.security.EncryptDisable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class EqCountyPopulationController {

    @Autowired
    private EqCountyPopulationService countyPopulationService;


    @EncryptDisable
    @RequestMapping(value = "/commonData/countyStatistics/list", method = RequestMethod.POST)
    //获取分页列表
    public List<Map> getPageData(EqCountyPopulation queryConditions) {
        if (queryConditions.getPageSize() != null && queryConditions.getPageNo() != null) {
            queryConditions.setBottom((queryConditions.getPageNo() - 1) * queryConditions.getPageSize());
            queryConditions.setTop(queryConditions.getPageNo() * queryConditions.getPageSize());
        }
        return countyPopulationService.getListPage(queryConditions);
    }

    @EncryptDisable
    @RequestMapping(value = "/commonData/countyStatistics/getCount", method = RequestMethod.POST)
    public Map<String, Object> getDataCount(EqCountyPopulation queryConditions) {
        Map<String, Object> queryList = new HashMap<String, Object>();
        queryList.put("count", this.countyPopulationService.getCount(queryConditions));
        return queryList;
    }


}
