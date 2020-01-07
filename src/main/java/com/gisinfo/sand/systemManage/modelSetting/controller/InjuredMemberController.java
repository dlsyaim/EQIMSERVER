package com.gisinfo.sand.systemManage.modelSetting.controller;

import com.gisinfo.sand.core.security.EncryptDisable;
import com.gisinfo.sand.systemManage.modelSetting.bean.InjuredALD;
import com.gisinfo.sand.systemManage.modelSetting.bean.InjuredAZJ;
import com.gisinfo.sand.systemManage.modelSetting.service.InjuredMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class InjuredMemberController {
    @Autowired
    private InjuredMemberService injuredMemberService;
    //------------受伤人员模型----------
    //获取受伤人员按震级
    @EncryptDisable
    @RequestMapping(value = "/getInjuredAZJdata", method = RequestMethod.POST,produces="application/json")
    public List<InjuredAZJ> getInjuredAZJdata(){
        Integer modelVersion=this.injuredMemberService.getInjuredNewestVersion();
        return this.injuredMemberService.getInjuredAZJdata(modelVersion);
    }

    //获取受伤人员按烈度
    @EncryptDisable
    @RequestMapping(value = "/getInjuredALDdata", method = RequestMethod.POST,produces="application/json")
    public List<InjuredALD> getInjuredALDdata(){
        Integer modelVersion=this.injuredMemberService.getInjuredNewestVersion();
        return this.injuredMemberService.getInjuredALDdata(modelVersion);
    }

    //更新受伤人员data
    @EncryptDisable
    @RequestMapping(value = "/updateInjuredDdata", method = RequestMethod.POST,produces="application/json")
    public void updateInjuredDdata(@RequestBody List<Map<String,Object>> ajzParams){
        Integer modelVersion=this.injuredMemberService.getInjuredNewestVersion();
        this.injuredMemberService.updateInjuredDdata(ajzParams,modelVersion);
    }

}
