package com.gisinfo.sand.queryGeographyInfo.geographyData.controller;

import com.gisinfo.sand.core.security.EncryptDisable;
import com.gisinfo.sand.queryGeographyInfo.geographyData.bean.Tunnel;
import com.gisinfo.sand.queryGeographyInfo.geographyData.condition.TunnelCondition;
import com.gisinfo.sand.queryGeographyInfo.geographyData.service.TunnelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//隧道控制类
@RestController
public class TunnelController {
    @Autowired
    private TunnelService tunnelService;

    //查询隧道类别列表、等级列表、总记录条数、数据列表
    @EncryptDisable
    @RequestMapping(value = "getTunnelClassListAndGradeListAndCountAndList",method = RequestMethod.POST)
    public Map<String,Object> getTunnelClassListAndGradeListAndCountAndList(TunnelCondition tunnelCondition){
        if(tunnelCondition.getPageNo()!=null&&tunnelCondition.getPageSize()!=null){
            Integer pageNo=tunnelCondition.getPageNo();
            Integer pageSize=tunnelCondition.getPageSize();
            tunnelCondition.setBottom((pageNo - 1)*pageSize);
            tunnelCondition.setTop(pageNo*pageSize);
        }
        Map<String,Object> result=null;
        //查询隧道类别下拉列表
        List<Map<String,Object>> tunnelClassList=this.tunnelService.getTunnelClassList();
        //查询隧道级别下拉列表
        List<Map<String,Object>> tunnelGradeList=this.tunnelService.getTunnelGradeList();
        //查询隧道记录总条数
        Integer count=this.tunnelService.getTunnelCount(tunnelCondition);
        //查询隧道数据列表
        List<Tunnel> list=this.tunnelService.getTunnelList(tunnelCondition);
        result=new HashMap<>();
        result.put("tunnelClassList",tunnelClassList);
        result.put("tunnelGradeList",tunnelGradeList);
        result.put("count",count);
        result.put("list",list);
        return result;
    }
}
