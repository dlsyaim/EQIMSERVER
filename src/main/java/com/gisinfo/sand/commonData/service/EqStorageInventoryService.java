package com.gisinfo.sand.commonData.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gisinfo.sand.commonData.bean.EqStorageInventory;
import com.gisinfo.sand.commonData.dao.EqStorageInventoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class EqStorageInventoryService extends ServiceImpl<EqStorageInventoryMapper,EqStorageInventory>{
    @Autowired(required = false)
    private EqStorageInventoryMapper storageInventoryMapper;


    public List<Map> getListPage(EqStorageInventory queryConditions) {
        List<Map> list = storageInventoryMapper.queryPageList(queryConditions);
        return list;
    }

    public Map<String, Object> getCount(EqStorageInventory queryConditions) {
        return this.storageInventoryMapper.getTotalCount(queryConditions);
    }
}
