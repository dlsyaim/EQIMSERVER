package com.gisinfo.sand.systemManage.modelSetting.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
@TableName("T_MODEL_BUILDING")
public class TModelBuilding {

    @Id
    private String featid;

    private String modelName;

    private String buildingType;

    @TableField("I")
    private Integer I;

    @TableField("J")
    private Double J;

    @TableField("Q")
    private Double Q;

    @TableField("Z")
    private Double Z;

    @TableField("Y")
    private Double Y;

    @TableField("D")
    private Double D;

    private String modelType;

    private String modelVersion;

    private Date createTime;

    private String createdBy;

    private String updateTime;

    private String updatedBy;

    private Integer defaultStatus;

    public String getFeatid() {
        return featid;
    }

    public void setFeatid(String featid) {
        this.featid = featid;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public Integer getI() {
        return I;
    }

    public void setI(Integer i) {
        I = i;
    }

    public Double getJ() {
        return J;
    }

    public void setJ(Double j) {
        J = j;
    }

    public Double getQ() {
        return Q;
    }

    public void setQ(Double q) {
        Q = q;
    }

    public Double getZ() {
        return Z;
    }

    public void setZ(Double z) {
        Z = z;
    }

    public Double getY() {
        return Y;
    }

    public void setY(Double y) {
        Y = y;
    }

    public Double getD() {
        return D;
    }

    public void setD(Double d) {
        D = d;
    }

    public String getModelType() {
        return modelType;
    }

    public void setModelType(String modelType) {
        this.modelType = modelType;
    }

    public String getModelVersion() {
        return modelVersion;
    }

    public void setModelVersion(String modelVersion) {
        this.modelVersion = modelVersion;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
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

    public Integer getDefaultStatus() {
        return defaultStatus;
    }

    public void setDefaultStatus(Integer defaultStatus) {
        this.defaultStatus = defaultStatus;
    }

    public String getBuildingType() {
        return buildingType;
    }

    public void setBuildingType(String buildingType) {
        this.buildingType = buildingType;
    }
}
