package com.gisinfo.sand.commonData.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gisinfo.sand.commonData.bean.EqNsbCommunication;
import com.gisinfo.sand.commonData.dao.EqNsbCommunicationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class EqNsbCommunicationService extends ServiceImpl<EqNsbCommunicationMapper,EqNsbCommunication>{
    @Autowired(required = false)
    private EqNsbCommunicationMapper nsbCommunicationMapper;


    public List<Map> getListPage(EqNsbCommunication queryConditions) {
        List<Map> list = nsbCommunicationMapper.queryPageList(queryConditions);
        return list;
    }

    public Map<String, Object> getCount(EqNsbCommunication queryConditions) {
        return this.nsbCommunicationMapper.getTotalCount(queryConditions);
    }
}
