package com.gisinfo.sand.systemManage.modelSetting.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@TableName("T_MODEL_BUILDING")
public class ConstructionYS {
    @Id
    @TableField("FEATId")
    private String featId;
    @TableField("MODEL_SETTING_FEATID")
    private String modelSettingFeatId;
    @TableField("BUILDING_TYPE")
    private String buildingType;
    @TableField("I")
    private Integer i;
    @TableField("J")
    private Double j;
    @TableField("Q")
    private Double q;
    @TableField("Z")
    private Double z;
    @TableField("Y")
    private Double y;
    @TableField("D")
    private  Double d;

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

    public Integer getI() {
        return i;
    }

    public void setI(Integer i) {
        this.i = i;
    }

    public Double getJ() {
        return j;
    }

    public void setJ(Double j) {
        this.j = j;
    }

    public Double getQ() {
        return q;
    }

    public void setQ(Double q) {
        this.q = q;
    }

    public Double getZ() {
        return z;
    }

    public void setZ(Double z) {
        this.z = z;
    }

    public Double getY() {
        return y;
    }

    public void setY(Double y) {
        this.y = y;
    }

    public Double getD() {
        return d;
    }

    public void setD(Double d) {
        this.d = d;
    }
}
