package com.gisinfo.sand.systemManage.modelSetting.condition;

public class UpdateJZJJSSBcondition {
    private String featId;
    private String modelName;
    private String modelType;
    private String createTime;
    private String createdBy;
    //基本完好
    private Double jbwh;
    //轻度破坏
    private Double qdph;
    //中度破坏
    private Double zdph;
    //严重破坏
    private Double yzph;
    //毁坏
    private Double hh;
    //模型版本
    private String modelVersion;
    //修改时间
    private String updateTime;
    //修改人
    private String updatedBy;

    public String getFeatId() {
        return featId;
    }

    public void setFeatId(String featId) {
        this.featId = featId;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getModelType() {
        return modelType;
    }

    public void setModelType(String modelType) {
        this.modelType = modelType;
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

    public Double getJbwh() {
        return jbwh;
    }

    public void setJbwh(Double jbwh) {
        this.jbwh = jbwh;
    }

    public Double getQdph() {
        return qdph;
    }

    public void setQdph(Double qdph) {
        this.qdph = qdph;
    }

    public Double getZdph() {
        return zdph;
    }

    public void setZdph(Double zdph) {
        this.zdph = zdph;
    }

    public Double getYzph() {
        return yzph;
    }

    public void setYzph(Double yzph) {
        this.yzph = yzph;
    }

    public Double getHh() {
        return hh;
    }

    public void setHh(Double hh) {
        this.hh = hh;
    }

    public String getModelVersion() {
        return modelVersion;
    }

    public void setModelVersion(String modelVersion) {
        this.modelVersion = modelVersion;
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
