package com.gisinfo.sand.queryGeographyInfo.geographyData.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gisinfo.sand.queryGeographyInfo.geographyData.bean.Shelter;
import com.gisinfo.sand.queryGeographyInfo.geographyData.condition.ShelterCondition;
import com.gisinfo.sand.queryGeographyInfo.geographyData.dao.ShelterMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

//避难所服务类
@Service
public class ShelterService extends ServiceImpl<ShelterMapper, Shelter> {
        @Autowired(required = false)
        private ShelterMapper shelterMapper;

        //查询类别列表
        public List<Map<String,Object>> getShelterClassList(){
        List<Map<String,Object>> data=this.shelterMapper.getShelterClassList();
        return data;
    }

        //查询总记录数
        public Integer getShelterCount(ShelterCondition shelterCondition){
        Map<String,Object> data=this.shelterMapper.getShelterCount(shelterCondition);
        Integer count=Integer.parseInt(data.get("count").toString());
        return count;
    }

        //查询数据列表
        public List<Shelter> getShelterList(ShelterCondition shelterCondition){
        List<Shelter> list=this.shelterMapper.getShelterList(shelterCondition);
        return list;
    }
}
