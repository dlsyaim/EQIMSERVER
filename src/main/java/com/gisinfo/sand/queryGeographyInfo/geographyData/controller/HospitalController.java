package com.gisinfo.sand.queryGeographyInfo.geographyData.controller;

import com.gisinfo.sand.core.security.EncryptDisable;
import com.gisinfo.sand.queryGeographyInfo.geographyData.bean.Hospital;
import com.gisinfo.sand.queryGeographyInfo.geographyData.condition.HospitalCondition;
import com.gisinfo.sand.queryGeographyInfo.geographyData.service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//医院控制类
@RestController
public class HospitalController {

    @Autowired
    private HospitalService hospitalService;

    //查询桥梁等级下拉列表、列表下拉列表、总记录条数、数据列表
    @EncryptDisable
    @RequestMapping(value = "/getHospitalTypeListAndGradeListAndCountAndList",method = RequestMethod.POST)
    public Map<String,Object> getHospitalTypeListAndGradeListAndCountAndList(HospitalCondition hospitalCondition){
        if(hospitalCondition.getPageNo()!=null&&hospitalCondition.getPageSize()!=null){
            Integer pageNo=hospitalCondition.getPageNo();
            Integer pageSize=hospitalCondition.getPageSize();
            hospitalCondition.setBottom((pageNo - 1)*pageSize);
            hospitalCondition.setTop(pageNo*pageSize);
        }
        Map<String,Object> result=null;
        //查询类别下拉列表
        List<Map<String,Object>> HospitalTypeList=this.hospitalService.getHospitalTypeList();
        //查询等级下拉列表
        List<Map<String,Object>> HospitalGradeList=this.hospitalService.getHospitalGradeList();
        //查询总记录数
        Integer count=this.hospitalService.getHospitalCount(hospitalCondition);
        //查询数据列表
        List<Hospital> list=this.hospitalService.getHospitalList(hospitalCondition);
        result=new HashMap<>();
        result.put("HospitalTypeList",HospitalTypeList);
        result.put("HospitalGradeList",HospitalGradeList);
        result.put("count",count);
        result.put("list",list);
        return result;
    }
    
}
