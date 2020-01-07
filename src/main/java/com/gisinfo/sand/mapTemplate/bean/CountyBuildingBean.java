package com.gisinfo.sand.mapTemplate.bean;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@TableName("county_building")
public class CountyBuildingBean {
    @Id
    @TableField("OBJECTID")
    private Double objectid;

    @TableField("BRICK_PRICE")
    private Double brickPrice;

    @TableField("SINGLE_PROPERTY")
    private Double singleProperty;

    @TableField("BRICK_STRUCTURE")
    private Double brickStructure;

    @TableField("OTHER_PRICE")
    private Double otherPrice;

    @TableField("OTHER_PROPERTY")
    private Double otherProperty;

    @TableField("OTHER_STRUCTURE")
    private Double otherStructure;

    @TableField("BRICK_PRICE")
    private Double totalArea;

    @TableField("AVERAGE")
    private Double average;

    @TableField("HIGH_RISE")
    private Double highRise;

    @TableField("HIGH_RISE_PRICE")
    private Double highRisePrice;

    @TableField("HIGH_RISE_PROPERTY")
    private Double highRiseProperty;


    public Double getObjectid() {
        return objectid;
    }

    public void setObjectid(Double objectid) {
        this.objectid = objectid;
    }

    public Double getBrickPrice() {
        return brickPrice;
    }

    public void setBrickPrice(Double brickPrice) {
        this.brickPrice = brickPrice;
    }

    public Double getSingleProperty() {
        return singleProperty;
    }

    public void setSingleProperty(Double singleProperty) {
        this.singleProperty = singleProperty;
    }

    public Double getBrickStructure() {
        return brickStructure;
    }

    public void setBrickStructure(Double brickStructure) {
        this.brickStructure = brickStructure;
    }

    public Double getOtherPrice() {
        return otherPrice;
    }

    public void setOtherPrice(Double otherPrice) {
        this.otherPrice = otherPrice;
    }

    public Double getOtherProperty() {
        return otherProperty;
    }

    public void setOtherProperty(Double otherProperty) {
        this.otherProperty = otherProperty;
    }

    public Double getOtherStructure() {
        return otherStructure;
    }

    public void setOtherStructure(Double otherStructure) {
        this.otherStructure = otherStructure;
    }

    public Double getTotalArea() {
        return totalArea;
    }

    public void setTotalArea(Double totalArea) {
        this.totalArea = totalArea;
    }

    public Double getAverage() {
        return average;
    }

    public void setAverage(Double average) {
        this.average = average;
    }

    public Double getHighRise() {
        return highRise;
    }

    public void setHighRise(Double highRise) {
        this.highRise = highRise;
    }

    public Double getHighRisePrice() {
        return highRisePrice;
    }

    public void setHighRisePrice(Double highRisePrice) {
        this.highRisePrice = highRisePrice;
    }

    public Double getHighRiseProperty() {
        return highRiseProperty;
    }

    public void setHighRiseProperty(Double highRiseProperty) {
        this.highRiseProperty = highRiseProperty;
    }
}
