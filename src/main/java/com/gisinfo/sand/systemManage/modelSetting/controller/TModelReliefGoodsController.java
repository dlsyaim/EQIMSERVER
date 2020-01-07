package com.gisinfo.sand.systemManage.modelSetting.controller;

import com.gisinfo.sand.core.security.EncryptDisable;
import com.gisinfo.sand.systemManage.modelSetting.bean.*;
import com.gisinfo.sand.systemManage.modelSetting.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class TModelReliefGoodsController {

    @Autowired
    private TModelReliefGoodsService tModelReliefGoodsService;

    @Autowired
    private CalcModelService calcModelService;


    //添加修改后的救援物资模型参数
    @EncryptDisable
    @RequestMapping(value = "/addReliefGoods",method = RequestMethod.POST)
    public void addReliefGoodsModel(@RequestBody List<Map<String,Object>> param){
        this.tModelReliefGoodsService.addReliefGoodsData(param);
    }

    //获取最新的救援物资模型参数
    @EncryptDisable
    @RequestMapping(value = "/getReliefGoddsParams",method = RequestMethod.GET)
    public List<Map<String,Object>> getReliefGoddsParams(){
        return this.tModelReliefGoodsService.getReliefGoodsParams();
    }

    //测试计算帐篷模型
    @EncryptDisable
    @RequestMapping(value = "/calcToiletModel",method = RequestMethod.GET)
    public void calcTentModel(){
        String townName = "高翔镇";
        String earthquakeFeatId = "abcd";
        Integer Ho = 100;
        this.calcModelService.calcToiletModel(townName,earthquakeFeatId,Ho);
    }

}
