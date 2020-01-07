package com.gisinfo.sand.commonData.controller;

import com.gisinfo.sand.commonData.bean.EqStorage;
import com.gisinfo.sand.commonData.service.EqStorageService;
import com.gisinfo.sand.core.security.EncryptDisable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
@RestController
public class EqStorageController {
    @Autowired
    private EqStorageService storageService;


    @EncryptDisable
    @RequestMapping(value = "/commonData/storage/list", method = RequestMethod.POST)
    //获取分页列表
    public Map<String,Object> getPageData(EqStorage queryConditions) {
        if (queryConditions.getPageSize() != null && queryConditions.getPageNo() != null) {
            queryConditions.setBottom((queryConditions.getPageNo() - 1) * queryConditions.getPageSize());
            queryConditions.setTop(queryConditions.getPageNo() * queryConditions.getPageSize());
        }
        Map<String, Object> map=new HashMap<String, Object>();
        map.put("data",storageService.getListPage(queryConditions));
        return map;
    }

    @EncryptDisable
    @RequestMapping(value = "/commonData/storage/getCount", method = RequestMethod.POST)
    public Map<String, Object> getDataCount(EqStorage queryConditions) {
        Map<String, Object> queryList = new HashMap<String, Object>();
        queryList.put("count", this.storageService.getCount(queryConditions));
        return queryList;
    }
}
