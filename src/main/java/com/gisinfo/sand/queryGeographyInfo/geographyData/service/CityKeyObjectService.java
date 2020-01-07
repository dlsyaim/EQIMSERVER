package com.gisinfo.sand.queryGeographyInfo.geographyData.service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gisinfo.sand.queryGeographyInfo.geographyData.bean.CityKeyObject;
import com.gisinfo.sand.queryGeographyInfo.geographyData.condition.CityKeyObjectCondition;
import com.gisinfo.sand.queryGeographyInfo.geographyData.dao.CityKeyObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


//城市主要目标服务类
@Service
public class CityKeyObjectService extends ServiceImpl<CityKeyObjectMapper, CityKeyObject> {
    @Autowired(required = false)
    private CityKeyObjectMapper CityKeyObjectMapper;

    //查询类别列表
    public List<Map<String,Object>> getCityKeyObjectClassList(){
        List<Map<String,Object>> data=this.CityKeyObjectMapper.getCityKeyObjectClassList();
        return data;
    }

    //查询总记录数
    public Integer getCityKeyObjectCount(CityKeyObjectCondition CityKeyObjectCondition){
        Map<String,Object> data=this.CityKeyObjectMapper.getCityKeyObjectCount(CityKeyObjectCondition);
        Integer count=Integer.parseInt(data.get("count").toString());
        return count;
    }

    //查询数据列表
    public List<CityKeyObject> getCityKeyObjectList(CityKeyObjectCondition CityKeyObjectCondition){
        List<CityKeyObject> list=this.CityKeyObjectMapper.getCityKeyObjectList(CityKeyObjectCondition);
        return list;
    }


}
