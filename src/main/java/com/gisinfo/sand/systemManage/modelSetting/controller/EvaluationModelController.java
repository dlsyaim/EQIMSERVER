package com.gisinfo.sand.systemManage.modelSetting.controller;

import com.gisinfo.sand.core.security.EncryptDisable;
import com.gisinfo.sand.systemManage.modelSetting.service.EvaluationModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class EvaluationModelController {
    @Autowired
    private EvaluationModelService evaluationModelService;

    /**
     * 获取模型Mapping数据
     * @return
     */
    @EncryptDisable
    @RequestMapping(value = "/getModelMappingData", method = RequestMethod.GET,produces="application/json")
    public List<Map<String,String>> getModelMappingData(){
        return this.evaluationModelService.getModelMappingData();
    }

    /**
     *添加修改默认模型参数
     * @param params
     */
    @EncryptDisable
    @RequestMapping(value = "/addOrupdateModelSettingData", method = RequestMethod.POST,produces="application/json")
    public void addOrupdateModelSettingData(@RequestBody List<Map<String,Object>> params){
        this.evaluationModelService.addOrupdateModelSettingData(params);
    }

    /**
     * 查询评估模型默认参数
     * @return
     */
    @EncryptDisable
    @RequestMapping(value = "/getDefaultModelParams", method = RequestMethod.GET,produces="application/json")
    public List<Map<String,String>> getDefaultModelParams(){
        return this.evaluationModelService.getDefaultModelParams();
    }
}
