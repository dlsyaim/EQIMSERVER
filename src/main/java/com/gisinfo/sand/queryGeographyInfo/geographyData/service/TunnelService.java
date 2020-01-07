package com.gisinfo.sand.queryGeographyInfo.geographyData.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gisinfo.sand.queryGeographyInfo.geographyData.bean.Tunnel;
import com.gisinfo.sand.queryGeographyInfo.geographyData.condition.TunnelCondition;
import com.gisinfo.sand.queryGeographyInfo.geographyData.dao.TunnelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

//隧道服务类
@Service
public class TunnelService extends ServiceImpl<TunnelMapper, Tunnel> {
    @Autowired(required = false)
    private TunnelMapper tunnelMapper;

    //查询隧道类别下拉列表
    public List<Map<String,Object>> getTunnelClassList(){
        List<Map<String,Object>> data=this.tunnelMapper.getTunnelClassList();
        return data;
    }


    //查询隧道等级下拉列表
    public List<Map<String,Object>> getTunnelGradeList(){
        List<Map<String,Object>> data=this.tunnelMapper.getTunnelGradeList();
        return data;
    }

    //查询隧道总记录条数
    public Integer getTunnelCount(TunnelCondition tunnelCondition){
        Map<String,Object> data=this.tunnelMapper.getTunnelCount(tunnelCondition);
        Integer count=Integer.parseInt(data.get("count").toString());
        return count;
    }

    //查询隧道数据列表
    public List<Tunnel> getTunnelList(TunnelCondition tunnelCondition){
        List<Tunnel> data=this.tunnelMapper.getTunnelList(tunnelCondition);
        return data;
    }

}
