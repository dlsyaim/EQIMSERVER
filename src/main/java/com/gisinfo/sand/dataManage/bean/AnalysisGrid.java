package com.gisinfo.sand.dataManage.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@TableName("T_ANALYSIS_GRID")
public class AnalysisGrid {

    @Id
    @TableField("FEATID")
    private String featid;

    @TableField("EARTHQUAKE_FEATID")
    private String earthquakeFeatid;

    @TableField("BATCH_NUMBER")
    private int batchNumber;

    @TableField("CODE")
    private String code;

    @TableField("GRID_NAME")
    private String gridName;

    @TableField("OFFSET_TYPE")
    private String offsetType;

    @TableField("INTENSITY")
    private int intensity;

    @TableField("AREA")
    private double area;

    @TableField("AFFECTED_AREA")
    private double affectedArea;

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

    public int getBatchNumber() {
        return batchNumber;
    }

    public void setBatchNumber(int batchNumber) {
        this.batchNumber = batchNumber;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getGridName() {
        return gridName;
    }

    public void setGridName(String gridName) {
        this.gridName = gridName;
    }

    public String getOffsetType() {
        return offsetType;
    }

    public void setOffsetType(String offsetType) {
        this.offsetType = offsetType;
    }

    public int getIntensity() {
        return intensity;
    }

    public void setIntensity(int intensity) {
        this.intensity = intensity;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public double getAffectedArea() {
        return affectedArea;
    }

    public void setAffectedArea(double affectedArea) {
        this.affectedArea = affectedArea;
    }
}
