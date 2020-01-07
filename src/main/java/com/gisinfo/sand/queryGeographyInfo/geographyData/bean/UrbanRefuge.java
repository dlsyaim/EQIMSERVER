package com.gisinfo.sand.queryGeographyInfo.geographyData.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import javax.persistence.Entity;
import javax.persistence.Id;

//城市避难所实体类
@Entity
@TableName("urban_shelters")
public class UrbanRefuge {

    //主键
    @Id
    @TableField("OBJECTID")
    private Integer objectId;

    //名称
    @TableField("REF")
    private String ref;
    //地址
    @TableField("PLACE_ADDRESS")
    private String placeAddress;
    //类型
    @TableField("TYPE")
    private String type;
    //面积
    @TableField("AREA")
    private String area;
    //所属街道
    @TableField("CON")
    private String con;
    //所属区县
    @TableField("CIT")
    private String cit;
    //分类等级
    @TableField("DEG")
    private String deg;
    //日期
    @TableField("DATE_")
    private String date;
    //备注
    @TableField("NOTE_")
    private String note;

    private String pro;//	N	NVARCHAR2(254)	Y

    private String tow;//	N	NVARCHAR2(254)	Y
    private String vil;//	N	NVARCHAR2(254)	Y
    private String refid;//	N	NVARCHAR2(254)	Y

    private String lon;//	N	NVARCHAR2(254)	Y
    private String lat;//	N	NVARCHAR2(254)	Y

    private String cha;//	N	NUMBER(38,8)	Y
    private String sign;//	N	NUMBER(38,8)	Y

    private String entrance;//	N	NVARCHAR2(254)	Y
    private String popref;//	N	NUMBER(38,8)	Y


    public Integer getObjectId() {
        return objectId;
    }

    public void setObjectId(Integer objectId) {
        this.objectId = objectId;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public String getPlaceAddress() {
        return placeAddress;
    }

    public void setPlaceAddress(String placeAddress) {
        this.placeAddress = placeAddress;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCon() {
        return con;
    }

    public void setCon(String con) {
        this.con = con;
    }

    public String getCit() {
        return cit;
    }

    public void setCit(String cit) {
        this.cit = cit;
    }

    public String getDeg() {
        return deg;
    }

    public void setDeg(String deg) {
        this.deg = deg;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getPro() {
        return pro;
    }

    public void setPro(String pro) {
        this.pro = pro;
    }

    public String getTow() {
        return tow;
    }

    public void setTow(String tow) {
        this.tow = tow;
    }

    public String getVil() {
        return vil;
    }

    public void setVil(String vil) {
        this.vil = vil;
    }

    public String getRefid() {
        return refid;
    }

    public void setRefid(String refid) {
        this.refid = refid;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }
    public String getCha() {
        return cha;
    }

    public void setCha(String cha) {
        this.cha = cha;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getEntrance() {
        return entrance;
    }

    public void setEntrance(String entrance) {
        this.entrance = entrance;
    }

    public String getPopref() {
        return popref;
    }

    public void setPopref(String popref) {
        this.popref = popref;
    }
}
