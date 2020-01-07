package com.gisinfo.sand.queryGeographyInfo.geographyData.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gisinfo.sand.queryGeographyInfo.geographyData.bean.School;
import com.gisinfo.sand.queryGeographyInfo.geographyData.condition.SchoolCondition;
import com.gisinfo.sand.queryGeographyInfo.geographyData.dao.SchoolMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

//学校所服务类
@Service
public class SchoolService extends ServiceImpl<SchoolMapper, School> {
        @Autowired(required = false)
        private SchoolMapper schoolMapper;

        //查询类别列表
        public List<Map<String,Object>> getSchoolClassList(){
        List<Map<String,Object>> data=this.schoolMapper.getSchoolClassList();
        return data;
    }

        //查询总记录数
        public Integer getSchoolCount(SchoolCondition schoolCondition){
        Map<String,Object> data=this.schoolMapper.getSchoolCount(schoolCondition);
        Integer count=Integer.parseInt(data.get("count").toString());
        return count;
    }

        //查询数据列表
        public List<School> getSchoolList(SchoolCondition schoolCondition){
        List<School> list=this.schoolMapper.getSchoolList(schoolCondition);
        return list;
    }
}
