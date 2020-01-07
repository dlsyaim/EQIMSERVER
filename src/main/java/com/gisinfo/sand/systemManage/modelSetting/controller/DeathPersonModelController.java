package com.gisinfo.sand.systemManage.modelSetting.controller;

import com.gisinfo.sand.core.security.EncryptDisable;
import com.gisinfo.sand.systemManage.modelSetting.bean.DeathPersonModel;
import com.gisinfo.sand.systemManage.modelSetting.service.DeathPersonModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class DeathPersonModelController {
    @Autowired
    private DeathPersonModelService deathPersonModelService;

    @EncryptDisable
    @RequestMapping(value = "/listDeath",method = RequestMethod.POST)
    public List<DeathPersonModel> getListDeath(DeathPersonModel deathPersonModel){// 获取所有模型公式方法
        if (deathPersonModel.getPageSize() != null && deathPersonModel.getPageNo() != null) {
            deathPersonModel.setBottom((deathPersonModel.getPageNo() - 1) * deathPersonModel.getPageSize());
            deathPersonModel.setTop(deathPersonModel.getPageNo() * deathPersonModel.getPageSize());
        }
        return this.deathPersonModelService.listDeath(deathPersonModel);
    }

    @EncryptDisable
    @RequestMapping(value = "/listDeathModelCount",method = RequestMethod.POST)
    public Map<String, Object> listCount(){
        Map<String, Object> queryCount=new HashMap<>();
        queryCount.put("count",this.deathPersonModelService.getListCount());
        return queryCount;
    }

    @EncryptDisable
    @RequestMapping(value = "/getDeathByFeatId",method = RequestMethod.POST)
    public DeathPersonModel getDeathByFeatId(String featId){//获取单个模型公式方法
        return this.deathPersonModelService.getById(featId);
    }

    @EncryptDisable
    @RequestMapping(value = "/addDeathModel",method = RequestMethod.POST)
    public void addDeathModel(DeathPersonModel deathPersonModel){//增加模型数据方法
        this.deathPersonModelService.addDeathData(deathPersonModel);
    }

    @EncryptDisable
    @RequestMapping(value = "/deleteDeathPerson",method = RequestMethod.POST)
    public void deleteDeathPerson(String featId){ //删除模型公式方法
        this.deathPersonModelService.deleteById(featId);
    }

    @EncryptDisable
    @RequestMapping(value = "/getResultByFeatId",method = RequestMethod.POST)
    public Integer getResultByFeatId(String featId){//获取单个模型公式方法
        return this.deathPersonModelService.getResultByFeatId(featId);
    }

}
