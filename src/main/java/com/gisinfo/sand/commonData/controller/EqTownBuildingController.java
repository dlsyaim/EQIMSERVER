package com.gisinfo.sand.commonData.controller;

import com.gisinfo.sand.commonData.bean.EqTownBuilding;
import com.gisinfo.sand.commonData.service.EqTownBuildingService;
import com.gisinfo.sand.core.security.EncryptDisable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class EqTownBuildingController {
    @Autowired
    private EqTownBuildingService townBuildingService;


    @EncryptDisable
    @RequestMapping(value = "/commonData/townBuilding/list", method = RequestMethod.POST)
    //获取分页列表
    public Map<String,Object> getPageData(EqTownBuilding queryConditions) {
        if (queryConditions.getPageSize() != null && queryConditions.getPageNo() != null) {
            queryConditions.setBottom((queryConditions.getPageNo() - 1) * queryConditions.getPageSize());
            queryConditions.setTop(queryConditions.getPageNo() * queryConditions.getPageSize());
        }
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("data",townBuildingService.getListPage(queryConditions));
        return map;
    }

    @EncryptDisable
    @RequestMapping(value = "/commonData/townBuilding/getCount", method = RequestMethod.POST)
    public Map<String, Object> getDataCount(EqTownBuilding queryConditions) {
        Map<String, Object> queryList = new HashMap<String, Object>();
        queryList.put("count", this.townBuildingService.getCount(queryConditions));
        return queryList;
    }
}
