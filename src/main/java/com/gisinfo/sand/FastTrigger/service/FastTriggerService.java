package com.gisinfo.sand.FastTrigger.service;

import cn.hutool.core.util.IdUtil;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gisinfo.sand.FastTrigger.bean.FastTriggerBean;
import com.gisinfo.sand.FastTrigger.dao.FastTriggerMapper;
import com.gisinfo.sand.util.GetNewestData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//快速触发服务类
@Service
public class FastTriggerService extends ServiceImpl<FastTriggerMapper, FastTriggerBean> {
    @Autowired(required = false)
    private FastTriggerMapper fastTriggerMapper;
    //添加地震信息数据
    public void addEQinfoData(){
        JSONObject result= GetNewestData.filterData();
        if(result != null){
            FastTriggerBean ftb=new FastTriggerBean();
            ftb.setFeatId(IdUtil.simpleUUID());
            ftb.setDataSource("地震速报");
            ftb.setEarthquakeLevel(result.get("M").toString());
            ftb.setEarthquakeTime(result.get("O_TIME").toString());
            ftb.setLatitude(Double.parseDouble(result.get("EPI_LAT").toString()));
            ftb.setLongitude(Double.parseDouble(result.get("EPI_LON").toString()));
            ftb.setEarthquakeLocation(result.get("LOCATION_C").toString());
            this.fastTriggerMapper.addEQinfoData(ftb);
        }

    }
}
