package com.gisinfo.sand.systemManage.modelSetting.controller;

import com.gisinfo.sand.core.security.EncryptDisable;
import com.gisinfo.sand.systemManage.modelSetting.bean.TModelRescue;
import com.gisinfo.sand.systemManage.modelSetting.service.CalcModelService;
import com.gisinfo.sand.systemManage.modelSetting.service.TModelRescueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class TModelRescueController {

    @Autowired
    private TModelRescueService tModelRescueService;

    @Autowired
    private CalcModelService calcModelService;

    //查询救援队伍
    @EncryptDisable
    @RequestMapping(value = "/getRescueParams", method = RequestMethod.GET)
    public Map<String,Object> getRescueParams(){
        return this.tModelRescueService.getRescueParams();
    }
    //添加救援队伍修改后的模型参数
    @EncryptDisable
    @RequestMapping(value = "/addRescue", method = RequestMethod.POST)
    public void addRescueModel(TModelRescue tModelRescue) {
        this.tModelRescueService.addRescueData(tModelRescue);
    }

    //测试计算救援队伍模型
    @EncryptDisable
    @RequestMapping(value = "/calcRescueModel", method = RequestMethod.GET)
    public void calcRescueModel(){
        String townName = "高翔镇";
        String earthquakeFeatId = "abcd";
        Double M = 6.8;
        Integer Di = 1000;
        this.calcModelService.calcRescueModel(townName,earthquakeFeatId,M,Di);
    }
}
