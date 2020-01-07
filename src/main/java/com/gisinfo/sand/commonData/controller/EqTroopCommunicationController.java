package com.gisinfo.sand.commonData.controller;

import com.gisinfo.sand.commonData.bean.EqTroopCommunication;
import com.gisinfo.sand.commonData.service.EqTroopCommunicationService;
import com.gisinfo.sand.core.security.EncryptDisable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class EqTroopCommunicationController {
    @Autowired
    private EqTroopCommunicationService troopCommunicationService;


    @EncryptDisable
    @RequestMapping(value = "/commonData/troopCommunication/list", method = RequestMethod.POST)
    //获取分页列表
    public List<Map> getPageData(EqTroopCommunication queryConditions) {
        if (queryConditions.getPageSize() != null && queryConditions.getPageNo() != null) {
            queryConditions.setBottom((queryConditions.getPageNo() - 1) * queryConditions.getPageSize());
            queryConditions.setTop(queryConditions.getPageNo() * queryConditions.getPageSize());
        }
        return troopCommunicationService.getListPage(queryConditions);
    }

    @EncryptDisable
    @RequestMapping(value = "/commonData/troopCommunication/getCount", method = RequestMethod.POST)
    public Map<String, Object> getDataCount(EqTroopCommunication queryConditions) {
        Map<String, Object> queryList = new HashMap<String, Object>();
        queryList.put("count", this.troopCommunicationService.getCount(queryConditions));
        return queryList;
    }
}
