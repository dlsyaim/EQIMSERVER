package com.gisinfo.sand.systemManage.modelSetting.condition;
//更新压埋人员按城市比例模型数据
public class UpdateBuriedACSBLcondition {
    //主键featId
    private String featId;
    //参数名称
    private String paramName;
    //类别
    private String category;
    //压埋人员百分比
    private Double percentBuried;
    //模型类型
    private String formula;
    //模型版本
    private String modelVersion;
    //数据创建时间
    private String createTime;
    //数据创建人
    private String createdBy;
    //数据更新时间
    private String updateTime;
    //数据跟新人
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Double getPercentBuried() {
        return percentBuried;
    }

    public void setPercentBuried(Double percentBuried) {
        this.percentBuried = percentBuried;
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
