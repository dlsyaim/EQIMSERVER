package com.gisinfo.sand.systemManage.modelSetting.service;

import cn.hutool.core.util.IdUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gisinfo.sand.systemManage.modelSetting.bean.HomelessMember;
import com.gisinfo.sand.systemManage.modelSetting.condition.UpdateHomelessMemberCondition;
import com.gisinfo.sand.systemManage.modelSetting.dao.HomelessMemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;
@Service
public class HomelessMemberService extends ServiceImpl<HomelessMemberMapper,HomelessMember>{
    @Autowired(required = false)
    private HomelessMemberMapper homelessMemberMapper;
    @Autowired(required = false)
    private SimpleDateFormat sdf;
    @Autowired(required = false)
    private UpdateHomelessMemberCondition updateHomelessMemberCondition;


    //获取最新模型版本号
    public String getNewestVersion(){
        Map<String,Object> modelVersion=this.homelessMemberMapper.getNewestModelVersion();
        return modelVersion.get("modelVersion").toString();
    }

    //获取无家可归模型数据
    public List<HomelessMember> getHomelessMemberData(String modelVersion){
        List<HomelessMember> data=this.homelessMemberMapper.getHomelessMember(modelVersion);
        return data;
    }

    //更新无家可归模型数据
    public void updateHomelessMemberData(List<Map<String,Object>> homelessParams,String modelVersion){
        if(this.sdf==null){
            this.sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        }
        String createTime=this.sdf.format(System.currentTimeMillis());
        if(this.updateHomelessMemberCondition==null){
            this.updateHomelessMemberCondition=new UpdateHomelessMemberCondition();
        }
        for(int i=0;i<homelessParams.size();i++){
            this.updateHomelessMemberCondition.setFeatId(IdUtil.simpleUUID());
            this.updateHomelessMemberCondition.setParamName("默认参数");
            this.updateHomelessMemberCondition.setI(homelessParams.get(i).get("dzld").toString());
            this.updateHomelessMemberCondition.setProportionLow(Double.parseDouble(homelessParams.get(i).get("dbl").toString()));
            this.updateHomelessMemberCondition.setProportionMedium(Double.parseDouble(homelessParams.get(i).get("zbl").toString()));
            this.updateHomelessMemberCondition.setProportionHigh(Double.parseDouble(homelessParams.get(i).get("gbl").toString()));
            this.updateHomelessMemberCondition.setFormula("需紧急安置");
            this.updateHomelessMemberCondition.setModelVersion(modelVersion);
            this.updateHomelessMemberCondition.setCreateTime(createTime);
            this.updateHomelessMemberCondition.setCreatedBy("江腾飞");
            this.updateHomelessMemberCondition.setUpdateTime(createTime);
            this.updateHomelessMemberCondition.setUpdatedBy("江腾飞");
            this.homelessMemberMapper.updateHomelessMember(this.updateHomelessMemberCondition);
        }
    }
}
