package com.gisinfo.sand.queryGeographyInfo.geographyData.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import javax.persistence.Entity;
import javax.persistence.Id;

//查询1970以来小震数据对象
@Entity
@TableName("INSTRUMENT_CATALOG")
public class From1970ToCurrentEQ {
    //主键id
    @Id
    @TableField("OBJECTID")
    private String objectId;
    //震源深度
    @TableField("DEPTH")
    private Double depth;
    //宏观震中烈度
    @TableField("EPICENTER")
    private Double epiCenter;
    //时间
    @TableField("TIME")
    private String time;
    //经度
    @TableField("LONGITUDE")
    private Double longitude;
    //震级
    @TableField("MAGNITUDE")
    private Double magnitude;
    //纬度
    @TableField("LATITUDE")
    private Double latitude;
    //日期
    @TableField("DATE")
    private String date;
    //地名
    @TableField("LOCATION")
    private String location;

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    public Double getDepth() {
        return depth;
    }

    public void setDepth(Double depth) {
        this.depth = depth;
    }

    public Double getEpiCenter() {
        return epiCenter;
    }

    public void setEpiCenter(Double epiCenter) {
        this.epiCenter = epiCenter;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getMagnitude() {
        return magnitude;
    }

    public void setMagnitude(Double magnitude) {
        this.magnitude = magnitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
