package com.gisinfo.sand.queryGeographyInfo.geographyData.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import javax.persistence.Entity;
import javax.persistence.Id;

//机场实体类
@Entity
@TableName("AIRPORT")
public class Airport {
    //主键
    @Id
    @TableField("OBJECTID")
    private Integer objectId;
    //机场名称
    @TableField("NAME")
    private String airportName;
    //邮政编码
    @TableField("POSTCODE")
    private String postCode;
    //机场地址
    @TableField("LOCATION")
    private String location;
    //飞行区等级
    @TableField("OTHER")
    private String other;
    //是否民用机场
    @TableField("CIVIL")
    private String isCivil;
    //起降机型
    @TableField("PLANE")
    private String plane;
    //简介
    @TableField("NOTE")
    private String note;

    public Integer getObjectId() {
        return objectId;
    }

    public void setObjectId(Integer objectId) {
        this.objectId = objectId;
    }

    public String getAirportName() {
        return airportName;
    }

    public void setAirportName(String airportName) {
        this.airportName = airportName;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }

    public String getIsCivil() {
        return isCivil;
    }

    public void setIsCivil(String isCivil) {
        this.isCivil = isCivil;
    }

    public String getPlane() {
        return plane;
    }

    public void setPlane(String plane) {
        this.plane = plane;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
