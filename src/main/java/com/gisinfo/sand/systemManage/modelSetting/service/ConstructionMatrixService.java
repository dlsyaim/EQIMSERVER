package com.gisinfo.sand.systemManage.modelSetting.service;
import cn.hutool.core.util.IdUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gisinfo.sand.systemManage.modelSetting.bean.*;
import com.gisinfo.sand.systemManage.modelSetting.condition.UpdateJZJJSSBcondition;
import com.gisinfo.sand.systemManage.modelSetting.condition.UpdateJZPHBcondition;
import com.gisinfo.sand.systemManage.modelSetting.condition.UpdateYScondition;
import com.gisinfo.sand.systemManage.modelSetting.dao.ConstructionMatrixMapper;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

@Service
public class ConstructionMatrixService extends ServiceImpl<ConstructionMatrixMapper,ConstructionYS>{
    @Autowired(required = false)
    private ConstructionMatrixMapper constructionMatrixMapper;
    @Autowired(required = false)
    private SimpleDateFormat sdf;
    @Autowired(required = false)
    private UpdateYScondition updateYScondition;
    @Autowired(required = false)
    private UpdateJZPHBcondition updateJZPHBcondition;


    //----------建筑矩阵模型----------

    //获取建筑类型下拉框
    public List<Map<String,Object>> getBuildingTypeList(){
        return this.constructionMatrixMapper.getBuildingTypeList();
    }

    //根据建筑类型获取建筑易损性矩阵相关数据
    public List<ConstructionYS> getYSDataByBuildingType(String buildingType,String modelVersion){

        return this.constructionMatrixMapper.getConstructionYSByBuildingType(buildingType,modelVersion);
    }

    //获取建筑破坏比数据
    public List<ConstructionPHB> getPHBData(String modelVersion){
        return this.constructionMatrixMapper.getConstructionPHB(modelVersion);
    }

    //获取建筑经济损失比数据
    public ConstructionJJSSB getJJSSBData(String modelVersion){
        return this.constructionMatrixMapper.getConstructionJJSSB(modelVersion);
    }

    //获取当前最新版本数
    public  Integer getCurrentVersion(){
        Map<String,Object>versions=this.constructionMatrixMapper.getCurrentModelVersion();
        Integer modelVersion=Integer.parseInt(versions.get("modelVersion").toString())+1;
        return  modelVersion;
    }

    //更新建筑易损性矩阵数据
    @Transactional
    public void updateJZYS(List<Map<String,Object>> params,Integer modelVersion) {
        //将页面拿到的参数封装成实体类
        if(sdf==null){
            sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        }
        String updateTime=sdf.format(System.currentTimeMillis());
        if(this.updateYScondition==null){
            this.updateYScondition=new UpdateYScondition();
        }
        for (int i = 0; i < params.size(); i++) {
                this.updateYScondition.setFeatId(IdUtil.simpleUUID());
                this.updateYScondition.setModelName("尹之潜");
                this.updateYScondition.setBuildingType(params.get(i).get("buildingType").toString());
                this.updateYScondition.setI(Integer.parseInt(params.get(i).get("ld").toString()));
                this.updateYScondition.setJ(Double.parseDouble(params.get(i).get("jbwh").toString()));
                this.updateYScondition.setQ(Double.parseDouble(params.get(i).get("qdph").toString()));
                this.updateYScondition.setZ(Double.parseDouble(params.get(i).get("zdph").toString()));
                this.updateYScondition.setY(Double.parseDouble(params.get(i).get("yzph").toString()));
                this.updateYScondition.setD(Double.parseDouble(params.get(i).get("hh").toString()));
                this.updateYScondition.setModelType("易损性矩阵");
                this.updateYScondition.setModelVersion(modelVersion.toString());
                this.updateYScondition.setCreateTime(updateTime);
                this.updateYScondition.setCreatedBy("江腾飞");
                this.updateYScondition.setUpdateTime(updateTime);
                this.updateYScondition.setUpdatedBy("江腾飞");
                this.constructionMatrixMapper.updateJZYSdata(this.updateYScondition);
        }
    }

    //修改建筑破坏比数据
    @Transactional
    public void updateJZPHB(List<Map<String,Object>> jzphbParams,Integer modelVersion){
        //将页面拿到的参数封装成实体类属性
        if(sdf==null){
            sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        }
        String updateTime=sdf.format(System.currentTimeMillis());
        if(this.updateJZPHBcondition==null){
            this.updateJZPHBcondition=new UpdateJZPHBcondition();
        }
        for(int i=0;i<jzphbParams.size();i++){
            this.updateJZPHBcondition.setFeatId(IdUtil.simpleUUID());
            this.updateJZPHBcondition.setModelName("尹之潜");
            this.updateJZPHBcondition.setBuildingType(jzphbParams.get(i).get("jzlx").toString());
            this.updateJZPHBcondition.setJ(Double.parseDouble(jzphbParams.get(i).get("jbwh").toString()));
            this.updateJZPHBcondition.setQ(Double.parseDouble(jzphbParams.get(i).get("qdph").toString()));
            this.updateJZPHBcondition.setZ(Double.parseDouble(jzphbParams.get(i).get("zdph").toString()));
            this.updateJZPHBcondition.setY(Double.parseDouble(jzphbParams.get(i).get("yzph").toString()));
            this.updateJZPHBcondition.setD(Double.parseDouble(jzphbParams.get(i).get("hh").toString()));
            this.updateJZPHBcondition.setModelType("建筑破坏比");
            this.updateJZPHBcondition.setModelVersion(modelVersion.toString());
            this.updateJZPHBcondition.setCreateTime(updateTime);
            this.updateJZPHBcondition.setCreatedBy("江腾飞");
            this.updateJZPHBcondition.setUpdateTime(updateTime);
            this.updateJZPHBcondition.setUpdatedBy("江腾飞");
            this.constructionMatrixMapper.updateJZPHBdata(this.updateJZPHBcondition);
        }
    }

    //修改建筑经济损失比数据
    @Transactional
    public void updateJZJJSSB(UpdateJZJJSSBcondition updateJZJJSSBcondition,Integer modelVersion){
        //将页面拿到的参数封装成实体类属性
        if(sdf==null){
            sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        }
        String updateTime=sdf.format(System.currentTimeMillis());
        updateJZJJSSBcondition.setFeatId(IdUtil.simpleUUID());
        updateJZJJSSBcondition.setModelName("尹之潜");
        updateJZJJSSBcondition.setModelType("建筑经济损失比");
        updateJZJJSSBcondition.setCreateTime(updateTime);
        updateJZJJSSBcondition.setCreatedBy("江腾飞");
        updateJZJJSSBcondition.setUpdateTime(updateTime);
        updateJZJJSSBcondition.setUpdatedBy("江腾飞");
        updateJZJJSSBcondition.setModelVersion(modelVersion.toString());
        this.constructionMatrixMapper.updateJZJJSSBdata(updateJZJJSSBcondition);

    }



}
