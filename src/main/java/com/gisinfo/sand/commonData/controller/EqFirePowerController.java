package com.gisinfo.sand.commonData.controller;

import com.gisinfo.sand.commonData.bean.EqFirePower;
import com.gisinfo.sand.commonData.service.EqFirePowerService;
import com.gisinfo.sand.core.security.EncryptDisable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class EqFirePowerController {
    @Autowired
    private EqFirePowerService firePowerService;


    @EncryptDisable
    @RequestMapping(value = "/commonData/firePower/list", method = RequestMethod.POST)
    //获取分页列表
    public List<Map> getPageData(EqFirePower queryConditions) {
        if (queryConditions.getPageSize() != null && queryConditions.getPageNo() != null) {
            queryConditions.setBottom((queryConditions.getPageNo() - 1) * queryConditions.getPageSize());
            queryConditions.setTop(queryConditions.getPageNo() * queryConditions.getPageSize());
        }
        return firePowerService.getListPage(queryConditions);
    }

    @EncryptDisable
    @RequestMapping(value = "/commonData/firePower/getCount", method = RequestMethod.POST)
    public Map<String, Object> getDataCount(EqFirePower queryConditions) {
        Map<String, Object> queryList = new HashMap<String, Object>();
        queryList.put("count", this.firePowerService.getCount(queryConditions));
        return queryList;
    }
}
