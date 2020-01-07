package com.gisinfo.sand.systemManage.modelSetting.service;

import cn.hutool.core.util.IdUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gisinfo.sand.systemManage.modelSetting.bean.TModelEarthquake;
import com.gisinfo.sand.systemManage.modelSetting.dao.TModelEarthquakeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Map;

@Service
public class TModelEarthquakeService extends ServiceImpl<TModelEarthquakeMapper,TModelEarthquake>{

    @Autowired(required = false)
    private TModelEarthquakeMapper tModelEarthquakeMapper;

    @Transactional
    public Integer addEarthquakeData(TModelEarthquake modelEarthquake){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String createTimes = df.format(System.currentTimeMillis());
        String currentVersion=this.getMaxVersion();
        Integer updateVersion=Integer.parseInt(currentVersion)+1;
        //if (modelEarthquake.getFeatid() == null || modelEarthquake.getFeatid() == "") {
            modelEarthquake.setFeatid(IdUtil.simpleUUID());
            modelEarthquake.setParamName("默认参数");
            modelEarthquake.setUpdatedBy("admin");
            modelEarthquake.setCreatedBy("admin");
            modelEarthquake.setModelVersion(updateVersion.toString());
            modelEarthquake.setUpdateTime(createTimes);
            modelEarthquake.setCreateTime(createTimes);
        //}
        return this.tModelEarthquakeMapper.addEarthquake(modelEarthquake);
    }

    //获取救援队伍表中最大版本号
    public String getMaxVersion(){
        Map<String,Object> version = this.tModelEarthquakeMapper.getMaxVersion();
        String maxVersion = version.get("maxVersion").toString();
        return maxVersion;
    }


    //查询救援队伍模型所有参数
    public Map<String, Object> getEarthquakeParams() {
        String maxVersion = this.getMaxVersion();
        Map<String, Object> result = this.tModelEarthquakeMapper.getEarthquakeParams(maxVersion);
        return result;
    }
}
