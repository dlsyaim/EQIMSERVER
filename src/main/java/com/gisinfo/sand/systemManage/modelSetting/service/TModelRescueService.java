package com.gisinfo.sand.systemManage.modelSetting.service;

import cn.hutool.core.util.IdUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gisinfo.sand.systemManage.modelSetting.bean.TModelRescue;
import com.gisinfo.sand.systemManage.modelSetting.dao.TModelRescueMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

@Service
public class TModelRescueService extends ServiceImpl<TModelRescueMapper, TModelRescue> {

    @Autowired(required = false)
    private TModelRescueMapper tModelRescueMapper;

    //获取救援队伍表中最大版本号
    public String getMaxVersion(){
        Map<String,Object> version = this.tModelRescueMapper.getMaxVersion();
        String maxVersion = version.get("maxVersion").toString();
        return maxVersion;
    }


    //查询救援队伍模型所有参数
    public Map<String, Object> getRescueParams() {
        String maxVersion = this.getMaxVersion();
        Map<String, Object> result = this.tModelRescueMapper.getRescueParams(maxVersion);
        return result;
    }

    //添加修改后的救援队伍模型参数
    @Transactional
    public Integer addRescueData(TModelRescue tModelRescue) {
        String currentVersion=this.getMaxVersion();
        Integer updateVersion=Integer.parseInt(currentVersion)+1;
        Date day = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String createTimes = df.format(System.currentTimeMillis());
        if (tModelRescue.getFeatid() == null || tModelRescue.getFeatid() == "") {
            tModelRescue.setFeatid(IdUtil.simpleUUID());
            tModelRescue.setParamName("默认参数");
            tModelRescue.setFormula("救援队伍-按震级");
            tModelRescue.setModelVersion(updateVersion.toString());
            tModelRescue.setUpdatedBy("admin");
            tModelRescue.setCreatedBy("admin");
            tModelRescue.setUpdateTime(createTimes);
            tModelRescue.setCreateTime(createTimes);

        }
        return this.tModelRescueMapper.addRescue(tModelRescue);
    }

    //添加计算后的救援队伍需求数据
    public void addRescueStaffDemand(Map<String,Object> data){
        this.tModelRescueMapper.addRescueNumber(data);
    }
}
