package com.gisinfo.sand.queryGeographyInfo.geographyData.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gisinfo.sand.queryGeographyInfo.geographyData.bean.Hospital;
import com.gisinfo.sand.queryGeographyInfo.geographyData.condition.HospitalCondition;
import com.gisinfo.sand.queryGeographyInfo.geographyData.dao.HospitalMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

//医院服务类
@Service
public class HospitalService extends ServiceImpl<HospitalMapper, Hospital> {
    @Autowired(required = false)
    private HospitalMapper hospitalMapper;

    //查询类别列表
    public List<Map<String,Object>> getHospitalTypeList(){
        List<Map<String,Object>> data=this.hospitalMapper.getHospitalTypeList();
        return data;
    }

    //查询等级列表
    public List<Map<String,Object>> getHospitalGradeList(){
        List<Map<String,Object>> data=this.hospitalMapper.getHospitalGradeList();
        return data;
    }

    //查询总记录数
    public Integer getHospitalCount(HospitalCondition hospitalCondition){
        Map<String,Object> data=this.hospitalMapper.getHospitalCount(hospitalCondition);
        Integer count=Integer.parseInt(data.get("count").toString());
        return count;
    }

    //查询数据列表
    public List<Hospital> getHospitalList(HospitalCondition hospitalCondition){
        List<Hospital> list=this.hospitalMapper.getHospitalList(hospitalCondition);
        return list;
    }
}
