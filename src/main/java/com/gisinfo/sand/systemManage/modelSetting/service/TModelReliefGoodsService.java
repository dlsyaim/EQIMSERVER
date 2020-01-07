package com.gisinfo.sand.systemManage.modelSetting.service;

import cn.hutool.core.util.IdUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gisinfo.sand.systemManage.modelSetting.bean.TModelReliefGoods;
import com.gisinfo.sand.systemManage.modelSetting.dao.TModelReliefGoodsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TModelReliefGoodsService extends ServiceImpl<TModelReliefGoodsMapper, TModelReliefGoods>{
    @Autowired(required = false)
    private TModelReliefGoodsMapper tModelReliefGoodsMapper;

    private TModelReliefGoods reliefGoods;

    //查询救援物资模型最大版本号
    public String getMaxVersion(){
        Map<String,Object> version=this.tModelReliefGoodsMapper.getMaxVersion();
        String maxVersion = version.get("maxVersion").toString();
        return maxVersion;
    }

    //添加救援物资模型参数
    @Transactional
    public void addReliefGoodsData(List<Map<String,Object>> params){
        String currentVersion=this.getMaxVersion();
        Integer updatedVersion = Integer.parseInt(currentVersion)+1;
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String createTimes = df.format(System.currentTimeMillis());
        for(int i=0;i<params.size();i++){
            Map<String,Object> data = params.get(i);
            data.put("featId",IdUtil.simpleUUID());
            data.put("paramName","默认参数");
            data.put("modelVersion",updatedVersion);
            data.put("updatedBy","江腾飞");
            data.put("createdBy","江腾飞");
            data.put("createTime",createTimes);
            data.put("updateTime",createTimes);
            this.tModelReliefGoodsMapper.addRelieGoodParams(data);
        }

    }


    //获取最新的救援物资模型参数
    public List<Map<String,Object>> getReliefGoodsParams(){
        String maxVersion = this.getMaxVersion();
        List<Map<String,Object>> data = this.tModelReliefGoodsMapper.getRelieGoodsParams(maxVersion);
        return  data;
    }

    //模型计算使用
    //根据模型类型获取参数
    public Map<String,Object> getModelParamsByType(String modelType){
        String maxVersion = this.getMaxVersion();
        Map<String,Object> params = new HashMap<>();
        params.put("maxVersion",maxVersion);
        params.put("modelType",modelType);
        Map<String,Object> data = this.tModelReliefGoodsMapper.getModelParamsByType(params);
        params.clear();
        return data;
    }

    //添加计算帐篷模型所得帐篷数
    public void addTentDemand(Map<String,Object> data){
        this.tModelReliefGoodsMapper.addTentDemand(data);
    }

    //添加计算灾后粮食补助模型所得粮食数
    public void addFoodSubsidy(Map<String,Object> data){
        this.tModelReliefGoodsMapper.addFoodSubsidy(data);
    }

    //添加计算棉被模型所得棉被数
    public void addQuiltDemand(Map<String,Object> data){
        this.tModelReliefGoodsMapper.addQuiltDemand(data);
    }

    //添加计算应急清洁饮水模型所得Water数
    public void addWaterDemand(Map<String,Object> data){
        this.tModelReliefGoodsMapper.addWaterDemand(data);
    }

    //添加计算衣服模型所得衣服数
    public void addClothingDemand(Map<String,Object> data){
        this.tModelReliefGoodsMapper.addClothingDemand(data);
    }

    //添加计算毛毯模型所得毛毯数
    public void addBlanketDemand(Map<String,Object> data){
        this.tModelReliefGoodsMapper.addBlanketDemand(data);
    }

    //添加计算担架模型所得担架数
    public void addstretcherDemand(Map<String,Object> data){
        this.tModelReliefGoodsMapper.addstretcherDemand(data);
    }

    //添加计算临时厕所模型所得厕所数
    public void addTemporaryToiletDemand(Map<String,Object> data){
        this.tModelReliefGoodsMapper.addTemporaryToiletDemand(data);
    }
}
