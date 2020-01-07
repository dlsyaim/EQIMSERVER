package com.gisinfo.sand.dataManage.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@TableName("T_GEO_RESULT")
public class EarthquakeGeo {

    @Id
    @TableField("FEATID")
    private String featid;

    @TableField("EARTHQUAKE_FEATID")
    private String earthquakeFeatid;

    @TableField("BATCH_NUMBER")
    private int batchNumber;

    @TableField("GEO")
    private String geo;

    @TableField("OFFSET_TYPE")
    private String offsetType;

    @TableField("SHAPE_TYPE")
    private String shapeType;

    @TableField("INTENSITY")
    private int intensity;

    @TableField("AREA")
    private double area;

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

    public String getGeo() {
        return geo;
    }

    public void setGeo(String geo) {
        this.geo = geo;
    }

    public String getOffsetType() {
        return offsetType;
    }

    public void setOffsetType(String offsetType) {
        this.offsetType = offsetType;
    }

    public String getShapeType() {
        return shapeType;
    }

    public void setShapeType(String shapeType) {
        this.shapeType = shapeType;
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
}
