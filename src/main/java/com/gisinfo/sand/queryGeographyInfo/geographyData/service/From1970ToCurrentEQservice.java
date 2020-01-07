package com.gisinfo.sand.queryGeographyInfo.geographyData.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gisinfo.sand.queryGeographyInfo.geographyData.bean.From1970ToCurrentEQ;
import com.gisinfo.sand.queryGeographyInfo.geographyData.condition.From1970ToCurrentEQcondition;
import com.gisinfo.sand.queryGeographyInfo.geographyData.dao.From1970ToCurrentEQmapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

//处理查询1970以来小震数据的服务类
@Service
public class From1970ToCurrentEQservice extends ServiceImpl<From1970ToCurrentEQmapper, From1970ToCurrentEQ> {
    @Autowired(required = false)
    private From1970ToCurrentEQmapper from1970ToCurrentEQmapper;

    //查询1970以来小震总计录数
    public Integer getFrom1970ToCurrentEQcount(From1970ToCurrentEQcondition from1970ToCurrentEQcondition){
        Map<String,Object> data =this.from1970ToCurrentEQmapper.getFrom1970ToCurrentEQcount(from1970ToCurrentEQcondition);
        Integer count=Integer.parseInt(data.get("count").toString());
        return count;
    }

    //查询1970以来小震数据列表
    public List<From1970ToCurrentEQ> getFrom1970ToCurrentEQlist(From1970ToCurrentEQcondition from1970ToCurrentEQcondition){
        List<From1970ToCurrentEQ> data=this.from1970ToCurrentEQmapper.getFrom1970ToCurrentEQlist(from1970ToCurrentEQcondition);
        return data;
    }
}
