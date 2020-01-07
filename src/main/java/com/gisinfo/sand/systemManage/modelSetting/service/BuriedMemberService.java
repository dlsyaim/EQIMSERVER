package com.gisinfo.sand.systemManage.modelSetting.service;

import cn.hutool.core.util.IdUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gisinfo.sand.systemManage.modelSetting.bean.BuriedACSBL;
import com.gisinfo.sand.systemManage.modelSetting.bean.BuriedAJZBL;
import com.gisinfo.sand.systemManage.modelSetting.condition.UpdateBuriedACSBLcondition;
import com.gisinfo.sand.systemManage.modelSetting.condition.UpdateBuriedAJZBLcondition;
import com.gisinfo.sand.systemManage.modelSetting.dao.BuriedMemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

@Service
public class BuriedMemberService extends ServiceImpl<BuriedMemberMapper,BuriedAJZBL> {
    @Autowired(required = false)
    private BuriedMemberMapper buriedMemberMapper;
    @Autowired(required = false)
    SimpleDateFormat sdf;
    @Autowired(required = false)
    UpdateBuriedAJZBLcondition updateBuriedAJZBLcondition;
    @Autowired(required = false)
    UpdateBuriedACSBLcondition updateBuriedACSBLcondition;

    //获取最新的数据版本号
    public String getNewestVersion(){
        Map<String,Object> version=this.buriedMemberMapper.getNewestmodelVersion();
        String modelVersion=version.get("modelVersion").toString();
        return modelVersion;
    }

    //根据最新版本号获取建筑比例数据
    public List<BuriedAJZBL> getBuriedAJZBLdata(String modelVersion){
        List<BuriedAJZBL> data=this.buriedMemberMapper.getBuriedAZJBL(modelVersion);
        return data;
    }

    //根据最新版本号获取城市比例数据
    public List<BuriedACSBL> getBuriedACSBLdata(String modelVersion){
        List<BuriedACSBL> data =this.buriedMemberMapper.getBuriedACSBL(modelVersion);
        return data;
    }

    //更新压埋人员按建筑比例模型数据
    @Transactional
    public void updateBuriedAJZBLdata(List<Map<String,Object>> ajzblParams,String modelVersion){
        if(this.sdf==null){
            this.sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        }
        String createTime=sdf.format(System.currentTimeMillis());
        if(this.updateBuriedAJZBLcondition==null){
            this.updateBuriedAJZBLcondition =new UpdateBuriedAJZBLcondition();
        }
        for(int i=0;i<ajzblParams.size();i++){
            this.updateBuriedAJZBLcondition.setFeatId(IdUtil.simpleUUID());
            this.updateBuriedAJZBLcondition.setParamName("默认参数");
            this.updateBuriedAJZBLcondition.setCategory(ajzblParams.get(i).get("jzlx").toString());
            this.updateBuriedAJZBLcondition.setPercentBuried(Double.parseDouble(ajzblParams.get(i).get("ymbl").toString()));
            this.updateBuriedAJZBLcondition.setFormula("按建筑比例");
            this.updateBuriedAJZBLcondition.setModelVersion(modelVersion);
            this.updateBuriedAJZBLcondition.setCreateTime(createTime);
            this.updateBuriedAJZBLcondition.setCreatedBy("江腾飞");
            this.updateBuriedAJZBLcondition.setUpdateTime(createTime);
            this.updateBuriedAJZBLcondition.setUpdatedBy("江腾飞");
            this.buriedMemberMapper.updateBuriedAJZBL(this.updateBuriedAJZBLcondition);
        }
    }

    //更新压埋人员按城市比例模型数据
    @Transactional
    public void updateBuriedACSBLdata(List<Map<String,Object>> acsblParams,String modelVersion){
        if(this.sdf==null){
            this.sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        }
        String createTime=sdf.format(System.currentTimeMillis());
        if(this.updateBuriedACSBLcondition==null){
            this.updateBuriedACSBLcondition =new UpdateBuriedACSBLcondition();
        }
        for(int i=0;i<acsblParams.size();i++){
            this.updateBuriedACSBLcondition.setFeatId(IdUtil.simpleUUID());
            this.updateBuriedACSBLcondition.setParamName("默认参数");
            this.updateBuriedACSBLcondition.setCategory(acsblParams.get(i).get("cslx").toString());
            this.updateBuriedACSBLcondition.setPercentBuried(Double.parseDouble(acsblParams.get(i).get("ymbl").toString()));
            this.updateBuriedACSBLcondition.setFormula("按城市比例");
            this.updateBuriedACSBLcondition.setModelVersion(modelVersion);
            this.updateBuriedACSBLcondition.setCreateTime(createTime);
            this.updateBuriedACSBLcondition.setCreatedBy("江腾飞");
            this.updateBuriedACSBLcondition.setUpdateTime(createTime);
            this.updateBuriedACSBLcondition.setUpdatedBy("江腾飞");
            this.buriedMemberMapper.updateBuriedACSBL(this.updateBuriedACSBLcondition);
        }
    }
}
