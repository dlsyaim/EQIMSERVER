package com.gisinfo.sand.systemManage.modelSetting.controller;
import com.gisinfo.sand.core.security.EncryptDisable;
import com.gisinfo.sand.systemManage.modelSetting.bean.*;
import com.gisinfo.sand.systemManage.modelSetting.condition.UpdateJZJJSSBcondition;
import com.gisinfo.sand.systemManage.modelSetting.service.ConstructionMatrixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class ConstructionMatrixController {
    @Autowired
    private  ConstructionMatrixService constructionMatrixService;
    //---------建筑矩阵模型-----------
    //获取建筑易损性矩阵建筑类型下拉框
    @EncryptDisable
    @RequestMapping(value = "/getBuildingTypeList", method = RequestMethod.GET)
    public List<Map<String,Object>> getBuildingTypeList(){
        return this.constructionMatrixService.getBuildingTypeList();
    }

    //根据建筑类型获取建筑易损性相关矩阵数据
    @EncryptDisable
    @RequestMapping(value = "/getYSDataByBuildingType", method = RequestMethod.POST)
    public List<ConstructionYS> getYSDataByBuildingType(String buildingType){
        Integer modelVersion=this.constructionMatrixService.getCurrentVersion()-1;
        return this.constructionMatrixService.getYSDataByBuildingType(buildingType,modelVersion.toString());
    }

    //获取建筑破坏比数据
    @EncryptDisable
    @RequestMapping(value = "/getPHBData", method = RequestMethod.GET)
    public List<ConstructionPHB> getPHBData(){
        Integer modelVersion=this.constructionMatrixService.getCurrentVersion()-1;
        return this.constructionMatrixService.getPHBData(modelVersion.toString());
    }

    //获取建筑经济损失比数据
    @EncryptDisable
    @RequestMapping(value = "/getJJSSBData", method = RequestMethod.GET)
    public ConstructionJJSSB getJJSSBData(){
        Integer modelVersion=this.constructionMatrixService.getCurrentVersion()-1;
        return this.constructionMatrixService.getJJSSBData(modelVersion.toString());
    }

    //更新建筑易损性矩阵相关数据
    @EncryptDisable
    @RequestMapping(value = "/updateJZYSdata", method = RequestMethod.POST,produces="application/json")
    public void updateJZYSdata( @RequestBody List<Map<String,Object>> ysParam){
        Integer modelVersion=this.constructionMatrixService.getCurrentVersion();
        this.constructionMatrixService.updateJZYS(ysParam,modelVersion);

    }

    //更新建筑破坏比相关数据
    @EncryptDisable
    @RequestMapping(value = "/updateJZPHBdata", method = RequestMethod.POST,produces="application/json")
    public void updateJZPHBdata( @RequestBody List<Map<String,Object>> jzphbParam){
        Integer modelVersion=this.constructionMatrixService.getCurrentVersion();
        this.constructionMatrixService.updateJZPHB(jzphbParam,modelVersion);

    }

    //更新建筑经济损失比数据
    @RequestMapping(value = "/updateJZJJSSBdata", method = RequestMethod.POST,produces="application/json")
    public void updateJZJJSSBdata(UpdateJZJJSSBcondition updateJZJJSSBcondition){
        Integer modelVersion=this.constructionMatrixService.getCurrentVersion();
        this.constructionMatrixService.updateJZJJSSB(updateJZJJSSBcondition,modelVersion);

    }


}
