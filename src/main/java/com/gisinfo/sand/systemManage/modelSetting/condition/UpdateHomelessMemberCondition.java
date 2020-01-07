package com.gisinfo.sand.systemManage.modelSetting.condition;
//更新无家可归人员数据
public class UpdateHomelessMemberCondition {
    //主键featId
    private String featId;
    //参数名称
    private String paramName;
    //地震烈度
    private String i;
    //低比例
    private Double proportionLow;
    //中比例
    private Double proportionMedium;
    //高比例
    private Double proportionHigh;
    //模型名称
    private String formula;
    //模型版本
    private String modelVersion;
    //创建时间
    private String createTime;
    //创建人
    private String createdBy;
    //更新时间
    private String updateTime;
    //更新人
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

    public String getI() {
        return i;
    }

    public void setI(String i) {
        this.i = i;
    }

    public Double getProportionLow() {
        return proportionLow;
    }

    public void setProportionLow(Double proportionLow) {
        this.proportionLow = proportionLow;
    }

    public Double getProportionMedium() {
        return proportionMedium;
    }

    public void setProportionMedium(Double proportionMedium) {
        this.proportionMedium = proportionMedium;
    }

    public Double getProportionHigh() {
        return proportionHigh;
    }

    public void setProportionHigh(Double proportionHigh) {
        this.proportionHigh = proportionHigh;
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
