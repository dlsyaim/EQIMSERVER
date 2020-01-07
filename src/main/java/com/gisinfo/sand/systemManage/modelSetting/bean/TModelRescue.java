package com.gisinfo.sand.systemManage.modelSetting.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
@TableName("T_MODEL_RESCUE") //救援队伍-按震级
public class TModelRescue {
    @Id
    private String featid;          //	N	VARCHAR2(32)	N			ID

    @TableField("PARAM_NAME")
    private String paramName;      //	N	VARCHAR2(100)	Y			参数名称
    private Double l0;              //	N	NUMBER(10,4)	Y			参数0
    private Double l1;              //	N	NUMBER(10,4)	Y			参数1
    private Double l2;              //	N	NUMBER(10,4)	Y			参数2
    private String formula;         //	N	VARCHAR2(100)	Y			采用的计算方法名称
    @TableField("MODEL_VERSION")
    private String modelVersion;   //	N	VARCHAR2(30)	Y			版本
    @TableField("CREATE_TIME")
    private String createTime;       //	N	DATE Y			创建时间
    @TableField("CREATED_BY")
    private String createdBy;      //	N	VARCHAR2(30)	Y			创建人
    @TableField("UPDATE_TIME")
    private String updateTime;       //	N	DATE	Y			最后修改时间
    @TableField("UPDATED_BY")
    private String updatedBy;      //	N	VARCHAR2(30)	Y			最后修改人
    //private Double defaultStatus;  //	N	NUMBER(10,1)	N			默认状态1默认0为不默认

    public String getFeatid() {
        return featid;
    }

    public void setFeatid(String featid) {
        this.featid = featid;
    }

    public String getParamName() {
        return paramName;
    }

    public void setParamName(String paramName) {
        this.paramName = paramName;
    }

    public Double getL0() {
        return l0;
    }

    public void setL0(Double l0) {
        this.l0 = l0;
    }

    public Double getL1() {
        return l1;
    }

    public void setL1(Double l1) {
        this.l1 = l1;
    }

    public Double getL2() {
        return l2;
    }

    public void setL2(Double l2) {
        this.l2 = l2;
    }

    public String getFormula() {
        return formula;
    }

    public void setFormula(String formula) {
        this.formula = formula;
    }

    public String getModelVersion() {
        return modelVersion;
    }

    public void setModelVersion(String modelVersion) {
        this.modelVersion = modelVersion;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

}
