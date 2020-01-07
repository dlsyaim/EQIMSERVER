package com.gisinfo.sand.systemManage.modelSetting.condition;
//用于保存更新经济损失数据的对象
public class UpdateEconomicLossesCondition {
    //主键featId
    private String featId;
    //参数名称
    private String paramName;
    //地震烈度
    private String i;
    //经济损失
    private Double economicLosses;
    //模型名称
    private String formula;
    //模型版本
    private String modelVersion;
    //数据创建时间
    private String createTime;
    //数据创建人
    private String createdBy;
    //数据更新时间
    private String updateTime;
    //数据更新人
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

    public Double getEconomicLosses() {
        return economicLosses;
    }

    public void setEconomicLosses(Double economicLosses) {
        this.economicLosses = economicLosses;
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
