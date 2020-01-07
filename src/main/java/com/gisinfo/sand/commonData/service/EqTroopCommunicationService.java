package com.gisinfo.sand.commonData.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gisinfo.sand.commonData.bean.EqTroopCommunication;
import com.gisinfo.sand.commonData.dao.EqTroopCommunicationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class EqTroopCommunicationService extends ServiceImpl<EqTroopCommunicationMapper,EqTroopCommunication>{
    @Autowired(required = false)
    private EqTroopCommunicationMapper troopCommunicationMapper;


    public List<Map> getListPage(EqTroopCommunication queryConditions) {
        List<Map> list = troopCommunicationMapper.queryPageList(queryConditions);
        return list;
    }

    public Map<String, Object> getCount(EqTroopCommunication queryConditions) {
        return this.troopCommunicationMapper.getTotalCount(queryConditions);
    }
}
