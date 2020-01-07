package com.gisinfo.sand.commonData.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gisinfo.sand.commonData.bean.EqEconomy;
import com.gisinfo.sand.commonData.dao.EqEconomyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class EqEconomyService extends ServiceImpl<EqEconomyMapper,EqEconomy>{
    @Autowired(required = false)
    private EqEconomyMapper economyMapper;


    public List<Map> getListPage(EqEconomy queryConditions) {
        List<Map> list = economyMapper.queryPageList(queryConditions);
        return list;
    }

    public Map<String, Object> getCount(EqEconomy queryConditions) {
        return this.economyMapper.getTotalCount(queryConditions);
    }
}
