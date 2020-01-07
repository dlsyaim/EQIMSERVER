package com.gisinfo.sand.systemManage.modelSetting.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@TableName("T_MODEL_BUILDING")
public class ConstructionPHB {
    @Id
    @TableField("FEATId")
    private String featId;
    @TableField("MODEL_SETTING_FEATID")
    private String modelSettingFeatId;
    @TableField("BUILDING_TYPE")
    private String buildingType;
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

    public String getFeatId() {
        return featId;
    }

    public void setFeatId(String featId) {
        this.featId = featId;
    }

    public String getModelSettingFeatId() {
        return modelSettingFeatId;
    }

    public void setModelSettingFeatId(String modelSettingFeatId) {
        this.modelSettingFeatId = modelSettingFeatId;
    }

    public String getBuildingType() {
        return buildingType;
    }

    public void setBuildingType(String buildingType) {
        this.buildingType = buildingType;
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
}
