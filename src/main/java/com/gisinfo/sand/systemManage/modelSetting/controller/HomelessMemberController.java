package com.gisinfo.sand.systemManage.modelSetting.controller;

import com.gisinfo.sand.core.security.EncryptDisable;
import com.gisinfo.sand.systemManage.modelSetting.bean.HomelessMember;
import com.gisinfo.sand.systemManage.modelSetting.service.HomelessMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class HomelessMemberController {
    @Autowired
    private HomelessMemberService homelessMemberService;

    //查询无家可归模型人员数据
    @EncryptDisable
    @RequestMapping(value = "/getHomelessMemberData", method = RequestMethod.POST,produces="application/json")
    public List<HomelessMember> getHomelessMemberData(){
        String modelVersion=this.homelessMemberService.getNewestVersion();
        List<HomelessMember> result=this.homelessMemberService.getHomelessMemberData(modelVersion);
        return result;
    }

    //更新无家可归人员模型数据
    @EncryptDisable
    @RequestMapping(value = "/updateHomelessMemberData", method = RequestMethod.POST,produces="application/json")
    public void updateHomelessMemberData(@RequestBody List<Map<String,Object>> homelessParams){
        String version=this.homelessMemberService.getNewestVersion();
        Integer modelVersion=Integer.parseInt(version)+1;
        this.homelessMemberService.updateHomelessMemberData(homelessParams,modelVersion.toString());
    }
}
