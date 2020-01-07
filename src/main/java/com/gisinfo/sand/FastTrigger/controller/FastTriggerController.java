package com.gisinfo.sand.FastTrigger.controller;

import com.gisinfo.sand.FastTrigger.service.FastTriggerService;
import com.gisinfo.sand.core.security.EncryptDisable;
import com.gisinfo.sand.dataManage.service.EarthquakeInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Timer;
import java.util.TimerTask;

//快速触发控制类
@RestController
public class FastTriggerController {
    @Autowired
    private FastTriggerService fastTriggerService;

    @Autowired
    private EarthquakeInfoService earthquakeInfoService;

    //添加数据
    @EncryptDisable
    @RequestMapping(value = "/addEQinfoData", method = RequestMethod.POST)
    public void addEQinfoData(){
        this.fastTriggerService.addEQinfoData();
    }

    //自动触发
    @EncryptDisable
    @RequestMapping(value = "/autoTrigger", method = RequestMethod.POST)
    public void autoTrigger(){
        System.out.println("*********自动触发**********");


    }

}
