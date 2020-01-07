package com.gisinfo.sand.commonData.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gisinfo.sand.commonData.bean.EqEmergcyPlan;
import com.gisinfo.sand.commonData.dao.EqEmergcyPlanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class EqEmergcyPlanService extends ServiceImpl<EqEmergcyPlanMapper,EqEmergcyPlan>{
    @Autowired(required = false)
    private EqEmergcyPlanMapper emergcyPlanMapper;


    public List<EqEmergcyPlan> getListPage(EqEmergcyPlan queryConditions) {

        return this.emergcyPlanMapper.queryPageList(queryConditions);
    }

    public Map<String, Object> getCount(EqEmergcyPlan queryConditions) {
        return this.emergcyPlanMapper.getTotalCount(queryConditions);
    }

}
