package com.gisinfo.sand.systemManage.modelSetting.service;

import cn.hutool.core.util.IdUtil;
import com.gisinfo.sand.systemManage.modelSetting.bean.InjuredALD;
import com.gisinfo.sand.systemManage.modelSetting.bean.InjuredAZJ;
import com.gisinfo.sand.systemManage.modelSetting.dao.InjuredMemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

@Service
public class InjuredMemberService {
    @Autowired(required = false)
    private InjuredMemberMapper injuredMemberMapper;
    @Autowired(required = false)
    private SimpleDateFormat sdf;
    @Autowired(required = false)
    private InjuredAZJ injuredAZJ;
    @Autowired(required = false)
    private InjuredALD injuredALD;

    //------------受伤人员模型----------------
    //获取受伤人数最新版本数
    public Integer getInjuredNewestVersion(){
        Map<String,Object> version=this.injuredMemberMapper.getInjuredNewestVersion();
        Integer modelVersion=Integer.parseInt(version.get("modelVersion").toString());
        return modelVersion;
    }
    //查询受伤人员按震级数据
    public List<InjuredAZJ> getInjuredAZJdata(Integer modelVersion){
        List<InjuredAZJ> data=this.injuredMemberMapper.getInjuredAZJ(modelVersion);
        return data;
    }

    //查询受伤人员模型按烈度
    public List<InjuredALD> getInjuredALDdata(Integer modelVersion){
        List<InjuredALD> data=this.injuredMemberMapper.getInjuredALD(modelVersion);
        return data;
    }

    //更新受伤人员模型按震级数据
    @Transactional
    public void updateInjuredDdata(List<Map<String,Object>> params,Integer modelVersion){
        //将页面拿到的参数封装成实体类属性
        if(sdf==null){
            sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        }
        if(this.injuredAZJ==null){
            injuredAZJ=new InjuredAZJ();
        }
        if(this.injuredALD==null){
            injuredALD=new InjuredALD();
        }
        String updateTime=sdf.format(System.currentTimeMillis());
        for(int i=0;i<params.size();i++){
            if("受伤人员按震级".equals(params.get(i).get("modelType").toString())){
                injuredAZJ.setFeatId(IdUtil.simpleUUID());
                injuredAZJ.setParamName("尹之潜参数");
                injuredAZJ.setL0(Double.parseDouble(params.get(i).get("l0").toString()));
                injuredAZJ.setScale(params.get(i).get("dzzj").toString());
                injuredAZJ.setPercentInjured(Double.parseDouble(params.get(i).get("ssry").toString()));
                injuredAZJ.setFormula("按震级");
                injuredAZJ.setModelVersion(modelVersion+1);
                injuredAZJ.setCreateTime(updateTime);
                injuredAZJ.setCreatedBy("江腾飞");
                injuredAZJ.setUpdateTime(updateTime);
                injuredAZJ.setUpdatedBy("江腾飞");
                this.injuredMemberMapper.updateInjuredAZJ(this.injuredAZJ);
            }else{
                injuredALD.setFeatId(IdUtil.simpleUUID());
                injuredALD.setParamName("尹之潜参数");
                injuredALD.setL0(Double.parseDouble(params.get(i).get("l0").toString()));
                injuredALD.setScale(params.get(i).get("dzld").toString());
                injuredALD.setPercentInjured(Double.parseDouble(params.get(i).get("ssry").toString()));
                injuredALD.setFormula("按烈度");
                injuredALD.setModelVersion(modelVersion+1);
                injuredALD.setCreateTime(updateTime);
                injuredALD.setCreatedBy("江腾飞");
                injuredALD.setUpdateTime(updateTime);
                injuredALD.setUpdatedBy("江腾飞");
                this.injuredMemberMapper.updateInjuredALD(this.injuredALD);
            }

        }
    }
}
