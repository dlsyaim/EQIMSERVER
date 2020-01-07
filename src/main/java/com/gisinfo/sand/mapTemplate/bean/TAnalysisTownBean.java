package com.gisinfo.sand.mapTemplate.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@TableName("T_ANALYSIS_TOWN")
public class TAnalysisTownBean {
    @Id
    @TableField("FEATID")
    private String featid;

    @TableField("EARTHQUAKE_FEATID")
    private String earthquakeFeatid;

    @TableField("CODE")
    private String code;

    @TableField("TOWN_NAME")
    private String townName;

    @TableField("BATCH_NUMBER")
    private Double batchNumber;

    @TableField("AREA")
    private Double area;

    @TableField("AFFECTED_AREA")
    private Double affectedArea;

    @TableField("INTENSITY")
    private Double intensity;

    @TableField("OFFSET_TYPE")
    private String offsetType;


    public String getFeatid() {
        return featid;
    }

    public void setFeatid(String featid) {
        this.featid = featid;
    }

    public String getEarthquakeFeatid() {
        return earthquakeFeatid;
    }

    public void setEarthquakeFeatid(String earthquakeFeatid) {
        this.earthquakeFeatid = earthquakeFeatid;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTownName() {
        return townName;
    }

    public void setTownName(String townName) {
        this.townName = townName;
    }

    public Double getBatchNumber() {
        return batchNumber;
    }

    public void setBatchNumber(Double batchNumber) {
        this.batchNumber = batchNumber;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public Double getAffectedArea() {
        return affectedArea;
    }

    public void setAffectedArea(Double affectedArea) {
        this.affectedArea = affectedArea;
    }

    public Double getIntensity() {
        return intensity;
    }

    public void setIntensity(Double intensity) {
        this.intensity = intensity;
    }

    public String getOffsetType() {
        return offsetType;
    }

    public void setOffsetType(String offsetType) {
        this.offsetType = offsetType;
    }
}
