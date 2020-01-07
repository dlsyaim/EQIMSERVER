package com.gisinfo.sand.systemManage.modelSetting.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@TableName("t_model_deaths")
public class DeathPersonModel {
    @Id
    @TableField("FEATID")
    private String featId;                  //id
//    @TableField("MODEL_SETTING_FEATID")
//    private String modelSettingFeatid;    //评估模型设置表ID
    @TableField("PARAM_NAME")
    private String paramName;              //参数名称
    @TableField("L0")
    private Double l0;                      //参数0
    @TableField("L1")
    private Double l1;                      //参数1
    @TableField("L2")
    private Double l2;                      //参数2
    @TableField("FORMULA")
    private String formula;                 //采用的计算方法名称
    @TableField("MODEL_VERSION")
    private String modelVersion;           //版本
    @TableField("CREATE_TIME")
    private String createTime;               //创建时间
    @TableField("CREATED_BY")
    private String createdBy;              //创建人
    @TableField("UPDATE_TIME")
    private String updateTime;               //最后修改时间
    @TableField("UPDATED_BY")
    private String updatedBy;              //最后修改人
    @TableField("DEFAULT_STATUS")
    private String defaultStatus;

    private Integer pageNo;
    private Integer pageSize;
    private Integer bottom;
    private Integer top;

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

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public String getDefaultStatus() {
        return defaultStatus;
    }

    public void setDefaultStatus(String defaultStatus) {
        this.defaultStatus = defaultStatus;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getBottom() {
        return bottom;
    }

    public void setBottom(Integer bottom) {
        this.bottom = bottom;
    }

    public Integer getTop() {
        return top;
    }

    public void setTop(Integer top) {
        this.top = top;
    }
}
