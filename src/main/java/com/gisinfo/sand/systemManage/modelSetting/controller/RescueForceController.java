package com.gisinfo.sand.systemManage.modelSetting.controller;

import com.gisinfo.sand.core.security.EncryptDisable;
import com.gisinfo.sand.systemManage.modelSetting.bean.RescueForceModel;
import com.gisinfo.sand.systemManage.modelSetting.service.CalcModelService;
import com.gisinfo.sand.systemManage.modelSetting.service.RescueForceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class RescueForceController {
    @Autowired
    private RescueForceService rescueForceService;

    @Autowired
    private CalcModelService calcModelService;

    //查询最新的救援力量模型参数
    @EncryptDisable
    @RequestMapping(value = "/getRescueForceParams",method = RequestMethod.GET)
    public Map<String,Object> getRescueForceParams(){
        return this.rescueForceService.getRescueForceParams();
    }

    //添加模型修改后的参数
    @EncryptDisable
    @RequestMapping(value = "/addRescueForceModel",method = RequestMethod.POST)
    public void addDeathModel(RescueForceModel rescueForceModel){//增加模型数据方法
        this.rescueForceService.addRescueForceData(rescueForceModel);
    }

    //测试计算医务人员需求模型
    @EncryptDisable
    @RequestMapping(value = "/calcMedicalMember",method = RequestMethod.GET)
    public void calcMedicalMember(){
        String townName = "高翔镇";
        String earthquakeFeatId = "abcd";
        Integer De = 100;
        this.calcModelService.calcMedicalMember(townName,earthquakeFeatId,De);
    }


}
