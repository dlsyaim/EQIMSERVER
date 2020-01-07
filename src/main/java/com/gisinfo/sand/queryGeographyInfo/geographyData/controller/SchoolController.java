package com.gisinfo.sand.queryGeographyInfo.geographyData.controller;

import com.gisinfo.sand.core.security.EncryptDisable;
import com.gisinfo.sand.queryGeographyInfo.geographyData.bean.School;
import com.gisinfo.sand.queryGeographyInfo.geographyData.condition.SchoolCondition;
import com.gisinfo.sand.queryGeographyInfo.geographyData.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//学校控制类
@RestController
public class SchoolController {

    @Autowired
    private SchoolService schoolService;

    //查询桥梁等级下拉列表、列表下拉列表、总记录条数、数据列表
    @EncryptDisable
    @RequestMapping(value = "/getSchoolClassListAndAndCountAndList",method = RequestMethod.POST)
    public Map<String,Object> getSchoolClassListAndAndCountAndList(SchoolCondition schoolCondition){
        if(schoolCondition.getPageNo()!=null&&schoolCondition.getPageSize()!=null){
            Integer pageNo=schoolCondition.getPageNo();
            Integer pageSize=schoolCondition.getPageSize();
            schoolCondition.setBottom((pageNo - 1)*pageSize);
            schoolCondition.setTop(pageNo*pageSize);
        }
        Map<String,Object> result=null;
        //查询桥梁类别下拉列表
        List<Map<String,Object>> SchoolClassList=this.schoolService.getSchoolClassList();
        //查询总记录数
        Integer count=this.schoolService.getSchoolCount(schoolCondition);
        //查询数据列表
        List<School> list=this.schoolService.getSchoolList(schoolCondition);
        result=new HashMap<>();
        result.put("SchoolClassList",SchoolClassList);
        result.put("count",count);
        result.put("list",list);
        return result;
    }

}
