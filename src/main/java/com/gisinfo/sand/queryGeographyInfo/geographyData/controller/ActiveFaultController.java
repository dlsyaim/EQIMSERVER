package com.gisinfo.sand.queryGeographyInfo.geographyData.controller;

import com.gisinfo.sand.core.security.EncryptDisable;
import com.gisinfo.sand.queryGeographyInfo.geographyData.bean.ActiveFault;
import com.gisinfo.sand.queryGeographyInfo.geographyData.condition.ActiveFaultCondition;
import com.gisinfo.sand.queryGeographyInfo.geographyData.service.ActiveFaultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//活跃断层控制类
@RestController
public class ActiveFaultController {
    @Autowired
    private ActiveFaultService activeFaultService;

    //查询活跃断层列表及总记录条数
    @EncryptDisable
    @RequestMapping(value = "/getActiveFaultListAndCount",method = RequestMethod.POST)
    public Map<String, Object> getActiveFaultListAndCount(ActiveFaultCondition activeFaultCondition) {
        if (activeFaultCondition.getPageNo() != null && activeFaultCondition.getPageSize() != null) {
            Integer pageNo = activeFaultCondition.getPageNo();
            Integer pageSize = activeFaultCondition.getPageSize();
            activeFaultCondition.setBottom((pageNo - 1) * pageSize);
            activeFaultCondition.setTop(pageNo * pageSize);
        }
        Map<String, Object> result = null;
        //查询总记录数
        Integer count = this.activeFaultService.getActiveFaultCount(activeFaultCondition);
        //查询数据列表
        List<ActiveFault> list = this.activeFaultService.getActiveFaultList(activeFaultCondition);
        result = new HashMap<>();
        result.put("count", count);
        result.put("list", list);
        return result;
    }
}
