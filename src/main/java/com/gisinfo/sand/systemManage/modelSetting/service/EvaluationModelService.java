package com.gisinfo.sand.systemManage.modelSetting.service;

import cn.hutool.core.util.IdUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gisinfo.sand.systemManage.modelSetting.bean.EconomicLosses;
import com.gisinfo.sand.systemManage.modelSetting.dao.EvaluationModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EvaluationModelService extends ServiceImpl<EvaluationModelMapper, EconomicLosses> {
    @Autowired(required = false)
    private EvaluationModelMapper evaluationModelMapper;


    /**
     * 查询模型类型数据
     */
    public List<Map<String,String>> getModelMappingData(){
        List<Map<String,String>> data = this.evaluationModelMapper.getModelMappingData();
        return data;
    }

    /**
     * 获取评估模型默认参数最大版本号
     */
    public Integer getModelSettingMaxVersion(){
        Map<String,String> version = this.evaluationModelMapper.getModelSettingMaxVersion();
        String maxVersion = "0";
        if(version !=null){
            maxVersion = version.get("maxVersion");
        }
        System.out.println(maxVersion);
        return Integer.parseInt(maxVersion);
    }

    /**
     * 修改添加评估模型默认参数
     */
    public void addOrupdateModelSettingData(List<Map<String,Object>> params){
        Integer modelVersion = this.getModelSettingMaxVersion();
        String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis());
        for(Map item:params){
            item.put("featId", IdUtil.simpleUUID());
            item.put("modelVersion",modelVersion+1);
            item.put("createTime",date);
            item.put("createdBy","jiang");
            item.put("updateTime",date);
            item.put("updatedBy","jiang");
            this.evaluationModelMapper.addModelSettingData(item);
        }
    }

    /**
     * 查询评估模型默认参数
     * @return
     */
    public List<Map<String,String>> getDefaultModelParams(){
        String modelVersion = this.getModelSettingMaxVersion().toString();
        List<Map<String,String>> data = this.evaluationModelMapper.getDefautModel(modelVersion);
        return data;
    }
}
