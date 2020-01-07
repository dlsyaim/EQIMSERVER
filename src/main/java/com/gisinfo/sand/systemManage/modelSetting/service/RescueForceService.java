package com.gisinfo.sand.systemManage.modelSetting.service;

import cn.hutool.core.util.IdUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gisinfo.sand.systemManage.modelSetting.bean.RescueForceModel;
import com.gisinfo.sand.systemManage.modelSetting.dao.RescueForceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

@Service
public class RescueForceService extends ServiceImpl<RescueForceMapper, RescueForceModel> {

    @Autowired(required = false)
    private RescueForceMapper rescueForceMapper;

    private RescueForceModel rescueForce;


    //查找救援力量模型最新版本号
    public String getMaxVersion(){
        Map<String,Object> version = this.rescueForceMapper.getMaxVersion();
        String maxVersion=version.get("maxVersion").toString();
        return maxVersion;
    }

    //查询最新救援力量模型所有参数
    public Map<String,Object> getRescueForceParams(){
        String maxVersion = this.getMaxVersion();
        Map<String,Object> result = this.rescueForceMapper.getRescueForceParams(maxVersion);
        return result;
    }

    //添加模型修改后的参数
    @Transactional
    public Integer addRescueForceData(RescueForceModel rescueForceModel) {
        Integer newVersion=Integer.parseInt(this.getMaxVersion())+1;
        Date day = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String createTimes = df.format(System.currentTimeMillis());
        if (rescueForceModel.getFeatId() == null || rescueForceModel.getFeatId() == "") {
            rescueForceModel.setFeatId(IdUtil.simpleUUID());
            rescueForceModel.setFormula("救援力量—按震级");
            rescueForceModel.setModelVersion(newVersion.toString());
            rescueForceModel.setUpdatedBy("admin");
            rescueForceModel.setCreatedBy("admin");
            rescueForceModel.setUpdateTime(createTimes);
            rescueForceModel.setCreateTime(createTimes);
            rescueForceModel.setDefaultStatus("0");
            rescueForceModel.setParamName("默认参数");

        }
        System.out.println(rescueForceModel.getCreateTime());
        System.out.println(rescueForceModel.getParamName());
        return this.rescueForceMapper.addRescueForce(rescueForceModel);
    }

    //添加计算后的医务人员需求数
    public void addMedicalStaffDemand(Map<String,Object> data){
        this.rescueForceMapper.addMedicalMember(data);
    }


}
