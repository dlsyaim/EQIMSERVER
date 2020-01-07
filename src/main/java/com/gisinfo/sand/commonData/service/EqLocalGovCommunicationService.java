package com.gisinfo.sand.commonData.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gisinfo.sand.commonData.bean.EqLocalGovCommunication;
import com.gisinfo.sand.commonData.dao.EqLocalGovCommunicationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class EqLocalGovCommunicationService extends ServiceImpl<EqLocalGovCommunicationMapper,EqLocalGovCommunication>{
    @Autowired(required = false)
    private EqLocalGovCommunicationMapper govCommunicationMapper;


    public List<Map> getListPage(EqLocalGovCommunication queryConditions) {
        List<Map> list = govCommunicationMapper.queryPageList(queryConditions);
        return list;
    }

    public Map<String, Object> getCount(EqLocalGovCommunication queryConditions) {
        return this.govCommunicationMapper.getTotalCount(queryConditions);
    }
}
