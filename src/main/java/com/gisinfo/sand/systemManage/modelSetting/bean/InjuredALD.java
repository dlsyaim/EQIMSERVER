package com.gisinfo.sand.systemManage.modelSetting.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import javax.persistence.Entity;
import javax.persistence.Id;

//受伤人员按烈度
@Entity
@TableName("T_MODEL_INJURED")
public class InjuredALD {
    //主键
    @Id
    @TableField("FEATID")
    private String featId;
    //参数名称
    @TableField("PARAM_NAME")
    private String paramName;
    //模型名称
    @TableField("FORMULA")
    private String formula;
    //受伤人员百分比
    @TableField("PERCENT_INJURED")
    private Double percentInjured;
    //固定参数L0
    @TableField("L0")
    private Double l0;
    //地震震级
    @TableField("SCALE")
    private String scale;
    //数据版本
    @TableField("MODEL_VERSION")
    private Integer modelVersion;
    //创建时间
    @TableField("CREATE_TIME")
    private String createTime;
    //创建人
    @TableField("CREATED_BY")
    private String createdBy;
    //修改时间
    @TableField("UPDATE_TIME")
    private String updateTime;
    //修改人
    @TableField("UPDATED_BY")
    private String updatedBy;


    public String getFeatId() {
        return featId;
    }

    public void setFeatId(String featId) {
        this.featId = featId;
    }

    public String getParamName() {
        return paramName;
    }

    public void setParamName(String paramName) {
        this.paramName = paramName;
    }

    public String getFormula() {
        return formula;
    }

    public void setFormula(String formula) {
        this.formula = formula;
    }

    public Double getPercentInjured() {
        return percentInjured;
    }

    public void setPercentInjured(Double percentInjured) {
        this.percentInjured = percentInjured;
    }

    public Double getL0() {
        return l0;
    }

    public void setL0(Double l0) {
        this.l0 = l0;
    }

    public String getScale() {
        return scale;
    }

    public void setScale(String scale) {
        this.scale = scale;
    }

    public Integer getModelVersion() {
        return modelVersion;
    }

    public void setModelVersion(Integer modelVersion) {
        this.modelVersion = modelVersion;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
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
