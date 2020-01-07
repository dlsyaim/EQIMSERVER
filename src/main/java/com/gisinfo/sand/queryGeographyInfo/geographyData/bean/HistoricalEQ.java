package com.gisinfo.sand.queryGeographyInfo.geographyData.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import javax.persistence.Entity;
import javax.persistence.Id;

//历史强震实体类
@Entity
@TableName("STRONG_CATALOG")
public class HistoricalEQ{
    //主键
    @Id
    @TableField("OBJECTID")
    private Integer objectId;
    //深度
    @TableField("DEPTH")
    private Double depth;
    //宏观震中烈度
    @TableField("EPICENTER")
    private Double epicenter;
    //纬度
    @TableField("LATITUDE")
    private Double latitude;
    //经度
    @TableField("LONGITUDE")
    private Double longitude;
    //日期
    @TableField("DATE")
    private String date;
    //地名
    @TableField("LOCATION")
    private String location;
    //震级
    @TableField("MAGNITUDE")
    private Double magnitude;

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getObjectId() {
        return objectId;
    }

    public void setObjectId(Integer objectId) {
        this.objectId = objectId;
    }

    public Double getDepth() {
        return depth;
    }

    public void setDepth(Double depth) {
        this.depth = depth;
    }

    public Double getEpicenter() {
        return epicenter;
    }

    public void setEpicenter(Double epicenter) {
        this.epicenter = epicenter;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Double getMagnitude() {
        return magnitude;
    }

    public void setMagnitude(Double magnitude) {
        this.magnitude = magnitude;
    }
}
