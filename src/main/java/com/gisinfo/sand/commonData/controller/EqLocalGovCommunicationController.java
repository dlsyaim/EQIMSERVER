package com.gisinfo.sand.commonData.controller;

import com.gisinfo.sand.commonData.bean.EqLocalGovCommunication;
import com.gisinfo.sand.commonData.service.EqLocalGovCommunicationService;
import com.gisinfo.sand.core.security.EncryptDisable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class EqLocalGovCommunicationController {
    @Autowired
    private EqLocalGovCommunicationService govCommunicationService;


    @EncryptDisable
    @RequestMapping(value = "/commonData/govCommunication/list", method = RequestMethod.POST)
    //获取分页列表
    public List<Map> getPageData(EqLocalGovCommunication queryConditions) {
        if (queryConditions.getPageSize() != null && queryConditions.getPageNo() != null) {
            queryConditions.setBottom((queryConditions.getPageNo() - 1) * queryConditions.getPageSize());
            queryConditions.setTop(queryConditions.getPageNo() * queryConditions.getPageSize());
        }
        return govCommunicationService.getListPage(queryConditions);
    }

    @EncryptDisable
    @RequestMapping(value = "/commonData/govCommunication/getCount", method = RequestMethod.POST)
    public Map<String, Object> getDataCount(EqLocalGovCommunication queryConditions) {
        Map<String, Object> queryList = new HashMap<String, Object>();
        queryList.put("count", this.govCommunicationService.getCount(queryConditions));
        return queryList;
    }
}
