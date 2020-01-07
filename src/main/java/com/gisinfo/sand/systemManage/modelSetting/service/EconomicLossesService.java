package com.gisinfo.sand.systemManage.modelSetting.service;

import cn.hutool.core.util.IdUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gisinfo.sand.systemManage.modelSetting.bean.EconomicLosses;
import com.gisinfo.sand.systemManage.modelSetting.condition.UpdateEconomicLossesCondition;
import com.gisinfo.sand.systemManage.modelSetting.dao.EconomicLossesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

@Service
public class EconomicLossesService extends ServiceImpl<EconomicLossesMapper,EconomicLosses>{
    @Autowired(required = false)
    private EconomicLossesMapper economicLossesMapper;
    @Autowired(required = false)
    private SimpleDateFormat sdf;
    @Autowired(required = false)
    private UpdateEconomicLossesCondition updateEconomicLossesCondition;

    //查询最新版本号
    public String getNewestVersion(){
        Map<String,Object> version=this.economicLossesMapper.getNewestModelVersion();
        return version.get("modelVersion").toString();
    }

    //查询最新经济损失数据
    public List<EconomicLosses> getEconomicLossesData(String modelVersion){
        List<EconomicLosses> data=this.economicLossesMapper.getEconomicLosses(modelVersion);
        return data;
    }

    //更新经济损失数据
    public void updateEconomicLossesData(List<Map<String,Object>> economicLossesParams,String modelVersion){
        if(this.sdf==null){
            this.sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        }
        String createTime=this.sdf.format(System.currentTimeMillis());
        if(this.updateEconomicLossesCondition==null){
            this.updateEconomicLossesCondition =new UpdateEconomicLossesCondition();
        }
        for(int i=0;i<economicLossesParams.size();i++){
            this.updateEconomicLossesCondition.setFeatId(IdUtil.simpleUUID());
            this.updateEconomicLossesCondition.setParamName("默认参数");
            this.updateEconomicLossesCondition.setI(economicLossesParams.get(i).get("dzld").toString());
            this.updateEconomicLossesCondition.setEconomicLosses(Double.parseDouble(economicLossesParams.get(i).get("jjss").toString()));
            this.updateEconomicLossesCondition.setFormula("经济损失-按烈度");
            this.updateEconomicLossesCondition.setModelVersion(modelVersion);
            this.updateEconomicLossesCondition.setCreateTime(createTime);
            this.updateEconomicLossesCondition.setCreatedBy("江腾飞");
            this.updateEconomicLossesCondition.setUpdateTime(createTime);
            this.updateEconomicLossesCondition.setUpdatedBy("江腾飞");
            this.economicLossesMapper.updateEconomicLosses(this.updateEconomicLossesCondition);
        }
    }
}
