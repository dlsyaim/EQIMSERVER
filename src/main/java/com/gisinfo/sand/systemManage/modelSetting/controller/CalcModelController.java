package com.gisinfo.sand.systemManage.modelSetting.controller;

import com.gisinfo.sand.core.security.EncryptDisable;
import com.gisinfo.sand.systemManage.modelSetting.service.CalcModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalcModelController {
    @Autowired
    private CalcModelService calcModelService;

    //测试计算模型
    @EncryptDisable
    @RequestMapping(value = "/testCalModel", method = RequestMethod.GET,produces="application/json")
    public void calcJZYSXJZ(){
        String earthquakeId="890e64f141734759ae8e791eda5fc2fd";
        Integer batchNumber =1;
        this.calcModelService.startCalcModel(earthquakeId,batchNumber);
    }



}
