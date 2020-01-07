package com.gisinfo.sand.commonData.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@TableName("city_building")
public class EqCityBuilding {//城市房屋总体统计
    @Id
    private Double objectid;             //	N	INTEGER	N
    @TableField("BRICK_STRUCTURE")
    private Double brickStructure;      //	N	NUMBER(38,8)	Y
    @TableField("BRICK_PROPERTY")
    private Double brickProperty;       //	N	NUMBER(38,8)	Y
    @TableField("OTHER_PRICE")
    private Double otherPrice;          //	N	NUMBER(38,8)	Y
    @TableField("OTHER_PROPERTY")
    private Double otherProperty;       //	N	NUMBER(38,8)	Y
    @TableField("OTHER_STRUCTURE")
    private Double otherStructure;      //	N	NUMBER(38,8)	Y
    @TableField("TOTAL_AREA")
    private Double totalArea;            //	N	NUMBER(38,8)	Y
    private Double totalAreaMin;
    private Double totalAreaMax;

    private Double average;              //	N	NUMBER(38,8)	Y
    private Double averageMin;
    private Double averageMax;

    @TableField("HIGH_RISE")
    private Double highRise;            //	N	NUMBER(38,8)	Y
    @TableField("HIGH_RISE_PRICE")
    private Double highRisePrice;      //	N	NUMBER(38,8)	Y
    @TableField("HIGH_RISE_PROPERTY")
    private Double highRiseProperty;   //	N	NUMBER(38,8)	Y
    private Double rcframe;              //	N	NUMBER(38,8)	Y
    @TableField("RCFRAME_PRICE")
    private Double rcframePrice;        //	N	NUMBER(38,8)	Y
    @TableField("RCFRAME_PROPERTY")
    private Double rcframeProperty;     //	N	NUMBER(38,8)	Y
    @TableField("SINGLE_AREA")
    private Double singleArea;          //	N	NUMBER(38,8)	Y
    @TableField("SINGLE_PRICE")
    private Double singlePrice;         //	N	NUMBER(38,8)	Y
    @TableField("SINGLE_PROPERTY")
    private Double singleProperty;      //	N	NUMBER(38,8)	Y
    @TableField("BRICK_PRICE")
    private Double brickPrice;          //	N	NUMBER(38,8)	Y
    private String id;                   //	N	NVARCHAR2(14)	Y
    private String name;                 //	N	NVARCHAR2(40)	Y

    private Integer pageNo;
    private Integer pageSize;
    private Integer bottom;
    private Integer top;

    public Double getTotalAreaMin() {
        return totalAreaMin;
    }

    public void setTotalAreaMin(Double totalAreaMin) {
        this.totalAreaMin = totalAreaMin;
    }

    public Double getTotalAreaMax() {
        return totalAreaMax;
    }

    public void setTotalAreaMax(Double totalAreaMax) {
        this.totalAreaMax = totalAreaMax;
    }

    public Double getAverageMin() {
        return averageMin;
    }

    public void setAverageMin(Double averageMin) {
        this.averageMin = averageMin;
    }

    public Double getAverageMax() {
        return averageMax;
    }

    public void setAverageMax(Double averageMax) {
        this.averageMax = averageMax;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getBottom() {
        return bottom;
    }

    public void setBottom(Integer bottom) {
        this.bottom = bottom;
    }

    public Integer getTop() {
        return top;
    }

    public void setTop(Integer top) {
        this.top = top;
    }

    public Double getObjectid() {
        return objectid;
    }

    public void setObjectid(Double objectid) {
        this.objectid = objectid;
    }

    public Double getBrickStructure() {
        return brickStructure;
    }

    public void setBrickStructure(Double brickStructure) {
        this.brickStructure = brickStructure;
    }

    public Double getBrickProperty() {
        return brickProperty;
    }

    public void setBrickProperty(Double brickProperty) {
        this.brickProperty = brickProperty;
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

    public Double getRcframe() {
        return rcframe;
    }

    public void setRcframe(Double rcframe) {
        this.rcframe = rcframe;
    }

    public Double getRcframePrice() {
        return rcframePrice;
    }

    public void setRcframePrice(Double rcframePrice) {
        this.rcframePrice = rcframePrice;
    }

    public Double getRcframeProperty() {
        return rcframeProperty;
    }

    public void setRcframeProperty(Double rcframeProperty) {
        this.rcframeProperty = rcframeProperty;
    }

    public Double getSingleArea() {
        return singleArea;
    }

    public void setSingleArea(Double singleArea) {
        this.singleArea = singleArea;
    }

    public Double getSinglePrice() {
        return singlePrice;
    }

    public void setSinglePrice(Double singlePrice) {
        this.singlePrice = singlePrice;
    }

    public Double getSingleProperty() {
        return singleProperty;
    }

    public void setSingleProperty(Double singleProperty) {
        this.singleProperty = singleProperty;
    }

    public Double getBrickPrice() {
        return brickPrice;
    }

    public void setBrickPrice(Double brickPrice) {
        this.brickPrice = brickPrice;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
