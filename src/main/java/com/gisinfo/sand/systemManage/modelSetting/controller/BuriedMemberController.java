package com.gisinfo.sand.systemManage.modelSetting.controller;

import com.gisinfo.sand.core.security.EncryptDisable;
import com.gisinfo.sand.systemManage.modelSetting.bean.BuriedACSBL;
import com.gisinfo.sand.systemManage.modelSetting.bean.BuriedAJZBL;
import com.gisinfo.sand.systemManage.modelSetting.service.BuriedMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class BuriedMemberController {
    @Autowired
    private BuriedMemberService buriedMemberService;

    //获取建筑比例数据
    @EncryptDisable
    @RequestMapping(value = "/getBuridAZJBLdata", method = RequestMethod.POST,produces="application/json")
    public List<BuriedAJZBL> getBuridAZJBLdata(){
        String modelVersion=this.buriedMemberService.getNewestVersion();
        List<BuriedAJZBL> result=this.buriedMemberService.getBuriedAJZBLdata(modelVersion);
        return result;
    }

    //获取建筑比例数据
    @EncryptDisable
    @RequestMapping(value = "/getBuridACSBLdata", method = RequestMethod.POST,produces="application/json")
    public List<BuriedACSBL> getBuridACSBLdata(){
        String modelVersion=this.buriedMemberService.getNewestVersion();
        List<BuriedACSBL> result=this.buriedMemberService.getBuriedACSBLdata(modelVersion);
        return result;
    }

    //更新压埋人员按建筑比例模型数据
    @EncryptDisable
    @RequestMapping(value = "/updateBuriedAJZBLdata", method = RequestMethod.POST,produces="application/json")
    public void updateBuriedAJZBLdata(@RequestBody  List<Map<String,Object>> ajzblParams){
        String version=this.buriedMemberService.getNewestVersion();
        Integer modelVersion=Integer.parseInt(version)+1;
        this.buriedMemberService.updateBuriedAJZBLdata(ajzblParams,modelVersion.toString());
    }

    //更新压埋人员按建筑比例模型数据
    @EncryptDisable
    @RequestMapping(value = "/updateBuriedACSBLdata", method = RequestMethod.POST,produces="application/json")
    public void updateBuriedACSBLdata(@RequestBody  List<Map<String,Object>> acsblParams){
        String version=this.buriedMemberService.getNewestVersion();
        Integer modelVersion=Integer.parseInt(version)+1;
        this.buriedMemberService.updateBuriedACSBLdata(acsblParams,modelVersion.toString());
    }
}
