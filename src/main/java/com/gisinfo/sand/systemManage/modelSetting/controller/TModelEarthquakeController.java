package com.gisinfo.sand.systemManage.modelSetting.controller;

import com.gisinfo.sand.core.security.EncryptDisable;
import com.gisinfo.sand.systemManage.modelSetting.bean.TModelEarthquake;
import com.gisinfo.sand.systemManage.modelSetting.service.TModelEarthquakeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class TModelEarthquakeController {
    @Autowired
    private TModelEarthquakeService tModelEarthquakeService;

    @EncryptDisable
    @RequestMapping(value = "/influence/addEarthquake",method = RequestMethod.POST)
    public void addEarthquakeModel(TModelEarthquake modelEarthquake){
        this.tModelEarthquakeService.addEarthquakeData(modelEarthquake);
    }

    @EncryptDisable
    @RequestMapping(value = "/influence/getAllModel",method = RequestMethod.POST)
    public void getAllModel(TModelEarthquake modelEarthquake) {
        this.tModelEarthquakeService.addEarthquakeData(modelEarthquake);
    }

    //查询救援队伍
    @EncryptDisable
    @RequestMapping(value = "/influence/getEarthquakeParams", method = RequestMethod.GET)
    public Map<String,Object> getEarthquakeParams(){
        return this.tModelEarthquakeService.getEarthquakeParams();
    }
}
