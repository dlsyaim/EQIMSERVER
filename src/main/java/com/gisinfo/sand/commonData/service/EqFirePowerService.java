package com.gisinfo.sand.commonData.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gisinfo.sand.commonData.bean.EqFirePower;
import com.gisinfo.sand.commonData.dao.EqFirePowerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class EqFirePowerService extends ServiceImpl<EqFirePowerMapper,EqFirePower>{
    @Autowired(required = false)
    private EqFirePowerMapper firePowerMapper;


    public List<Map> getListPage(EqFirePower queryConditions) {
        List<Map> list = firePowerMapper.queryPageList(queryConditions);
        return list;
    }

    public Map<String, Object> getCount(EqFirePower queryConditions) {
        return this.firePowerMapper.getTotalCount(queryConditions);
    }
}
