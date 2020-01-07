package com.gisinfo.sand.commonData.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gisinfo.sand.commonData.bean.EqStorage;
import com.gisinfo.sand.commonData.dao.EqStorageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class EqStorageService extends ServiceImpl<EqStorageMapper,EqStorage>{
    @Autowired(required = false)
    private EqStorageMapper storageMapper;


    public List<EqStorage> getListPage(EqStorage queryConditions) {
        List<EqStorage> list = storageMapper.queryPageList(queryConditions);
        return list;
    }

    public Map<String, Object> getCount(EqStorage queryConditions) {
        return this.storageMapper.getTotalCount(queryConditions);
    }
}
