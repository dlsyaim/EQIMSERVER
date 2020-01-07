package com.gisinfo.sand.queryGeographyInfo.geographyData.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import javax.persistence.Entity;
import javax.persistence.Id;
//台站实体类
@Entity
@TableName("observation_station")
public class Station {
    //主键
    @Id
    @TableField("OBJECTID")
    private Integer objectId;
    //台点名称
    private String name;

    @TableField("COMMENT_")
    private String comments;//	N	NVARCHAR2(100)	Y
    @TableField("CLASS")
    private String classs;//	N	NVARCHAR2(6)	Y
    private String email;//	N	NVARCHAR2(40)	Y
    private String fax;//	N	NVARCHAR2(18)	Y
    private String instrument;//	N	NVARCHAR2(200)	Y
    private String item;//	N	NVARCHAR2(200)	Y
    private String basement;//	N	NVARCHAR2(50)	Y
    private String longitude;//	N	NUMBER(38,8)	Y
    private String mp;//	N	NVARCHAR2(18)	Y
    @TableField("STATION_ID")
    private String stationId;//	N	NVARCHAR2(20)	Y
    private String tel;//	N	NVARCHAR2(18)	Y
    @TableField("LEVEL_")
    private String levels;//	N	NVARCHAR2(6)	Y
    private String latitude;//	N	NUMBER(38,8)	Y


    public Integer getObjectId() {
        return objectId;
    }

    public void setObjectId(Integer objectId) {
        this.objectId = objectId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getClasss() {
        return classs;
    }

    public void setClasss(String classs) {
        this.classs = classs;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getInstrument() {
        return instrument;
    }

    public void setInstrument(String instrument) {
        this.instrument = instrument;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getBasement() {
        return basement;
    }

    public void setBasement(String basement) {
        this.basement = basement;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getMp() {
        return mp;
    }

    public void setMp(String mp) {
        this.mp = mp;
    }

    public String getStationId() {
        return stationId;
    }

    public void setStationId(String stationId) {
        this.stationId = stationId;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getLevels() {
        return levels;
    }

    public void setLevels(String levels) {
        this.levels = levels;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }
}
