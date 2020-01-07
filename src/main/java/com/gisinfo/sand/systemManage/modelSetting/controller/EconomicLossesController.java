package com.gisinfo.sand.systemManage.modelSetting.controller;
import com.gisinfo.sand.core.security.EncryptDisable;
import com.gisinfo.sand.systemManage.modelSetting.bean.EconomicLosses;
import com.gisinfo.sand.systemManage.modelSetting.service.EconomicLossesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class EconomicLossesController {
    @Autowired
    private EconomicLossesService economicLossesService;

    //查询最新经济损失数据
    @EncryptDisable
    @RequestMapping(value = "/getEconomicLossesData", method = RequestMethod.GET)
    public List<EconomicLosses> getEconomicLossesData(){
        String modelVersion=this.economicLossesService.getNewestVersion();
        List<EconomicLosses> result=this.economicLossesService.getEconomicLossesData(modelVersion);
        return result;
    }

    //更新经济损失数据
    @EncryptDisable
    @RequestMapping(value = "/updateEconomicLossesData", method = RequestMethod.POST)
    public void updateEconomicLossesData(@RequestBody  List<Map<String,Object>> economicLossesParams){
        String version=this.economicLossesService.getNewestVersion();
        Integer modelVersion=Integer.parseInt(version)+1;
        this.economicLossesService.updateEconomicLossesData(economicLossesParams,modelVersion.toString());
    }

}
