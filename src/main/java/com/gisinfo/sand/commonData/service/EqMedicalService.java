package com.gisinfo.sand.commonData.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gisinfo.sand.commonData.bean.EqMedical;
import com.gisinfo.sand.commonData.dao.EqMedicalMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class EqMedicalService extends ServiceImpl<EqMedicalMapper,EqMedical>{
    @Autowired(required = false)
    private EqMedicalMapper medicalMapper;


    public List<Map> getListPage(EqMedical queryConditions) {
        List<Map> list = medicalMapper.queryPageList(queryConditions);
        return list;
    }

    public Map<String, Object> getCount(EqMedical queryConditions) {
        return this.medicalMapper.getTotalCount(queryConditions);
    }
}
